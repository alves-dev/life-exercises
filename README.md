<!--
template_name=head-code
template_version=v1
-->

<h1 align="center">Exercises</h1>

<p align="center">
  O projeto consiste em ouvir eventos de uma fila tratar o mesmo e salvar no banco de dados.<br>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/status-maintenance-blue.svg" alt="status">
</p>

<p align="center">
<img src="https://img.shields.io/badge/topics:-grey"> 
<img src="https://img.shields.io/badge/sync%20life-lightgrey">
<img src="https://img.shields.io/badge/kotlin-lightgrey">
<img src="https://img.shields.io/badge/spring-lightgrey">
<img src="https://img.shields.io/badge/mysql-lightgrey">
<img src="https://img.shields.io/badge/amqp-lightgrey">
<img src="https://img.shields.io/badge/docker-lightgrey">
<img src="https://img.shields.io/badge/rabbitmq-lightgrey">
<img src="https://img.shields.io/badge/gradle-lightgrey">
<img src="https://img.shields.io/badge/testcontainers-lightgrey">
</p>

<hr>


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
<!--
template_name=footer-default
template_version=v1
-->

---
<p align="center">
   <img src="https://img.shields.io/badge/licença-GPL%203-blue.svg" alt="license">
</p>

**Atualizado em:** 2025-06-27 18:10