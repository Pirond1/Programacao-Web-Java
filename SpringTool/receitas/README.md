# 🍽️ Sistema de Receitas — API REST

API REST para gerenciamento de receitas culinárias, desenvolvida com Java e Spring Boot como trabalho final da disciplina de Programação Web Java.

---

## 📋 Descrição do Sistema

O sistema permite gerenciar **chefs**, **receitas** e **ingredientes**, com os seguintes relacionamentos:

- Um **Chef** pode ter várias **Receitas** (OneToMany)
- Uma **Receita** pode ter vários **Ingredientes**, e um **Ingrediente** pode estar em várias **Receitas** (ManyToMany)

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.4 |
| Spring Web MVC | — |
| Spring Data JPA | — |
| Hibernate | — |
| MySQL | — |
| Bean Validation | — |
| Maven | — |

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- Java 17+
- Maven instalado
- MySQL rodando localmente

### 1. Configurar o Banco de Dados

Crie o banco de dados no MySQL:

```sql
CREATE DATABASE receitas;
```

### 2. Configurar as credenciais

Verifique o arquivo `src/main/resources/application.properties` e ajuste se necessário:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/receitas
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

> ⚠️ As tabelas são criadas automaticamente pelo Hibernate ao iniciar a aplicação.

### 3. Rodar a aplicação

A API estará disponível em: **`http://localhost:8080`**

---

## 🔗 Endpoints Disponíveis

### 👨‍🍳 Chef

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/chef` | Lista todos os chefs com suas receitas |
| `GET` | `/chef/{id}` | Busca um chef pelo ID |
| `POST` | `/chef` | Cadastra um novo chef |
| `PUT` | `/chef/{id}` | Atualiza os dados de um chef |
| `DELETE` | `/chef/{id}` | Remove um chef |

### 🥕 Ingrediente

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/ingrediente` | Lista todos os ingredientes |
| `GET` | `/ingrediente/{id}` | Busca um ingrediente pelo ID (com receitas vinculadas) |
| `POST` | `/ingrediente` | Cadastra um novo ingrediente |
| `PUT` | `/ingrediente/{id}` | Atualiza um ingrediente |
| `DELETE` | `/ingrediente/{id}` | Remove um ingrediente |
| `GET` | `/ingrediente/{id}/receita` | Lista todas as receitas que usam esse ingrediente |

### 📖 Receita

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/receita` | Lista todas as receitas com o chef responsável |
| `GET` | `/receita/{id}` | Busca uma receita pelo ID |
| `POST` | `/receita/{chef_id}` | Cria uma receita vinculada a um chef |
| `GET` | `/receita/{id}/ingrediente` | Lista os ingredientes de uma receita |

### 🔗 Receita-Ingrediente (Relacionamento ManyToMany)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/receita-ingrediente?receita_Id={id}&ingrediente_Id={id}` | Vincula um ingrediente a uma receita |

---

## 📦 Exemplos de Requisições

> Utilize o **Postman** ou **Insomnia** para testar os endpoints abaixo.

---

### ✅ Fluxo completo recomendado para testes:

**1 → Criar Chef → 2 → Criar Ingrediente → 3 → Criar Receita → 4 → Vincular Ingrediente → 5 → Consultar tudo**

---

### 1. Criar um Chef

**`POST /chef`**

```json
{
  "nome": "Gustavo Pirondi",
  "especialidade": "Doces"
}
```

**Resposta:**
```json
{
  "id": 1,
  "nome": "Gustavo Pirondi",
  "especialidade": "Doces",
  "Receitas": null
}
```

---

### 2. Criar um Ingrediente

**`POST /ingrediente`**

```json
{
  "nome": "Farinha de Trigo",
  "unidadeMedida": "gramas",
  "quantidade": 500
}
```

**Resposta:**
```json
{
  "id": 1,
  "nome": "Farinha de Trigo",
  "unidadeMedida": "gramas",
  "quantidade": 500
}
```

---

### 3. Criar uma Receita (vinculada ao Chef de id=1)

**`POST /receita/1`**

```json
{
  "titulo": "Bolo de Cenoura",
  "tempoPreparo": 120
}
```

