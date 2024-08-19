# Blog System

<p>Java RESTful API para o desafio da DIO</p>

## Principais Tecnologias

- <p>Java 17: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;</p>
- <p>Spring Boot 3: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;</p>
- <p>Spring Data JPA: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;</p>
- <p>OpenAPI (Swagger): Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;</p>
- <p>Railway: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.</p>

## Diagrama de Classes

```mermaid
classDiagram
  class User {
    -String username
    -String password
    -LocalDate birthDate
    -Instant registerDate
    -Post[] posts
  }

  class Post {
    -String author
    -String message
    -String image
    -Instant postDate
  }

  User "1" --> "N" Post

```

## Documentação da API (Swagger)

<h3>https://sdw-2023-prd.up.railway.app/swagger-ui.html</h3><br>
<p>Esta API ficará disponível no Railway por um período de tempo limitado.</p>
