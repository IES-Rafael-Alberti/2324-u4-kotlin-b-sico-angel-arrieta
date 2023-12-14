package Estructuras_de_datos

fun main() {
    fun productoEscalar(vectorA: List<Int>, vectorB: List<Int>): Int {
        var producto = 0
        for ((index, numero) in vectorA.withIndex()) {
            producto += numero * vectorB[index]
        }
        return producto
    }
    val primeraFlecha = listOf(1, 2, 3)
    val segundaFlecha = listOf(-1, 0, 2)

    val prodEscalar = productoEscalar(primeraFlecha, segundaFlecha)

    println(prodEscalar)
}