**Resposta:**
```json
{
  "id": 1,
  "titulo": "Bolo de Cenoura",
  "chef": {
    "id": 1,
    "nome": "Gustavo Pirondo",
    "especialidade": "Doces"
  }
}
```

---

### 4. Vincular Ingrediente à Receita (ManyToMany)

**`POST /receita-ingrediente?receita_Id=1&ingrediente_Id=1`**

**Resposta:**
```json
{
  "id": 1,
  "titulo": "Bolo de Cenoura",
  "ingredientes": [
    {
      "id": 1,
      "nome": "Farinha de Trigo",
      "unidadeMedida": "gramas",
      "quantidade": 500,
      "receitas": []
    }
  ]
}
```

---

### 5. Listar todos os Chefs

**`GET /chef`**

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Gustavo Pirondi",
    "especialidade": "Doces",
    "receitas": [
      { "id": 1, "titulo": "Bolo de Cenoura" }
    ]
  }
]
```

---

### 6. Listar ingredientes de uma Receita

**`GET /receita/1/ingrediente`**

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Farinha de Trigo",
    "unidadeMedida": "gramas",
    "quantidade": 500
  }
]
```

---

### 7. Listar receitas que usam um Ingrediente

**`GET /ingrediente/1/receita`**

**Resposta:**
```json
[
  {
    "id": 1,
    "titulo": "Bolo de Cenoura",
    "ingredientes": [ ... ]
  }
]
```

---

### 8. Atualizar um Chef

**`PUT /chef/1`**

```json
{
  "nome": "Gustavo Pirondi",
  "especialidade": "Salgados"
}
```

---

### 9. Deletar um Ingrediente

**`DELETE /ingrediente/1`**

Retorna `200 OK` sem corpo.

---

## ✅ Validações Implementadas

### Chef
| Campo | Regra |
|-------|-------|
| `nome` | Obrigatório, entre 3 e 50 caracteres |
| `especialidade` | Obrigatório, entre 3 e 30 caracteres |

### Ingrediente
| Campo | Regra |
|-------|-------|
| `nome` | Obrigatório, entre 3 e 50 caracteres |
| `unidadeMedida` | Obrigatório, entre 1 e 20 caracteres |
| `quantidade` | Obrigatório, entre 1 e 99999 |

### Receita
| Campo | Regra |
|-------|-------|
| `titulo` | Obrigatório, entre 3 e 50 caracteres |
| `tempoPreparo` | Obrigatório, entre 5 e 300 minutos |

**Exemplo de erro de validação (`400 Bad Request`):**
```json
{
  "status": 400,
  "mensagem": "Nome é obrigatório",
  "dataHora": "2026-05-14T19:00:00"
}
```

---

## ⚠️ Tratamento de Exceções

Todos os erros retornam um JSON padronizado:

```json
{
  "status": 404,
  "mensagem": "Recurso não encontrado",
  "dataHora": "2026-05-14T19:00:00"
}
```

| Tipo de Erro | Status HTTP |
|---|---|
| Recurso não encontrado | `404 Not Found` |
| Dados inválidos (validação) | `400 Bad Request` |

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/gustavo/receitas/
├── controller/          # Recebe as requisições HTTP
│   ├── ChefController
│   ├── IngredienteController
│   ├── ReceitaController
│   └── ReceitaIngredienteController
├── service/             # Regras de negócio
│   ├── ChefService
│   ├── IngredienteService
│   ├── ReceitaService
│   └── ReceitaIngredienteService
├── repository/          # Comunicação com o banco de dados (Spring Data JPA)
│   ├── ChefRepository
│   ├── IngredienteRepository
│   └── ReceitaRepository
├── model/
│   ├── entity/          # Entidades JPA (tabelas do banco)
│   │   ├── Chef
│   │   ├── Receita
│   │   └── Ingrediente
│   └── dto/             # Objetos de transferência de dados
│       ├── ChefDTO
│       ├── ChefReceitaDTO
│       ├── ReceitaDTO
│       ├── ReceitaChefDTO
│       ├── IngredienteDTO
│       └── ReceitaIngredienteDTO
└── exception/           # Tratamento global de exceções
    ├── GlobalExceptionHandler
    └── ErroResposta
```
