# Teste insternero stefanini vaga Java

    Este teste é divido em duas atividades:
        Desafio:
            Teste de lógica e conhecimentos básico de java:
                [Desafio_1](./docs/Desafio_1.pdf)
                [Desafio_2](./docs/Desafio_2.pdf)
                [Desafio_3](./docs/Desafio_3.pdf)
        Avaliação:
            Projeto Java
                [Requisitos do projeto](./docs/Projeto%20requisitos.pdf)

## Atualizações 10-08-2025
- Java 8 para 21
- Spring-boot 2.5.5 para 3.5.4
- mysql:mysql-connector-java:8.0.22  para com.mysql:mysql-connector-j:9.4.0 (versão e pacote)
- Organizado arquivo em pasta docs
- Adicionado Dockerfile e Docker-compose
- Removido arquivos desnecessário
- Atualizações feitas conforme apontamente DevSecOps usando Snyk e SonarQube

    ### Como rodar o projeto 
        docker-compose up --build -f avaliacao/docker-compose.yml

    ### Como parar o pojetos
        docker-compose down --volumes -f avaliacao/docker-compose.yml