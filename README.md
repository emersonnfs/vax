# vax
- MENU
  - [Descrição](#descrição)
  - [Exemplos Api](#exemplos-da-api)
  - [How to do Cloud](#how-to-do-cloud) 

## Descrição

### Url da Api
URL: https://app-vax.azurewebsites.net
---
### Postman api link
https://www.postman.com/emersonnfs1996/workspace/studit-api/collection/23679644-bcc023d7-cf85-4518-8e94-364b12f69cb0?action=share&creator=23679644
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
`STATUS ESPERADO` 201

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
`STATUS ESPERADO` 200

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
### Get Formulário
`GET` /form-vacinas/{id}

**Request**
```js

```
obs- Lembrar de passar o token de validação no headers

`STATUS ESPERADO` 200

Explicação - Ao fazer a requisição, caso as informações estejam corretas será retornado o formulário com todas as informações das vacinas possíveis a ser tomado por da uma pessoa da idade do usuário, ao usuário ser cadastrado o usuário terá as informações todas as vacinas cadastradas como false e com isso pode se alterar para o status correto.

**Response**
```js
{
    "Adolescente": {
        "TripliceViral": [
            {
                "id": 82,
                "nome": "Tríplice viral (sarampo, caxumba e rubéola)",
                "descricao": "Previne sarampo, caxumba e rubéola.",
                "categoria": "Adolescente",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 83,
                "nome": "Tríplice viral (sarampo, caxumba e rubéola)",
                "descricao": "Previne sarampo, caxumba e rubéola.",
                "categoria": "Adolescente",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "DuplaAdulto": [
            {
                "id": 92,
                "nome": "Dupla Adulto (dT)",
                "descricao": "Previne difteria e tétano.",
                "categoria": "Adolescente",
                "dose": "Periodica",
                "status": false
            }
        ],
        "FebreAmarela": [
            {
                "id": 78,
                "nome": "Febre amarela",
                "descricao": "Previne a febre amarela.",
                "categoria": "Adolescente",
                "dose": "DoseUnica",
                "status": false
            }
        ],
        "HPV": [
            {
                "id": 86,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Adolescente",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 87,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Adolescente",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "HepatiteB": [
            {
                "id": 50,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adolescente",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 51,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adolescente",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 52,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adolescente",
                "dose": "TerceiraDose",
                "status": false
            }
        ],
        "MeningococicaC": [
            {
                "id": 76,
                "nome": "Meningocócica C conjugada",
                "descricao": "Previne a doença meningocócica C.",
                "categoria": "Adolescente",
                "dose": "DoseUnica",
                "status": false
            }
        ]
    },
    "Criança": {
        "TripliceViral": [
            {
                "id": 81,
                "nome": "Tríplice viral (sarampo, caxumba e rubéola)",
                "descricao": "Previne sarampo, caxumba e rubéola.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            }
        ],
        "Poliomielite": [
            {
                "id": 64,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 65,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 66,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "TerceiraDose",
                "status": false
            },
            {
                "id": 67,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "PrimeiroReforco",
                "status": false
            },
            {
                "id": 68,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "SegundoReforco",
                "status": false
            }
        ],
        "FebreAmarela": [
            {
                "id": 77,
                "nome": "Febre amarela",
                "descricao": "Previne a febre amarela.",
                "categoria": "Criança",
                "dose": "DoseUnica",
                "status": false
            }
        ],
        "HepatiteA": [
            {
                "id": 85,
                "nome": "Hepatite A",
                "descricao": "Previne a hepatite A.",
                "categoria": "Criança",
                "dose": "DoseUnica",
                "status": false
            }
        ],
        "Rotavirus": [
            {
                "id": 72,
                "nome": "Vacina rotavírus humano G1P1",
                "descricao": "Previne diarreia por rotavírus.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 73,
                "nome": "Vacina rotavírus humano G1P1",
                "descricao": "Previne diarreia por rotavírus.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "Pentavalente": [
            {
                "id": 59,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 60,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 61,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "TerceiraDose",
                "status": false
            },
            {
                "id": 62,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "PrimeiroReforco",
                "status": false
            },
            {
                "id": 63,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "SegundoReforco",
                "status": false
            }
        ],
        "HepatiteB": [
            {
                "id": 49,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            }
        ],
        "MeningococicaC": [
            {
                "id": 74,
                "nome": "Meningocócica C conjugada",
                "descricao": "Previne a doença meningocócica C.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 75,
                "nome": "Meningocócica C conjugada",
                "descricao": "Previne a doença meningocócica C.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "BCG": [
            {
                "id": 48,
                "nome": "BCG (Bacilo Calmette-Guerin)",
                "descricao": "Previne as formas graves de tuberculose, principalmente miliar e meníngea.",
                "categoria": "Criança",
                "dose": "DoseUnica",
                "status": false
            }
        ],
        "Pneumococica10V": [
            {
                "id": 69,
                "nome": "Pneumocócica 10V",
                "descricao": "Previne pneumonia, otite, meningite e outras doenças causadas pelo Pneumococo.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 70,
                "nome": "Pneumocócica 10V",
                "descricao": "Previne pneumonia, otite, meningite e outras doenças causadas pelo Pneumococo.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 71,
                "nome": "Pneumocócica 10V",
                "descricao": "Previne pneumonia, otite, meningite e outras doenças causadas pelo Pneumococo.",
                "categoria": "Criança",
                "dose": "PrimeiroReforco",
                "status": false
            }
        ]
    }
}
```
---
### Atualizar status vacina
`PUT` /status-vacinas

**Request**
```js
[
    {
        "id": 180,
        "status": true
    },
    {
        "id": 143,
        "status": true
    }
]
```
obs- Lembrar de passar o token de validação no headers

`STATUS ESPERADO` 200

Explicação - O formulário criado automaticamente irá fornecer os dados de cada vacina, tipo, qual dose entre outros e para atualizar esse status será passada uma lista com o id de cada vacina e o stataus true ou false

**Response**
```js
Status das vacinas atualizado com sucesso.
```
---
### Atualizar Usuario
`PUT` /usuario/{id}

**Request**
```js
{
    "nome":"Emerson Silva",
    "dataNascimento":"1996-11-08",
    "email":"emerson@gmail.com",
    "cep": "05716120"
}
```
obs- Lembrar de passar o token de validação no headers

`STATUS ESPERADO` 200

Explicação - É necessário passar o 4 campos no corpo da requisição, a senha para atualizar precisa ser um método separado.

**Response**
```js
{
    "id": 5,
    "nome": "Emerson Silva",
    "email": "emerson@gmail.com",
    "dataNascimento": "1996-11-08",
    "cep": "05716120"
}
```
---
### Get Usuario por Id
`GET` /usuario/{id}

**Request**
```js
```
obs- Lembrar de passar o token de validação no headers
`STATUS ESPERADO` 200

Explicação - É necessário passar o id do usuario como parâmetro que deseja buscar a informação.
**Response**
```js
{
    "id": 5,
    "nome": "Emerson Silva",
    "email": "emerson@gmail.com",
    "dataNascimento": "1996-11-08",
    "cep": "05716120"
}
```
---
### Atualizar senha Usuário
`POST` /atualizar-senha

**Request**
```js
{
    "id":"5",
    "senhaAntiga":"senha123",
    "senhaNova": "123senha"
}
```
obs- Lembrar de passar o token de validação no headers

`STATUS ESPERADO` 200

Explicação - É necessário passar o id do usuario, a senha antiga e a senha nova no corpo da requisição para atualizar senha e após isso fazer um novo login para atualizar o token.
**Response**
```js
{
    "id": 5,
    "nome": "Emerson Silva",
    "email": "emerson@gmail.com",
    "dataNascimento": "1996-11-08",
    "cep": "05716120"
}
```
---
### Listar Vacinas Pendentes
`GET` /vacinas-pendententes/{id}

**Request**
```js
```
obs- Lembrar de passar o token de validação no headers

`STATUS ESPERADO` 200

Explicação - É necessário passar o id do Usuario como parametro e ele ira retornar um lista com os nomes das vacinas que estão pendentes.
**Response**
```js
[
    "Hepatite B",
    "Pentavalente",
    "Poliomielite",
    "Pneumocócica 10V",
    "Rotavírus",
    "Meningocócica C",
    "Febre Amarela",
    "Tríplice Viral",
    "Tetra Viral",
    "HPV"
]
```
---
### Delete Usuario
`DELETE` /usuario/{id}

**Request**
```js
```
obs- Lembrar de passar o token de validação no headers

`STATUS ESPERADO` 200

Explicação - É necessário passar o id do usuário como parâmetro e ao deletar ele será removido tudo que ele estiver relacionado.
**Response**
```js
```
---

## How to do Cloud

### Criado o Servidor SQL e o Banco no portal da Azure
Comandos no Azure Client
``` js
az group create --name rg-bcosql --location brazilsouth
az sql server create -l brazilsouth -g rg-bcosql -n sqlserver-rm95199 -u admsql -p devops@Fiap2tds --enable-public-network true
az sql db create -g rg-bcosql -s sqlserver-rm95199 -n lifeshare --service-objective Basic --backup-storage-redundancy Local --zone-redundant false
az sql server firewall-rule create -g rg-bcosql -s sqlserver-rm95199 -n AllowAll --start-ip-address 0.0.0.0 --end-ip-address 255.255.255.255
```
Servidor SQL
![image](https://github.com/emersonnfs/vax/assets/101301360/a358954c-5dda-48c6-8868-745da54b6f28)

SQL Database liveshare
![image](https://github.com/emersonnfs/vax/assets/101301360/62b7fb09-ad0e-4207-b12c-9016b171211d)
---

### Criado Deploy de Web App Azure
Após baixar o plugin da Azure no Intellij em Tools>Azure>Deploy to Azure Web Apps
![image](https://github.com/emersonnfs/vax/assets/101301360/919523fa-5547-45ab-b4b5-a1e3dc5599a2)

Escolha a plataforma e nome(que será o domínio)
![image](https://github.com/emersonnfs/vax/assets/101301360/11e60ddf-52e9-4953-ba3d-dccb529b40d3)

Aperte Run e o Web App será feito a criação do Grupo de Recursos , Plano de Serviço e Serviço de APP
![image](https://github.com/emersonnfs/vax/assets/101301360/b475cbb0-c9d1-424e-a0d3-bab21c9b60a2)

Criado o Grupo de Recursos e o Plano de Serviço
![image](https://github.com/emersonnfs/vax/assets/101301360/d58d3d3c-a601-4104-b6d6-1cf692cf8f0b)

Criado o Web App na Azure com a URL funcional
![image](https://github.com/emersonnfs/vax/assets/101301360/fa374823-4176-4113-a1d8-4eaa9398b6e8)
