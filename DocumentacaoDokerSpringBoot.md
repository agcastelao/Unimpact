# Executando uma Aplicação Spring Boot com Docker

Este tutorial mostra como configurar e rodar uma aplicação **Spring Boot** com **Docker**. Vamos aprender a criar a aplicação Spring Boot, configurar o Dockerfile, construir uma imagem Docker e executar a aplicação em um contêiner.

## Requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados:

- **JDK 11** ou superior
- **Docker** instalado na máquina (certifique-se de que o Docker Daemon está rodando)
- IDE como IntelliJ IDEA ou Eclipse
- **Maven** (se você estiver usando o Maven para gerenciar dependências)

## Etapas de Configuração

### 1. Criar o Projeto Spring Boot

Se ainda não tem um projeto Spring Boot, você pode criar um utilizando o [Spring Initializr](https://start.spring.io/). Selecione as dependências **Spring Web** e **Spring Data JPA**, e configure o projeto conforme necessário.

### 2. Criar o Arquivo `Dockerfile`

O arquivo **Dockerfile** contém instruções que o Docker seguirá para construir a imagem da aplicação.

Na raiz do seu projeto Spring Boot, crie um arquivo chamado `Dockerfile`. Abaixo está um exemplo básico de um Dockerfile para uma aplicação Spring Boot.


# Usar uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR gerado pela aplicação para o diretório de trabalho
COPY target/spring-boot-app.jar /app/spring-boot-app.jar

# Definir o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "spring-boot-app.jar"]

FROM openjdk:17-jdk-alpine: Define a imagem base do Docker, que neste caso é o JDK 17.
WORKDIR /app: Define /app como o diretório de trabalho dentro do contêiner.
COPY target/spring-boot-app.jar /app/: Copia o arquivo JAR da aplicação gerado pelo Maven para o diretório /app no contêiner.
ENTRYPOINT: Especifica o comando que será executado quando o contêiner iniciar, que é rodar a aplicação Java.
3. Gerar o Arquivo JAR
Antes de construir a imagem Docker, é necessário gerar o arquivo .jar da aplicação Spring Boot. Execute o seguinte comando no terminal:

mvn clean package


Isso vai gerar o arquivo JAR na pasta target/. Certifique-se de que o arquivo gerado tem um nome compatível com o especificado no Dockerfile (no exemplo, spring-boot-app.jar).

4. Criar o Arquivo .dockerignore
Assim como o .gitignore, o Docker usa um arquivo .dockerignore para excluir arquivos ou pastas desnecessários na construção da imagem. Crie um arquivo .dockerignore na raiz do projeto com o seguinte conteúdo:

target/
*.mvn
*.log
.git
.idea


Isso evita que diretórios como target e arquivos de configuração da IDE sejam incluídos na imagem Docker.

5. Construir a Imagem Docker
Agora que você tem o Dockerfile e o JAR da aplicação, pode construir a imagem Docker. No terminal, navegue até a pasta raiz do projeto (onde está o Dockerfile) e execute o seguinte comando:

docker build -t spring-boot-app .


Este comando:

build: Diz ao Docker para construir uma imagem.
-t spring-boot-app: Nomeia a imagem como spring-boot-app.
.: Refere-se ao diretório atual, que contém o Dockerfile.
6. Rodar o Contêiner
Com a imagem Docker criada, você pode rodar um contêiner baseado nela. Use o seguinte comando:

docker run -p 8080:8080 spring-boot-app


Este comando:

run: Inicia um contêiner baseado na imagem especificada.
-p 8080:8080: Faz o mapeamento da porta 8080 do contêiner para a porta 8080 da máquina local, permitindo o acesso à aplicação via localhost:8080.
spring-boot-app: Nome da imagem Docker que criamos anteriormente.
Agora, sua aplicação Spring Boot está rodando dentro de um contêiner Docker, acessível em http://localhost:8080.

7. Testar a Aplicação
Com o contêiner rodando, você pode acessar os endpoints da sua aplicação Spring Boot em um navegador ou com uma ferramenta como o Postman. Por exemplo:
http://localhost:8080/clientes


Se sua aplicação expõe endpoints de API, como no exemplo anterior, você poderá fazer requisições HTTP diretamente.

8. Parar o Contêiner
Se você quiser parar o contêiner em execução, pode usar o comando docker stop:

docker ps   # Lista os contêineres em execução
docker stop <container_id>


Substitua <container_id> pelo ID do contêiner que você deseja parar (você pode obter o ID usando o comando docker ps).

9. (Opcional) Usar o Docker Compose
Se a aplicação depender de serviços externos como um banco de dados, o Docker Compose facilita a orquestração de múltiplos contêineres. Aqui está um exemplo de como configurar o docker-compose.yml para rodar a aplicação Spring Boot junto com um banco de dados MySQL:

Crie um arquivo docker-compose.yml na raiz do projeto:


version: '3.8'

services:
  app:
    image: spring-boot-app
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db

  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root_password
      MYSQL_DATABASE: clientes_db
      MYSQL_USER: user
      MYSQL_PASSWORD: password
    ports:
      - "3306:3306"


Neste exemplo:

Estamos rodando dois serviços: app (nossa aplicação Spring Boot) e db (um contêiner MySQL).
A aplicação depende do serviço db, que será automaticamente iniciado antes da aplicação.
Configurações de ambiente são passadas para o contêiner MySQL, como nome do banco de dados e credenciais.
Para rodar tudo, execute:

docker-compose up --build


Este comando vai construir as imagens (se necessário) e rodar os contêineres definidos no docker-compose.yml.


---

Esse é o passo a passo completo para rodar uma aplicação Spring Boot com Docker, organizado cronologicamente.





