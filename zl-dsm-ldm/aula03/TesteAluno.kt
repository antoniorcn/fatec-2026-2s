data class Aluno(
    var ra : String = "",
    var nome : String = "",
    var idade : Int = 0
) {
    
}


fun main() {
    val a1 = Aluno("0001", "Maria Silva", 19)
    val a2 = Aluno("0002", "Joao Silva", 20)
    val a3 = Aluno("0001", "Maria Silva", 19)
    val a4 = a1
    
    println("A1: $a1")
    println("A2: $a2")
    println("A3: $a3")
    println("A4: $a4")
    
    if (a1 == a2) { 
        println("A1 e A2 são iguais")
    } else { 
        println("A1 e A2 são diferentes")
    }
    
    if (a1 == a3) { 
        println("A1 e A3 são iguais")
    } else { 
        println("A1 e A3 são diferentes")
    }
    
    if (a1 === a3) { 
        println("A1 e A3 são instancias iguais")
    } else { 
        println("A1 e A3 são instancias diferentes")
    }
    
    if (a1 === a4) { 
        println("A1 e A4 são instancias iguais")
    } else { 
        println("A1 e A4 são instancias diferentes")
    }    
}