package Sentencias_cond_iter

fun main() {
    fun paridadDigitos(numero: Int): Pair<Int, Int> {
        val digitos = numero.toString().toCharArray()
        var digitosPares = 0
        var digitosImpares = 0
        for (digito in digitos) {
            if (Character.getNumericValue(digito) % 2 == 1) {
                digitosImpares++
            } else {
                digitosPares++
            }
        }
        return Pair(digitosPares, digitosImpares)
    }
    var pares = 0
    var impares = 0
    var numero = 1

    while (numero != 0) {
        println("Introduzca un numero positivo (introduce 0 para salir):")
        numero = readLine()?.toIntOrNull() ?: -1
        if (numero < 0) {
            println("Ingresa un número positivo")
        } else if (numero == 0) {
            continue
        } else {
            val (nuevosPares, nuevosImpares) = paridadDigitos(numero)
            println("Tiene $nuevosPares digitos pares y $nuevosImpares digitos impares")
            pares += nuevosPares
            impares += nuevosImpares
        }
    }
    println("En total has introducido $pares digitos pares y $impares digitos impares")
}
