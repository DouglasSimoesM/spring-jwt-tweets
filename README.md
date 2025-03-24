# Projeto Spring Security com Autenticação JWT

Este projeto demonstra a implementação de autenticação e autorização com **JWT (JSON Web Token)** utilizando **Spring Boot**. Ele inclui funcionalidades como criação de usuários, gerenciamento de tweets e um sistema de feed, além de configurações completas para segurança com tokens JWT.

---
## Video Demontrativo <b><i>[CLIQUE AQUI](https://photos.app.goo.gl/wRSWaJBkXgd57jPh8)</i></b> 
---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JSON Web Token)**
- **PostgreSQL**
- **Maven**

---

## Funcionalidades

1. **Entendendo Autenticação e Autorização com JWT**  
   Implementação de autenticação segura baseada em tokens JWT para acesso a APIs RESTful.

2. **Iniciando o Projeto Spring Boot**  
   Configuração inicial do projeto com dependências para Spring Boot, Spring Security e JWT.

3. **Criando as Entities (User, Role e Tweet)**  
   Definição de entidades no banco de dados para representar usuários, papéis e tweets.

4. **Criando os Repositories das Entities e Configurando o Banco de Dados**  
   Configuração do banco de dados PostgreSQL, criação de repositórios JPA e scripts SQL para inicialização do banco.

5. **Configurando o Spring Security para Token JWT**  
   Configuração completa do Spring Security para autenticar e autorizar usuários com base em JWT.

6. **Gerando as Chaves Públicas e Privadas do Token JWT**  
   Uso do OpenSSL para gerar as chaves RSA utilizadas na assinatura dos tokens JWT.

7. **Criando a Funcionalidade de Login**  
   Endpoint `/login` para autenticação de usuários e geração de tokens JWT.

8. **Automatizando a Criação do Usuário Admin**  
   Inicialização automática de um usuário administrador com privilégios especiais ao iniciar a aplicação.

9. **Criando a Funcionalidade de Criar Novo Usuário**  
   Endpoint `/users` para registrar novos usuários com o papel padrão de "basic".

10. **Criando a Funcionalidade de Listar Todos os Usuários**  
    Endpoint `/users` para listar todos os usuários do sistema (restrito a administradores).

11. **Criando a Funcionalidade de Criar Tweet**  
    Endpoint `/tweets` para que os usuários autenticados possam criar novos tweets.

12. **Criando a Funcionalidade de Deletar Tweet**  
    Endpoint `/tweets/{id}` que permite a exclusão de tweets por administradores ou pelo autor do tweet.

13. **Criando a Funcionalidade de Feed**  
    Endpoint `/feed` para exibir os tweets em ordem decrescente de criação.

---

## Pré-requisitos

1. **Java 17** instalado.  
2. Banco de dados **PostgreSQL** configurado.  

### Criação do Banco de Dados
Crie o banco de dados antes de iniciar o projeto:
```sql
CREATE DATABASE mydb;
```
### Gerar Chaves RSA (JWT)

Utilize o OpenSSL para gerar as chaves públicas e privadas:

```bash
openssl genrsa -out private.pem 2048
openssl rsa -in private.pem -pubout -out public.pem
```

Coloque os arquivos gerados (`private.pem` e `public.pem`) no diretório `src/main/resources`.

---

### Como Executar o Projeto

Clone o repositório:

```bash
git clone https://github.com/DouglasSimoesM/spring-jwt-tweets/tree/main
cd spring-jwt-tweets
```

Configure as variáveis no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=postgre
spring.jpa.hibernate.ddl-auto=update
jwt.public.key=classpath:public.pem
jwt.private.key=classpath:private.pem
```

Compile e execute o projeto:

```bash
./mvnw spring-boot:run
```

---

### Endpoints Disponíveis

#### Autenticação
- `POST /login` - Autentica o usuário e retorna o token JWT.

#### Usuários
- `POST /users` - Cria um novo usuário.
- `GET /users` - Lista todos os usuários (somente para administradores).

#### Tweets
- `POST /tweets` - Cria um novo tweet (requer autenticação).
- `DELETE /tweets/{id}` - Deleta um tweet (autorizado para administradores ou autor do tweet).
- `GET /feed` - Exibe o feed de tweets em ordem decrescente.

