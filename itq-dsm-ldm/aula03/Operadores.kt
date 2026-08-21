// class Pessoa( 
//     var nome : String,
//     var idade : Int
// ) { 
//     // var nome : String = ""
//     // get() { 
//     //     return field
//     // }
//     // set( valor : String ) { 
//     //     field = valor
//     // }
    
//     // var idade : Int = 0
    
//     override fun toString() : String { 
//         return "Nome: ${this.nome}\tIdade: ${this.idade}"
//     }
// }

fun main() {
    var a = 10
    // a = 10
    a = a + 1
    // a = 11
    a += 1
    // a = 12

    val lista = listOf( 1, 3, 5, 7, 9, 11, 13 )
    var numero = 5

    if (numero in lista) { 
        println("O numero ${numero} está na lista")
    } else { 
        println("O numero $numero não está na lista")
    }
}
