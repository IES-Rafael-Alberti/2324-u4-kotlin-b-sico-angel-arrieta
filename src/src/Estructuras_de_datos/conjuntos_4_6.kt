package Estructuras_de_datos

fun main() {
    val vocales = setOf("a", "e", "i", "o", "u")
    val cadenaConsonantes = "qwrtypsdfghjklñzxcvbnm"
    val consonantes = cadenaConsonantes.toList().toSet()
    val letrasComunes = vocales intersect consonantes
    println("Las letras comunes entre las vocales y las consonantes son: $letrasComunes")
}
