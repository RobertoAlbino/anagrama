# Anagrama CLI

## 📂 Estrutura do Projeto

```
Anagrama/
 ├── src/
 │   ├── main/java/org/anagrama/Anagrama.java      # aplicação CLI
 │   └── test/java/org/anagrama/AnagramaTest.java  # Testes com JUnit 5
 ├── pom.xml            # dependências Maven
 ├── Dockerfile         # build + runtime em containers
 ├── docker-compose.yml # orquestração para app + testes
```

---

## 🔧 Pré‑requisitos (Executar sem docker)

| Ferramenta | Versão Recomendável |
|-----------|--------------------|
| **Java**  | 17 ou superior |
| **Maven** | 3.9.x |
| **Docker**| 24+ (opcional) |
| **Docker Compose** | 2.x (opcional) |
---

## ▶️ Rodando local
```bash
$ mvn clean package -DskipTests && java -cp target/classes org.anagrama.Anagrama abc
```
Substitua `abc` pela argumento desejado. O programa lançará `IllegalArgumentException` se:
* não houver argumento;
* a string estiver vazia ou contiver caracteres que não sejam letras (A‑Z ou a‑z).

---

## 🐳 Rodando com Docker

### 1. Rodar a aplicação com um argumento setado no docker-compose e rodar todos os testes
```bash
$ docker compose up
```

---

## 🔄 Integração Contínua (GitHub Actions)
Este repositório possui um workflow **CI** em `.github/workflows/ci.yml` que executa automaticamente a suíte de testes JUnit 5 em cada push request para a branch `master`.





