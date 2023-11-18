# vax

## Descrição

---

## Exemplos da Api

### Cadastro de Usuario
`POST` /registrar
**Request**
```js
{
  "nome": "Emerson Silva",
  "email": "emerson@email.com",
  "senha": "senha123",
  "dataNascimento": "1996-11-08",
  "cep": "06420430",
  "genero": "Masculino"
}
```
`STATUS ESPERADO` -201
Explicação - Ao fazer o cadastro é gerado automaticamente um formulário com todas as vacinas disponíveis para tomar.
---
### Login Usuário
`POST` /login
**Request**
```js
{
  "email": "emerson@email.com",
  "senha": "senha123"
}
```
`STATUS ESPERADO` -200
Explicação - Ao fazer o login vai ser verificado se está todas informações corretas, se assim for, retornará um objeto com os dados importantes para o projeto e o token no headers.
**Response**
```js
{
  "nome": "Emerson Silva",
  "email": "emerson@email.com",
  "dataNascimento": "1996-11-08",
  "cep": "06420430"
}
```
---


