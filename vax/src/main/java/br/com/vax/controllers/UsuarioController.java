package br.com.vax.controllers;

import br.com.vax.entities.Credencial;
import br.com.vax.entities.Usuario;
import br.com.vax.models.UsuarioLoginResponse;
import br.com.vax.repositories.UsuarioRepository;
import br.com.vax.services.TokenService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


    private ModelMapper modelMapper;
    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponse> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        Optional<Usuario> usuarioOptional = repository.findByEmail(credencial.email());

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            this.modelMapper = new ModelMapper();

            UsuarioLoginResponse usuarioLoginResponse = modelMapper.map(usuario, UsuarioLoginResponse.class);

            return ResponseEntity.ok()
                    .header("Authorization", token.toString())
                    .body(usuarioLoginResponse);
        }

        return ResponseEntity.badRequest().build();
    }
}
