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

Explicação - Ao fazer a requisição, caso as informações estejam corretas, retorna 
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
