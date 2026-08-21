class Pessoa(
    var nome : String,
    var idade : Int
) {
    override fun toString() : String { 
        return "Nome: ${this.nome}\tIdade: ${this.idade}"
    }
}
    
    // var nome : String = ""
    // var idade : Int = 0 
    
    // constructor(nome : String, idade : Int ) { 
    //     this.nome = nome;
    //     this.idade = idade;
    //     println("Pessoa criada em Kotlin")
    // }
    


fun main() { 
    
    val p1 = Pessoa("Joao Silva", 21)
    val p2 = Pessoa("Maria Silva", 20)
    
}