package Estructuras_de_datos

fun main() {
    fun esPar(conjunto: Set<Int>): Set<Int> {
        val numerosPares = mutableSetOf<Int>()
        for (variable in conjunto) {
            if (variable % 2 == 0) {
                numerosPares.add(variable)
            }
        }
        return numerosPares
    }
    fun multiplosTres(conjunto: Set<Int>): Set<Int> {
        val trimultiplos = mutableSetOf<Int>()
        for (numero in conjunto) {
            if (numero % 3 == 0) {
                trimultiplos.add(numero)
            }
        }
        return trimultiplos
    }
    val numeros = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val pares = esPar(numeros)
    val numerosMultiplosDeTres = multiplosTres(numeros)
    val paresYMultiplosDeTres = pares intersect numerosMultiplosDeTres

    println("Pares del 1 al 10:")
    println(pares)
    println("Múltiplos de 3 del 1 al 10:")
    println(numerosMultiplosDeTres)
    println("Números comunes entre pares y múltiplos de 3 del 1 al 10:")
    println(paresYMultiplosDeTres)
}
