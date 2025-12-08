# Sistema de Gerenciamento de Cinema

> Projeto desenvolvido para a disciplina de **Linguagem de Programação III**, utilizando **Arquitetura MVC**, **JPA com EclipseLink**, **DTO + Mapper**, **Padrões de Projeto** e **banco MySQL**.
> O sistema realiza cadastro e gerenciamento de **Filmes, Salas, Sessões, Clientes e Vendas de Ingressos**.

## 1. Descrição do Projeto

O **Sistema de Gerenciamento de Cinema** tem como objetivo controlar:

* Cadastro de **Filmes**
* Cadastro de **Salas de Cinema**
* Criação de **Sessões**
* Registro de **Clientes**
* Venda de **Ingressos**
* Relatório formatado com informações do cinema

A aplicação foi construída seguindo a **arquitetura MVC**, com uso de **padrões de projeto**, **JPA (EclipseLink) para ORM**, **DTOs**, **Mappers** e persistência em **MySQL**.
A interface atual é implementada em **Java Swing**, com telas reutilizáveis e código desacoplado.


## 2. Arquitetura e Tecnologias Utilizadas

| Tecnologia/Conceito    | Uso no Projeto                              |
| ---------------------- | ------------------------------------------- |
| **MVC**                | Separação entre Model, View e Controller    |
| **JPA + EclipseLink**  | Mapeamento objeto-relacional e persistência |
| **MySQL**              | Banco relacional externo                    |
| **DTO + Mapper**       | Comunicação segura entre camadas            |
| **Padrões de Projeto** | Organização e escalabilidade                |
| **Java Swing**         | Interface gráfica                           |
| **Maven**              | Dependências e build                        |
| **Git/GitHub**         | Versionamento e documentação                |

O projeto segue estritamente a estrutura:
```
br.edu.ifms.cinema/
├── controller
├── dao
├── dto
├── mapper
├── model
├── util
└── view
```

## 3. Padrões de Projeto Aplicados

| Padrão                         | Função no Sistema                             | Onde foi usado                               |
| ------------------------------ | --------------------------------------------- | -------------------------------------------- |
| **Singleton**                  | Uma única instância de `EntityManagerFactory` | `ConexaoFactory`                             |
| **Factory**                    | Criação de `EntityManager`                    | `ConexaoFactory.getEntityManager()`          |
| **DAO Genérico**               | CRUD padronizado e reaproveitável             | `GenericDAO<T>`                              |
| **DTO (Data Transfer Object)** | Transporte de dados entre camadas             | `FilmeRequestDTO`, `ClienteResponseDTO` etc. |
| **Mapper/Adapter**             | Conversão entre Entidades e DTOs              | `FilmeMapper`, `ClienteMapper`               |

## 4. Modelagem e Relacionamentos JPA

### Entidades Implementadas:

* `Filme`
* `Sala`
* `Sessao`
* `Cliente`
* `Ingresso`
* `Assento`
* `CartaoFidelidade`

### Relacionamentos Implementados

| Tipo                    | Exemplo                    | Descrição                            |
| ----------------------- | -------------------------- | ------------------------------------ |
| @OneToMany / @ManyToOne | Filme ↔ Sessao             | Um filme pode ter várias sessões     |
| @OneToOne               | Cliente ↔ CartaoFidelidade | Cada cliente tem um cartão único     |
| @OneToMany / @ManyToOne | Sessao ↔ Ingresso          | Uma sessão pode ter vários ingressos |
| @OneToOne               | Ingresso ↔ Assento         | Cada ingresso reserva um assento     |
| @ManyToOne              | Sala ↔ Sessao              | Uma sala contém múltiplas sessões    |

Exemplos reais do código:

```java
@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
private CartaoFidelidade cartaoFidelidade;
```

```java
@OneToMany(mappedBy = "sessao")
private List<Ingresso> ingressos;
```

## 5. Versionamento e Organização

* Repositório organizado com **pacotes separados por função (controller, dto, mapper, view, model)**.
* Commits feitos com clareza, indicando:

  * CRUD implementado
  * Adição de DTOs e Mappers
  * Telas Swing
  * Correções

## 6. Interface Gráfica

* Implementada em **Java Swing**, na camada **View**, com telas desacopladas.
* A classe `SessaoView` foi estruturada para receber dados, enviar aos **Controllers** e renderizar respostas.
* A classe `InformacoesView` foi estruturada para mostrar informações básicas sobre o sistema.

**Principais características:**

* Painéis com CRUD organizados por funções (Filme, Sala, Sessão, Cliente, Ingresso)
* Atualização de dados via JPA
* Código reutilizável (métodos auxiliares)

## 7. Aprendizados e Desafios
O principal desafio foi integrar Swing, JPA e DTO de forma correta, sem quebrar o padrão MVC, foi difícil entender como a View podia usar os dados sem acessar diretamente 
as entidades, mas com o uso dos Controllers e DTOs isso acabou ficando mais claro. Também aprendi bastante com a modelagem mais complexa, especialmente nos relacionamentos entre as 
entidades.
