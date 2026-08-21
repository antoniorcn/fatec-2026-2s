data class Aluno(
    var ra : String = "",
    var nome : String = "",
    var idade : Int = 0
) {
    
    operator fun plus( outro : Aluno ) : Aluno { 
        val novoAluno = Aluno(
            "${this.ra} - ${outro.ra}",
            "${this.nome} - ${outro.nome}",
                this.idade + outro.idade
        )
        return novoAluno
    }
    
    operator fun times( quantidade : Int ) : MutableList<Aluno> { 
        val lista : MutableList<Aluno> = mutableListOf()
        for ( i in 1 .. quantidade) { 
            lista.add( this )
        }
        return lista
    }
    
}

fun mostrarDadosAluno( aluno : Aluno, 
                       cabecalho : String = "Padrao"
                        ) { 
    val textoAluno = aluno.toString()
    println("Cabecalho Relatorio: $cabecalho")
    println("Texto do Aluno Não Nulável: $textoAluno")
}


fun mostrarDadosAlunoNulavel( aluno : Aluno? ) { 
    val textoAluno = aluno?.toString() ?: "o objeto aluno esta nulo"
    println("Texto do Aluno Nulável: $textoAluno")
}

fun Aluno.mostrarNome() { 
    println("Nome: ${this.nome}")
}


fun main() { 
    var a1 : Aluno? = null
    a1 = Aluno("0001", "Maria Silva", 19)
    
    val a2 : Aluno? = Aluno("0002", "Joao Silva", 21)
    
    var n1 : Double = 10.5
    var n2 : Double = 20.9
    
    var n3 = n1 + n2
    
    var a3 = a1!! + a2!!
    
    val lista1 = a2 * 4
    println("Lista1 : $lista1")
    println("Alunos somados a1 + a2 ==> $a3")
    // a1 : Aluno?
    mostrarDadosAlunoNulavel( a1 )
    
    if ( a1 != null) {
        // a1 agora vai do tipo Aluno
        a1.mostrarNome()
        mostrarDadosAluno( cabecalho = "diferente", aluno = a1 ) // a1 : Aluno
    } else { 
        println("Objeto a1 está nulo")
    }
    
    // val a2 : Aluno = a1!!
    
    mostrarDadosAluno( a1!! ) // Garanto que o a1 quando 
    a1!!.mostrarNome()
    // chegar nesta linha não vai ser nulo
    
}