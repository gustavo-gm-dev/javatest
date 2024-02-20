# README - Aplicação Backend com Spring Boot e Autenticação JWT
### Aplicação backend desenvolvida com Spring Boot, que utiliza autenticação por token com JWT (JSON Web Token). A aplicação oferece as seguintes APIs:

1. Login de Usuário:
    - Método: POST
    - Endpoint: localhost:8080/auth/login
    - Descrição: Este endpoint é usado para autenticar um usuário e gerar um token JWT válido.

2. Registro de Usuário:
    - Método: POST
    - Endpoint: localhost:8080/auth/register
    - Descrição: Este endpoint permite que um novo usuário se registre na aplicação.

3. Obter todos os usuários:
    - Método: GET
    - Endpoint: localhost:8080/api/users
    - Descrição: Este endpoint retorna uma lista de todos os usuários cadastrados no sistema.

4. Obter usuário por ID:
    - Método: GET
    - Endpoint: localhost:8080/api/users/user/{id}
    - Descrição: Este endpoint retorna um usuário específico com base no ID fornecido.

5. Atualizar dados do usuário por ID:
    - Método: PUT
    - Endpoint: localhost:8080/api/users/user/{id}
    - Descrição: Este endpoint atualiza os dados do usuario conforme necessidade

## Configuração e Execução

Para executar a aplicação, siga as etapas abaixo:

1. Certifique-se de ter o Docker instalado na sua máquina.

2. Clone o repositório da aplicação:
~~~
https://github.com/gustavo-gm-dev/javatest.git
~~~

3. Navegue até o diretório da aplicação:
~~~
cd javatest
~~~

4. Construa a imagem Docker da aplicação e execução:
~~~
docker-compose -f compose.yaml up -d --build --force-recreate
~~~

Agora, sua aplicação estará em execução e você poderá acessar os endpoints fornecidos acima.

## Estrutura do Projeto

A estrutura de diretórios do projeto é a seguinte:

- src/main/java: Contém o código-fonte Java da aplicação.
- src/main/resources: Contém os arquivos de configuração da aplicação.
- Dockerfile: Arquivo usado para criar a imagem Docker da aplicação.
- compose.yaml: Arquivo usado para parametrizações da imagem do banco e da implementação do codigo
- pom.xml: Arquivo de configuração do Maven com as dependências do projeto.
- README.md: Este arquivo README com instruções de configuração e uso da aplicação.
