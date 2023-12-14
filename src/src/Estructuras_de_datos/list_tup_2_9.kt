package Estructuras_de_datos

fun main() {
    fun cuentaVocales(palabra: String): List<Pair<Char, Int>> {
        val palabraLowerCase = palabra.lowercase()
        val vocales = mutableListOf(
            Pair('a', 0),
            Pair('e', 0),
            Pair('i', 0),
            Pair('o', 0),
            Pair('u', 0)
        )
        for (caracter in palabraLowerCase) {
            when (caracter) {
                'a' -> vocales[0] = Pair('a', vocales[0].second + 1)
                'e' -> vocales[1] = Pair('e', vocales[1].second + 1)
                'i' -> vocales[2] = Pair('i', vocales[2].second + 1)
                'o' -> vocales[3] = Pair('o', vocales[3].second + 1)
                'u' -> vocales[4] = Pair('u', vocales[4].second + 1)
            }
        }

        val resultado = vocales.filter { it.second > 0 }
        return resultado
    }
    fun controlPalabra(palabra: String): Int {
        val espacioRegex = Regex(" ")
        var fallo = 0

        if (palabra.isEmpty()){
            fallo = 3
        } else if (espacioRegex.containsMatchIn(palabra)) {
            fallo = 2
        } else {
            for (caracter in palabra) {
                if (!caracter.isLetter()) {
                    fallo = 1
                    break
                }
            }
        }

        return fallo
    }
    var error = 0

    try {
        println("Dime una palabra para contarle las vocales:")
        val palabra = readLine() ?: ""
        error = controlPalabra(palabra)

        if (error != 0) {
            throw IllegalArgumentException(error.toString())
        }

        val vocalesContadas = cuentaVocales(palabra)

        if (vocalesContadas.isEmpty()) {
            println("No se han contado vocales")
        } else {
            var salida = "Se han contado: "
            for (dupla in vocalesContadas) {
                salida += "${dupla.second} ${dupla.first}, "
            }
            println(salida.removeSuffix(", "))
        }
    } catch (e: IllegalArgumentException) {
        when (e.message?.toInt()) {
            1 -> println("la palabra contiene caracteres que no son letras")
            2 -> println("la palabra puede ser una frase (contiene espacios)")
            3 -> println("la palabra está vacía")
        }
    }
}
