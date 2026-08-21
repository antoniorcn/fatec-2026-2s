fun main() { 
    println("Ola mundo - Laboratório Desenvolvimento Multiplataforma")
    
    var a = 10
    val b = 20

    a = a + 1
    // b = 30 // Não pode receber um novo valor | Val funciona como final
    
    val c = 20.0
    
    // val lista : List<Int> = listOf(10, 20, 30, 50)  // Lista Imutável
    val lista : MutableList<Int> = mutableListOf(10, 20, 30, 50) // Lista Mutavel
    lista.add( 60 )
    
    println("Lista: $lista")
    
    if (60 in lista) { 
        println("Numero 60 pertence a lista")
    } else { 
        println("Numero 60 não pertence a lista")
    }
    
}