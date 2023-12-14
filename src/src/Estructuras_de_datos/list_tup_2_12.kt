package Estructuras_de_datos

fun main() {
    fun productoMatrices(primeraMatriz: List<Int>, segundaMatriz: List<Int>): List<Int> {
        val producto = mutableListOf<Int>()
        for (numero in segundaMatriz) {
            var adjunto = 0
            for (valor in primeraMatriz) {
                adjunto += numero * valor
            }
            producto.add(adjunto)
        }
        return producto
    }
    val matrizA = listOf(1, 2, 3, 4, 5, 6)
    val matrizB = listOf(-1, 0, 0, 1, 1, 1)

    val resultado = productoMatrices(matrizA, matrizB)

    println(resultado)
}