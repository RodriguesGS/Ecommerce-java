# 🛒 E-commerce Java

Sistema de e-commerce simples em Java, com funcionalidades de cadastro de produtos e usuários, e realização de vendas com diferentes formas de pagamento.

---

## ✅ Pré-requisitos

Antes de começar, certifique-se de que as seguintes ferramentas estão instaladas:

- [Java JDK 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)

---

## 🚀 Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/RodriguesGS/Ecommerce-java.git
cd Ecommerce-java
```

### Compile o projeto

```bash
mvn clean install
```

### Execute a aplicação

```bash
mvn exec:java
```

> ⚠️ Se você não tiver o plugin exec-maven-plugin no pom.xml, use este comando alternativo:

```bash
java -cp target/seu-jar-gerado.jar caminho.da.sua.Main
```

## ✨ Funcionalidades

- ✅ Cadastro de produtos (nome e preço)
- 📦 Listagem de todos os produtos cadastrados
- 🧑 Cadastro de usuários (nome, email e senha)
- 📋 Listagem de todos os usuários cadastrados
- 💰 Realização de vendas com relatório final
- 🧾 Processamento de pagamento via estratégia (PIX, Cartão, etc.)

## 🗃️ Observações sobre o uso de UUID

Todos os produtos e usuários utilizam UUID como identificador.
Caso tenha dificuldades ao realizar uma venda informando um ID, aqui estão alguns exemplos válidos:

```txt
2fad72e6-1192-4fc6-874a-b14ff8fad0fb
1baa53ce-0630-4392-8bba-edbf965820b8
18126a40-6a84-4454-8792-0591b19308e8
5da63fde-1c20-4fde-b9cf-f47cc5f7e7c8
```

Para consultar os IDs diretamente do banco SQLite, utilize o DB Browser for SQLite e execute:

```sql
SELECT * FROM products
```

## 👨‍💻 Autor

- [Gabriel Rodrigues](github.com/RodriguesGS)