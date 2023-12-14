package Estructuras_de_datos

fun main() {
    fun minMax(lista: List<Int>): List<Int> {
        val minMax = mutableListOf<Int>()
        minMax.add(lista.minOrNull() ?: 0)
        minMax.add(lista.maxOrNull() ?: 0)
        return minMax
    }

    val lista = listOf(50, 75, 46, 22, 80, 65, 8)

    val resultado = minMax(lista)

    println("El menor precio es ${resultado[0]} y el mayor ${resultado[1]}")
}
