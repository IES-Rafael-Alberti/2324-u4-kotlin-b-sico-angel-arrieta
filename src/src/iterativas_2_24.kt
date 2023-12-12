fun main() {
    fun contadorPrimos(lista: List<Int>): Int {
        var primosEncontrados = 0
        for (numero in lista) {
            var comparador = numero - 1
            while (comparador > 1) {
                val resto = numero % comparador
                if (resto > 0) {
                    comparador -= 1
                } else if (resto == 0) {
                    primosEncontrados -= 1
                    comparador = 0
                }
            }
            primosEncontrados += 1
        }
        return primosEncontrados
    }
    val listaARevisar = mutableListOf<Int>()
    var numero = 1

    while (numero != 0) {
        println("Dime números mayores que 1")
        println("(Ingresa 0 para terminar):")
        numero = readLine()?.toIntOrNull() ?: -1
        if (numero > 1) {
            listaARevisar.add(numero)
        } else if (numero < 0 || numero == 1) {
            println("Número no registrado")
        }
    }
    val primosEncontrados = contadorPrimos(listaARevisar)
    println("De los números que has ingresado $primosEncontrados de ellos son primos")
}
