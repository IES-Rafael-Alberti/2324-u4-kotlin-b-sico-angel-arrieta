package Sentencias_cond_iter

fun main() {
    fun algoritmoBurbuja(lista: MutableList<Int>): List<Int> {
        var revisionesRealizadas = 0
        for (veces in 0 until lista.size - 1) {
            for (actual in 0 until lista.size - revisionesRealizadas) {
                if (lista.indexOf(lista[actual]) == lista.size - 1) {
                    continue
                } else {
                    val siguiente = lista[actual + 1]
                    if (lista[actual] < siguiente) {
                        continue
                    } else if (lista[actual] > siguiente) {
                        val segundo = lista[actual]
                        lista[actual] = lista[actual + 1]
                        lista[actual + 1] = segundo
                    }
                }
            }
            revisionesRealizadas += 1
        }
        return lista
    }
    val listado = mutableListOf(8, 3, 1, 19, 14)
    try {
        val procesado = algoritmoBurbuja(listado)
        println(procesado)
    } catch (e: NumberFormatException) {
        println("Un valor de la lista no es un número entero")
    } catch (e: Exception) {
        println("No se puede ejecutar el algoritmo")
    }
}
