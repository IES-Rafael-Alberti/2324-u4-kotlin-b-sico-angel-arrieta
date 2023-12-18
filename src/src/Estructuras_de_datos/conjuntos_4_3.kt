package Estructuras_de_datos

import kotlin.math.pow

fun main() {
    fun conjuntoPotencia(conjuntoTotal: Set<Int>): List<Set<Int>> {
        val listaPotencia = mutableListOf<Set<Int>>()
        listaPotencia.add(emptySet())
        val accesible = conjuntoTotal.toMutableList()

        for (x in conjuntoTotal.indices) {
            if (x != 0) {
                accesible.removeAt(0)
            }

            val combPosibles = 2.0.pow(accesible.size - 1).toInt()
            for (i in 0 until combPosibles) {
                val conjunto = mutableListOf<Int>()
                for (n in accesible) {
                    conjunto.add(n)
                    if (!listaPotencia.contains(conjunto.toSet())) {
                        listaPotencia.add(conjunto.toSet())
                    } else if (accesible.indexOf(n) != 0) {
                        conjunto.remove(n)
                    }
                }
            }
        }
        return listaPotencia
    }

    val superConjunto = setOf(6, 1, 4)

    val subconjuntos = conjuntoPotencia(superConjunto)

    println(subconjuntos)
}
