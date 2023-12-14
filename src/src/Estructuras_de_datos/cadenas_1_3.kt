package Estructuras_de_datos

fun main() {
    fun cuenta(palabra: String, letra: String): Int {
        var contador = 0
        val palabraLowerCase = palabra.lowercase()
        val letraLowerCase = letra.lowercase()

        for (caracter in palabraLowerCase) {
            if (caracter.toString() == letraLowerCase) {
                contador++
            }
        }
        return contador
    }
    fun controlErrores(palabra: String, letra: String): Int {
        val espacioRegex = Regex(" ")
        var fallo = 0

        if (espacioRegex.containsMatchIn(palabra)) {
            fallo = 1
            return fallo
        }
        for (caracter in palabra) {
            if (!caracter.isLetter()) {
                fallo = 2
                return fallo
            }
        }
        if (letra.isEmpty()) {
            fallo = 3
        } else if (letra.length > 1) {
            fallo = 4
        } else if (!letra[0].isLetter()) {
            fallo = 5
        }
        return fallo
    }
    var error = 0
    try {
        println("Dime una palabra:")
        val palabra = readLine() ?: "0"
        print("Dime una letra a contar en la palabra: ")
        val letra = readLine() ?: ""

        error = controlErrores(palabra, letra)
        if (error != 0) {
            throw IllegalArgumentException()
        }
        val letrasEnPalabra = cuenta(palabra, letra)

        println("En $palabra hay $letrasEnPalabra $letra")
    } catch (e: IllegalArgumentException) {
        when (error) {
            1 -> println("Solo se permite una palabra")
            2 -> println("Solo se permiten letras en la palabra")
            3 -> println("Introduce AL MENOS UNA letra")  // Esta vacío
            4 -> println("Se permite SOLO UNA letra")  // Es más de un carácter
            5 -> println("Se pide una LETRA")  // No es una letra
        }
    }
}
