# Sistema de Gerenciamento de Pagamentos (Mensalistas de Futebol)

**Disciplina:** Desenvolvimento WEB  
**Professor:** Adriano Ferrasa  
**Data de Entrega:** 13/05/2026  

### 👥 Equipe
* Angelo Cardoso da Costa João - 24006026
* Gabriel Azevedo Silva - 23009626
* Marcelo Parolim Dias - 23018926

---

## 📌 Sobre o Projeto
Este projeto é um sistema web simplista desenvolvido em Java utilizando o framework Spring Boot. Ele segue o padrão arquitetural MVC (atuando como uma API REST) para gerenciar o cadastro de jogadores de futebol e seus respectivos pagamentos mensais. O banco de dados utilizado é o PostgreSQL.

## 🚀 Tecnologias Utilizadas
* **Java 17**
* **Spring Boot 3** (Spring Web)
* **Spring Data JPA** (Hibernate)
* **PostgreSQL** (Banco de Dados Relacional)

---

## 📖 Documentação da API

Abaixo estão listados os endpoints (rotas) disponíveis para interação com o sistema.

### ⚽ Jogadores (`/api/jogadores`)

* **`GET /api/jogadores`**
  * **Descrição:** Retorna a lista de todos os jogadores cadastrados.
  
* **`POST /api/jogadores`**
  * **Descrição:** Cadastra um novo jogador.
  * **Corpo da requisição (JSON):**
    ```json
    {
      "nome": "Ronaldo",
      "email": "ronaldo@email.com",
      "datanasc": "1976-09-18"
    }
    ```

* **`GET /api/jogadores/{id}`**
  * **Descrição:** Busca um jogador específico pelo seu ID.

* **`PUT /api/jogadores/{id}`**
  * **Descrição:** Atualiza os dados de um jogador existente.

* **`DELETE /api/jogadores/{id}`**
  * **Descrição:** Exclui um jogador do sistema.

### 💰 Pagamentos (`/api/pagamentos`)

* **`GET /api/pagamentos`**
  * **Descrição:** Retorna todos os pagamentos. Pode ser filtrado passando o ID do jogador (Ex: `/api/pagamentos?jogadorId=1`).

* **`POST /api/pagamentos`**
  * **Descrição:** Registra um novo pagamento para um jogador.
  * **Corpo da requisição (JSON):**
    ```json
    {
      "ano": 2026,
      "mes": 5,
      "valor": 150.50,
      "jogador": {
        "codJogador": 1
      }
    }
    ```

* **`GET /api/pagamentos/{id}`**
  * **Descrição:** Busca os detalhes de um pagamento específico.

* **`DELETE /api/pagamentos/{id}`**
  * **Descrição:** Exclui um registro de pagamento.

---

## 🛠️ Como executar o projeto localmente
1. Certifique-se de ter o PostgreSQL instalado e rodando na porta `5432`.
2. Crie um banco de dados chamado `trabalho`.
3. Configure as credenciais (`username` e `password`) no arquivo `src/main/resources/application.properties`.
4. Execute a classe principal `Trabalho.java` ou rode o comando `./mvnw spring-boot:run`.
5. O servidor iniciará na porta `8081`.