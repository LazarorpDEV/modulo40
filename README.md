# Módulo 40 — Primeiro projeto Spring Boot

**Aluno:** Lázaro Rodrigues Pereira  
**Curso:** Back-end Java — EBAC

## Objetivo

Criar um projeto Spring Boot pelo Spring Initializr, executar a aplicação e versionar o código no GitHub para avaliação.

## Criação pelo Spring Initializr

A estrutura inicial deste projeto foi gerada em https://start.spring.io com estas opções:

| Configuração | Valor |
| --- | --- |
| Project | Maven |
| Language | Java |
| Spring Boot | 4.1.2 (versão estável disponibilizada na geração) |
| Group | br.com.lazaro |
| Artifact | modulo40 |
| Package name | br.com.lazaro.modulo40 |
| Packaging | Jar |
| Java | 17 |
| Dependency | Spring Web |

Depois da geração, foram adicionados o controller de saudação, a página inicial e testes. O Maven Wrapper original está incluído.

## Requisitos

- JDK 17 ou superior, com JAVA_HOME configurado.
- Acesso à internet na primeira execução para baixar o Maven e as dependências.
- Git para versionar. Não precisa de banco de dados ou instalação separada do Tomcat.

## Executar no Windows (PowerShell)

Extraia o ZIP e abra o terminal na pasta `modulo40`, onde está o `pom.xml`.

```powershell
java -version
.\mvnw.cmd clean verify
.\mvnw.cmd spring-boot:run
```

Aguarde a mensagem `Started Modulo40Application` e abra http://localhost:8080.
Digite seu nome e clique em **Testar saudação**. A mensagem é retornada pelo controller Java.
Para encerrar, pressione `Ctrl+C` no terminal.

No Linux/macOS:

```bash
chmod +x mvnw
./mvnw clean verify
./mvnw spring-boot:run
```

Se você já tem Maven instalado, também pode usar `mvn clean verify` e `mvn spring-boot:run`.

## Rotas

| Método | URL | Resultado |
| --- | --- | --- |
| GET | `/` | Página inicial com formulário |
| GET | `/api/saudacao` | JSON com saudação padrão |
| GET | `/api/saudacao?nome=Lazaro` | JSON com saudação personalizada |

Exemplo:

```json
{"mensagem":"Olá, Lazaro! Meu projeto Spring Boot está funcionando.","modulo":40}
```

`@SpringBootApplication` inicia e configura a aplicação. `@RestController` recebe as requisições e serializa a resposta em JSON. `@GetMapping` define a rota GET. `@RequestParam` lê o nome na URL. A página usa `fetch` para consultar essa rota e exibir a mensagem.

## Porta 8080 ocupada

No PowerShell, para iniciar na porta 8081:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
```

Nesse caso, abra http://localhost:8081.

## Validação realizada

O projeto passou em `clean verify` com `BUILD SUCCESS`: três testes executados, sem falhas ou erros. A aplicação também foi iniciada com `spring-boot:run`, e as rotas `/` e `/api/saudacao?nome=Lazaro` foram verificadas por requisições HTTP.

## Versionar no GitHub

1. No GitHub, crie um repositório chamado `modulo40`, sem adicionar README, .gitignore ou licença. Escolha visibilidade pública para permitir a avaliação dos tutores.
2. Na pasta deste projeto, execute:

```powershell
git init
git add .
git commit -m "Cria projeto Spring Boot do modulo 40"
git branch -M main
git remote add origin https://github.com/LazarorpDEV/modulo40.git
git push -u origin main
```

3. Abra o repositório e confirme que `pom.xml`, `src`, `mvnw`, `mvnw.cmd` e `.mvn/wrapper` apareceram. O `.gitignore` impede o envio da pasta `target`.
4. Envie o link do repositório na atividade da EBAC. A publicação depende de você criar o repositório e executar o push autenticado.

## Conferência antes da entrega

- Comando `clean verify` termina com `BUILD SUCCESS`.
- Página abre no navegador e a saudação funciona.
- Código está disponível no GitHub para o tutor.

Se desejar, tire um print da aplicação no navegador e outro do terminal com a inicialização. O enunciado do módulo 40 solicita o projeto funcionando e versionado.

## Referências

- https://start.spring.io
- https://spring.io/guides/gs/spring-boot/
