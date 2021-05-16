# Demo sobre live coding da digital innovation one - spring webflux - criando seu gerenciador de herois
___

## Stack utilizada
___
* Java 8
* Spring webflux
* Spring data
* Dynamo DB
* junit
* sl4j
* reactor

### Palestra Gravada:
https://www.youtube.com/watch?v=1VllPZYn6RI&t=3257s

### Executar dynamo:

> na pasta em que o jar está baixado: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
>
> ou executar o Docker com docker-compose.yml na raiz do projeto.
> ___
> Saiba mais:
> https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html

> para listar as tabelas criadas: 
> 
> aws dynamodb list-tables --endpoint-url http://localhost:8000

> swagger: http://localhost:8080/swagger-ui-heroes-reactive-api.html