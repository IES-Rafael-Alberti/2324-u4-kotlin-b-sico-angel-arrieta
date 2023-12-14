package Estructuras_de_datos

fun main() {
    fun cuenta(palabra: String, letra: String): Int {
        var veces = 0
        val palabraLowerCase = palabra.lowercase()
        val letraLowerCase = letra.lowercase()
        veces += palabraLowerCase.count { it.toString() == letraLowerCase }
        return veces
    }
    fun controlLetra(letra: String): Int {
        var fallo = 0

        if (letra.isEmpty()) {
            fallo = 1
        } else if (letra.length > 1) {
            fallo = 2
        } else if (!letra[0].isLetter()) {
            fallo = 3
        }
        return fallo
    }
    var error = 0
    val palabra = "banana"

    try {
        println("Dime una letra a buscar en $palabra :")
        val letra = readLine() ?: ""

        error = controlLetra(letra)
        if (error != 0) {
            throw IllegalArgumentException()
        }
        val veces = cuenta(palabra, letra)

        println("En ${palabra.lowercase()} hay $veces ${letra.lowercase()}")
    } catch (e: IllegalArgumentException) {
        when (error) {
            1 -> println("Introduce AL MENOS UNA letra")  // Esta vacío
            2 -> println("Se permite SOLO UNA letra")  // Es más de un carácter
            3 -> println("Se pide una LETRA")  // No es una letra
        }
    }
}
