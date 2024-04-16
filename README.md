# Estudo

Projeto de estudo usando Circuit Breaker utilizando Java, Spring Boot, MongoDB, Redis e Resilience4j.

# Usando:

[mapstruct.org](https://mapstruct.org/) | MapStruct é um gerador de código que simplifica bastante a implementação de mapeamentos entre tipos de bean Java com base em uma abordagem de convenção sobre configuração.

[maven-checkstyle-plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/) | O Checkstyle Plugin gera um relatório referente ao estilo de código utilizado pelos desenvolvedores.

[pmd.github.io](https://pmd.github.io/) | Um analisador de código estático extensível entre idiomas.

# MongoDb

Os arquivos start-mongo.sh e stop-mongo.sh, ajudam a iniciar ou para o banco de dados.

## Criar a base:

Entrar no container:

```shell
docker exec -it <ID_CONTAINER> /bin/bash
```

Dentro do contrainer:

```shell
mongosh -u root
```

Criar o basebase:
```shell
show databases;
use circuit-breaker;
show collections;
```

# wiremock

[wiremock.org/docs/download-and-installation/](https://wiremock.org/docs/download-and-installation/)

### Usando docker

[wiremock.org/docs/standalone/docker/](https://wiremock.org/docs/standalone/docker/)

```shell
docker run -it --rm \
  -p 8082:8080 \
  --name wiremock \
  -v $PWD/wiremock:/home/wiremock \
  wiremock/wiremock:3.5.2
```

Mapeamento: [http://localhost:8082/__admin/mappings](http://localhost:8082/__admin/mappings)
