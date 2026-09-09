Aqui está o detalhamento estruturado para o domínio **Sistema Escolar / Acadêmico**, focado em um relacionamento Master/Detail entre a entidade principal (**Turma**) e suas dependências (**Avaliacao**):

**Entidade Master: Turma (`tb_turma`)**

Representa o agrupamento de alunos em uma disciplina/módulo específico.

* `id` (Long): Identificador único da turma (Chave Primária).
* `codigo` (String): Código de identificação (ex: `"JAVA-2026-1N"`).
* `nomeDisciplina` (String): Nome do componente curricular (ex: `"Desenvolvimento Web com Spring Boot"`).
* `semestre` (Integer): Semestre letivo corrente (ex: `1` ou `2`).
* `ano` (Integer): Ano de vigência (ex: `2026`).
* `avaliacoes` (List<Avaliacao>): Lista com o detalhamento das avaliações do curso (`@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)`).

**Entidade Detail: Avaliacao (`tb_avaliacao`)**

Representa cada instrumento de nota vinculado diretamente a uma turma.

* `id` (Long): Identificador único da avaliação (Chave Primária).
* `titulo` (String): Nome/descrição da atividade (ex: `"Prova Regimental"`, `"Projeto Prático"`).
* `peso` (BigDecimal): Peso percentual ou multiplicador na composição da média (ex: `0.40` para 40%).
* `notaMaxima` (BigDecimal): Pontuação máxima possível para o item (ex: `10.00`).
* `dataEntrega` (LocalDate): Data limite ou dia da aplicação da prova.
* `turma` (Turma): Referência para a turma à qual esta avaliação pertence (`@ManyToOne`, `@JoinColumn(name = "turma_id")`).

**Regras de Negócio e Casos de Uso para Aula**

* **Cálculo de Média:** Métodos de serviço para iterar sobre a lista de `avaliacoes` e calcular a média ponderada ou soma total de notas máximas permitidas.
* **Validação de Soma dos Pesos:** Validar no `Service` se a soma do campo `peso` de todas as avaliações pertencentes a uma `Turma` totaliza exatamente `1.00` (100%) antes de salvar.
* **Gerenciamento em Cascata:** Ao remover uma `Turma`, todas as suas entidades `Avaliacao` vinculadas devem ser excluídas do banco de dados automaticamente.