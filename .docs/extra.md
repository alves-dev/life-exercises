[Eventos](https://github.com/alves-dev/life/tree/main/events#person_tracking-routing_key---person_tracking)

### Eventos
`type = PERSON_TRACKING` trata-se de um evento indicando que uma pessoa [entrou, saiu ou permaneceu] em algum lugar por um `X` tempo.

No caso se, `action = REMAINED` e `local = ACADEMY` eu salvo no banco de dados indicando que a pessoa foi a cadamia.

-----
### Tecnologias Utilizadas
__[Spring Boot](https://spring.io/projects/spring-boot):__ Poderoso framework Java para criar aplicativos robustos e eficientes.

__[Kotlin](https://kotlinlang.org/):__ Uma linguagem moderna.

__[RabbitMQ](https://rabbitmq-website.pages.dev/):__ A solução de mensageria para comunicação assíncrona.

__[MySQL](https://www.mysql.com/):__ O banco de dados relacional utilizado para o armazenamento dos dados.

__[Testcontainers](https://testcontainers.com/):__ Utilizado para fazer testes de integração.


-----
### Siga esses passos para começar a usar o Exercises em sua máquina:

##### Clone o Repositório:
```bash
git clone https://github.com/alves-dev/life-exercises.git
cd life-exercises
```

##### Configure as variáveis em:
`/main/src/main/resources/application.yml`

### Ou acesse [aqui](https://github.com/alves-dev/posts/tree/main/2024/stack-life-python-kotlin) para ver o projeto funcionando juntamente com outros componentes