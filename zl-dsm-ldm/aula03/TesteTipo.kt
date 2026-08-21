open class Pessoa { 
    var nome : String = ""
    get() { 
        return field
    }
    set( value ) { 
        field = value
    }
    
    constructor( nome : String ){ 
        this.nome = nome
    }
}

class Aluno(
    nome : String,
    var ra : String = ""
) : Pessoa(nome) { 
    
    fun mostrarDados() { 
        println("Nome: ${this.nome}")
        println("RA: ${this.ra}")
    }
    
    override fun toString() : String { 
        return "Nome: ${this.nome}\tRA: ${this.ra}"
    }
    
} 

fun main(args: Array<String>) {
    
    // val p1 = Pessoa()
    // p1.nome = "Joao Silva"
    val p1 = Aluno("Maria Silva", "0001")
    p1.mostrarDados()
    
    val p2 = Aluno("Joao Silva", ra = "0002")
    p2.mostrarDados()
    
    val p3 : Pessoa = Aluno("Jose Santos", "0003")
    
    println("Aluno p1: $p1")
    
    if (p3 is Aluno) { 
        println("Variavel p3 é do tipo Pessoa")
        p3.mostrarDados()
    } else { 
        println("Variavel p3 não  é do tipo Pessoa")
    }
}