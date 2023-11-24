package br.com.vax.controllers;

import br.com.vax.entities.Credencial;
import br.com.vax.entities.GeneroEnum;
import br.com.vax.entities.Token;
import br.com.vax.entities.Usuario;
import br.com.vax.models.LoginResponse;
import br.com.vax.models.UpdateDadosUsuario;
import br.com.vax.models.UpdateSenhaUsuario;
import br.com.vax.models.UsuarioLoginResponse;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.services.TokenService;
import br.com.vax.services.VacinaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @Autowired
    VacinaService vacinaService;


    private ModelMapper modelMapper;
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody @Valid Usuario usuario) {
        Optional<Usuario> usuarioOptional = repository.findByEmail(usuario.getEmail());
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        if (usuario.getGenero() == GeneroEnum.Feminino){
            for(int i = 0; i <= 48; i++){
                vacinaService.cadastrarStatusVacina(usuario.getId(), (long) i);
            }
        }
        else {
            for(int i = 0; i < 48; i++){
                vacinaService.cadastrarStatusVacina(usuario.getId(), (long) i);
            }
        }
        this.modelMapper = new ModelMapper();
        UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(usuarioLoginResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        Optional<Usuario> usuarioOptional = repository.findByEmail(credencial.email());

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            this.modelMapper = new ModelMapper();

            UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);
            LoginResponse response = new LoginResponse(token, usuarioLoginResponse);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/atualizar-senha")
    public ResponseEntity<UsuarioLoginResponse> atualizarSenha(@RequestBody UpdateSenhaUsuario updateSenhaUsuario){
        Optional<Usuario> usuarioOptional = repository.findById(updateSenhaUsuario.getId());
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            if (encoder.matches(updateSenhaUsuario.getSenhaAntiga(), usuario.getSenha())){
                usuario.setSenha(encoder.encode(updateSenhaUsuario.getSenhaNova()));
                repository.save(usuario);
                this.modelMapper = new ModelMapper();

                UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);

                return ResponseEntity.ok().body(usuarioLoginResponse);
            }else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<UsuarioLoginResponse> atualizar(@PathVariable Long id,
                                                          @RequestBody UpdateDadosUsuario usuarioUpdate){
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioUpdate.getNome());
            usuario.setEmail(usuarioUpdate.getEmail());
            usuario.setDataNascimento(usuarioUpdate.getDataNascimento());
            usuario.setCep(usuarioUpdate.getCep());
            repository.save(usuario);
            this.modelMapper = new ModelMapper();

            UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);

            return ResponseEntity.ok().body(usuarioLoginResponse);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioLoginResponse> buscar(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            this.modelMapper = new ModelMapper();

            UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);

            return ResponseEntity.ok().body(usuarioLoginResponse);
        }
        return ResponseEntity.badRequest().build();
    }

    //Get all apenas para testes em produção
    @GetMapping("/usuario")
    ResponseEntity<List<UsuarioLoginResponse>> listarTodos(){
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioLoginResponse> usuarioLoginResponses = new ArrayList<>();
        for (Usuario usuario : usuarios){
            this.modelMapper = new ModelMapper();

            UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);

            usuarioLoginResponses.add(usuarioLoginResponse);
        }
        return ResponseEntity.ok().body(usuarioLoginResponses);
    }

    @DeleteMapping("/usuario/{id}")
    ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            repository.delete(usuario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
