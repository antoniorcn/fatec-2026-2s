package edu.curso.pulse.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Turma (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long = 0,
    val codigo : String = "",
    val nomeDisciplina : String = "",
    val semestre : Int = 0,
    val ano : Int = 0
) {

}

/*

    val t = Turma(2, "0002", "Matematica", 2, 2026)

    ORM

    INSERT INTO turma VALUES (2, '0002', 'Matematica', 2, 2026)

    ----------------

    SELECT * FROM turma

    ORM

    val turmas = mutableListOf<Turma>(
        new Turma(2, "0002", "Matematica", 2, 2026)
    )



 */



//* `id` (Long): Identificador único da turma (Chave Primária).
//* `codigo` (String): Código de identificação (ex: `"JAVA-2026-1N"`).
//* `nomeDisciplina` (String): Nome do componente curricular (ex: `"Desenvolvimento Web com Spring Boot"`).
//* `semestre` (Integer): Semestre letivo corrente (ex: `1` ou `2`).
//* `ano` (Integer): Ano de vigência (ex: `2026`).
//* `avaliacoes` (List<Avaliacao>): Lista com o detalhamento das avaliações do curso (`@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)`).


