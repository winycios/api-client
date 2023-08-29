# api-client
API cliente em Java, seguindo o padrão MVC, que possibilita a execução das operações CRUD relacionadas às informações do cliente.
### Spring boot java
Porta padrão do sistema localhost: 8080
# Exemplo de requisições

- GET: ``localhost:8080/usuarios/1`` 
  ```
  {
	"id": 1,
	"nome": "Winyc",
	"login": "wiwi",
	"senha": "123"
  }

- POST: ``localhost:8080/usuarios`` 
  ```
  {
	"id": 3,
	"nome": "mada",
	"login": "vava",
	"senha": "123"
  }
  NAME	   VALUE
  Location  http://localhost:8080/usuarios/3

- PUT(update) : ``localhost:8080/usuarios/1`` 
  ```
  {
	"id": 1,
	"nome": "Winycios",
	"login": "wi@gmail.com",
	"senha": "123"
  }

- DELETE: ``localhost:8080/usuarios/1`` (Apaga o usuário que pertence ao ID determinado)
- GET: ``localhost:8080/usuarios/total`` (Mostra todos os usuários  cadastrados)

  # Gostaria de testar o sistme ?
Você pode utilizar ferramentas como o Postman ou o Insomnia para realizar testes de requisições HTTP na API.
