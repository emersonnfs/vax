# vax
- MENU
  - [Integrantes](#integrantes)   
  - [Descrição](#descrição)
  - [Exemplos Api](#exemplos-da-api)
  - [How to do Cloud](#how-to-do-cloud) 

## Integrantes
  *TURMA 2-TDSR*
  
  *Abner Rodrigues Ferreira - RM: 93576*
  
  *Davi Oliveira Da Silva - RM: 95535*
  
  *Emerson Nascimento Figueredo Silva - RM:95199*
  
  *Guilherme De Jesus Ferreira - RM: 95542*
  
  *João Victor Oliveira Da Silva - RM: 94231*

---
## Link Youtube
### Link para DEVOPS TOOLS E CLOUD COMPUTING
https://youtu.be/OLuGKN0uHKI?si=8ImIevSNNfectkJg

---
### Link para DIGITAL BUSINESS ENABLEMENT
https://youtu.be/FFshWuRD9J4?si=_gTvKOiKjSkVSwVD

---
## Descrição
Atualmente, é evidente que nem todas as pessoas têm acesso à imunização adequada. No Brasil, mais de 69 milhões de cidadãos ainda não receberam a primeira dose da vacina contra a COVID-19, conforme divulgado pelo governo brasileiro. 
A pergunta que surge é: por que essa lacuna existe? A resposta remonta à persistente desigualdade que permeia o país desde o seu surgimento, sendo um dos principais obstáculos para a plena vacinação.

Nos dá VAX temos uma resposta direta a essa desigualdade. Trata-se de um aplicativo gratuito destinado a possibilitar que pessoas em todo o território nacional identifiquem quais vacinas são recomendadas para elas e onde podem recebê-las com facilidade. O aplicativo desempenhará um papel crucial ao ajudar os indivíduos a se organizar, fornecendo um calendário de vacinação e permitindo que se preparem de maneira adequada para receber as doses necessárias. 
Além disso, oferecerá informações sobre quais vacinas ainda estão pendentes, permitindo que as pessoas se programem de forma eficaz e, assim, melhorem sua qualidade de vida.

Acreditamos que a cultura DevOps pode simplificar consideravelmente a experiência do usuário final. Propomos a implementação de um banco de dados na nuvem, o que proporcionará maior segurança para informações sensíveis. Ao migrar para a nuvem, eliminaremos as preocupações relacionadas ao hardware.

Ao optar por uma aplicação em ambiente de nuvem, garantiremos um armazenamento de informações mais ágil e, acima de tudo, manteremos a integridade dos dados. Essa abordagem não apenas otimiza o desempenho, mas também reforça a segurança, oferecendo uma solução eficiente e confiável para atender às necessidades dos usuários.

---
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
  "email": "ana@email.com",
  "senha": "senha123"
}
```
`STATUS ESPERADO` 200

Explicação - Ao fazer o login vai ser verificado se está todas informações corretas, se assim for, retornará um objeto com os dados importantes para o projeto e o token no headers.
**Response**
```js
{
    "token": {
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhbmFAZW1haWwuY29tIiwiZXhwIjoxNzAwODcxMjkzLCJpc3MiOiJWQVgifQ.UTv27otER2EnbKKJ688XYYbUN8wkYSFpC1LsPE3GmSA",
        "type": "JWT",
        "prefix": "Bearer"
    },
    "usuario": {
        "id": 4,
        "nome": "Ana",
        "email": "ana@email.com",
        "dataNascimento": "1960-01-01",
        "cep": "01789258"
    }
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

Explicação - Ao fazer a requisição, caso as informações estejam corretas será retornado o formulário com todas as informações das vacinas possíveis a ser tomado por da uma pessoa da idade do usuário, quando o usuário é cadastrado, o usuário terá todas as vacinas cadastradas como false e com isso pode se alterar para o status correto.

**Response**
```js
{
    "Idoso": {
        "DuplaAdulto": [
            {
                "id": 189,
                "nome": "Dupla Adulto (dT)",
                "descricao": "Previne difteria e tétano.",
                "categoria": "Idoso",
                "dose": "Periodica",
                "status": false
            }
        ],
        "HepatiteB": [
            {
                "id": 151,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Idoso",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 152,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Idoso",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 153,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Idoso",
                "dose": "TerceiraDose",
                "status": false
            }
        ],
        "HPV": [
            {
                "id": 185,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Idoso",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 186,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Idoso",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "FebreAmarela": [
            {
                "id": 175,
                "nome": "Febre amarela",
                "descricao": "Previne a febre amarela.",
                "categoria": "Idoso",
                "dose": "DoseUnica",
                "status": false
            }
        ]
    },
    "Adulto": {
        "DuplaAdulto": [
            {
                "id": 188,
                "nome": "Dupla Adulto (dT)",
                "descricao": "Previne difteria e tétano.",
                "categoria": "Adulto",
                "dose": "Periodica",
                "status": false
            }
        ],
        "HepatiteB": [
            {
                "id": 148,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adulto",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 149,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adulto",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 150,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adulto",
                "dose": "TerceiraDose",
                "status": false
            }
        ],
        "HPV": [
            {
                "id": 183,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Adulto",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 184,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Adulto",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "TetraViral": [
            {
                "id": 179,
                "nome": "Tetra viral ou tríplice viral + varicela",
                "descricao": "Previne sarampo, rubéola, caxumba e varicela/catapora.",
                "categoria": "Adulto",
                "dose": "DoseUnica",
                "status": false
            }
        ],
        "FebreAmarela": [
            {
                "id": 174,
                "nome": "Febre amarela",
                "descricao": "Previne a febre amarela.",
                "categoria": "Adulto",
                "dose": "DoseUnica",
                "status": false
            }
        ]
    },
    "Criança": {
        "BCG": [
            {
                "id": 143,
                "nome": "BCG (Bacilo Calmette-Guerin)",
                "descricao": "Previne as formas graves de tuberculose, principalmente miliar e meníngea.",
                "categoria": "Criança",
                "dose": "DoseUnica",
                "status": true
            }
        ],
        "MeningococicaC": [
            {
                "id": 169,
                "nome": "Meningocócica C conjugada",
                "descricao": "Previne a doença meningocócica C.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": true
            },
            {
                "id": 170,
                "nome": "Meningocócica C conjugada",
                "descricao": "Previne a doença meningocócica C.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": true
            }
        ],
        "Rotavirus": [
            {
                "id": 167,
                "nome": "Vacina rotavírus humano G1P1",
                "descricao": "Previne diarreia por rotavírus.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 168,
                "nome": "Vacina rotavírus humano G1P1",
                "descricao": "Previne diarreia por rotavírus.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            }
        ],
        "HepatiteA": [
            {
                "id": 180,
                "nome": "Hepatite A",
                "descricao": "Previne a hepatite A.",
                "categoria": "Criança",
                "dose": "DoseUnica",
                "status": true
            }
        ],
        "HepatiteB": [
            {
                "id": 144,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            }
        ],
        "Poliomielite": [
            {
                "id": 159,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": true
            },
            {
                "id": 160,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": true
            },
            {
                "id": 161,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "TerceiraDose",
                "status": true
            },
            {
                "id": 162,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "PrimeiroReforco",
                "status": true
            },
            {
                "id": 163,
                "nome": "Poliomielite",
                "descricao": "Previne poliomielite ou paralisia infantil.",
                "categoria": "Criança",
                "dose": "SegundoReforco",
                "status": true
            }
        ],
        "TripliceViral": [
            {
                "id": 176,
                "nome": "Tríplice viral (sarampo, caxumba e rubéola)",
                "descricao": "Previne sarampo, caxumba e rubéola.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": true
            }
        ],
        "Pneumococica10V": [
            {
                "id": 164,
                "nome": "Pneumocócica 10V",
                "descricao": "Previne pneumonia, otite, meningite e outras doenças causadas pelo Pneumococo.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 165,
                "nome": "Pneumocócica 10V",
                "descricao": "Previne pneumonia, otite, meningite e outras doenças causadas pelo Pneumococo.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 166,
                "nome": "Pneumocócica 10V",
                "descricao": "Previne pneumonia, otite, meningite e outras doenças causadas pelo Pneumococo.",
                "categoria": "Criança",
                "dose": "PrimeiroReforco",
                "status": false
            }
        ],
        "Pentavalente": [
            {
                "id": 154,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "PrimeiraDose",
                "status": false
            },
            {
                "id": 155,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "SegundaDose",
                "status": false
            },
            {
                "id": 156,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "TerceiraDose",
                "status": false
            },
            {
                "id": 157,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "PrimeiroReforco",
                "status": false
            },
            {
                "id": 158,
                "nome": "Pentavalente (DTP/HB/Hib)",
                "descricao": "Previne difteria, tétano, coqueluche, hepatite B e meningite e infecções por HiB.",
                "categoria": "Criança",
                "dose": "SegundoReforco",
                "status": false
            }
        ],
        "FebreAmarela": [
            {
                "id": 172,
                "nome": "Febre amarela",
                "descricao": "Previne a febre amarela.",
                "categoria": "Criança",
                "dose": "DoseUnica",
                "status": false
            }
        ]
    },
    "Adolescente": {
        "MeningococicaC": [
            {
                "id": 171,
                "nome": "Meningocócica C conjugada",
                "descricao": "Previne a doença meningocócica C.",
                "categoria": "Adolescente",
                "dose": "DoseUnica",
                "status": true
            }
        ],
        "DuplaAdulto": [
            {
                "id": 187,
                "nome": "Dupla Adulto (dT)",
                "descricao": "Previne difteria e tétano.",
                "categoria": "Adolescente",
                "dose": "Periodica",
                "status": true
            }
        ],
        "HepatiteB": [
            {
                "id": 145,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adolescente",
                "dose": "PrimeiraDose",
                "status": true
            },
            {
                "id": 146,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adolescente",
                "dose": "SegundaDose",
                "status": true
            },
            {
                "id": 147,
                "nome": "Hepatite B",
                "descricao": "Previne a hepatite B.",
                "categoria": "Adolescente",
                "dose": "TerceiraDose",
                "status": true
            }
        ],
        "HPV": [
            {
                "id": 181,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Adolescente",
                "dose": "PrimeiraDose",
                "status": true
            },
            {
                "id": 182,
                "nome": "HPV",
                "descricao": "Previne o papiloma, vírus humano que causa cânceres e verrugas genitais.",
                "categoria": "Adolescente",
                "dose": "SegundaDose",
                "status": true
            }
        ],
        "TripliceViral": [
            {
                "id": 177,
                "nome": "Tríplice viral (sarampo, caxumba e rubéola)",
                "descricao": "Previne sarampo, caxumba e rubéola.",
                "categoria": "Adolescente",
                "dose": "PrimeiraDose",
                "status": true
            },
            {
                "id": 178,
                "nome": "Tríplice viral (sarampo, caxumba e rubéola)",
                "descricao": "Previne sarampo, caxumba e rubéola.",
                "categoria": "Adolescente",
                "dose": "SegundaDose",
                "status": true
            }
        ],
        "FebreAmarela": [
            {
                "id": 173,
                "nome": "Febre amarela",
                "descricao": "Previne a febre amarela.",
                "categoria": "Adolescente",
                "dose": "DoseUnica",
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
