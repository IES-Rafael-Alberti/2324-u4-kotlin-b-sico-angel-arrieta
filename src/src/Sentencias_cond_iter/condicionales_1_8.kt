package Sentencias_cond_iter

fun main() {
    fun evaluacion(puntuacion: Double): String {
        return when {
            puntuacion == 0.0 -> "Evaluación inaceptable, sin bonificación obtenida"
            puntuacion == 0.4 -> "Evaluación aceptable, bonificación de ${0.4 * 2400} obtenida"
            puntuacion >= 0.6 -> "Evaluación meritoria obtenida, bonificación de ${puntuacion * 2400}"
            else -> "Datos introducidos ilegibles o incorrectos"
        }
    }
    print("Introducir Evaluación Anual\n")
    val puntuacion = readLine()?.toDoubleOrNull() ?: 0.0
    // "?" en "readline()?" hace que si lo introducido está vacío, el valor sea null en vez de levantar un error
    /* ".toIntOrNull()" coge el valor que se le pasa y lo convierte a entero, si no es posible, lo convierte en null
        (el valor que se le pasa viene de lo anterior) */
    /* la expresión "?: 0.0" hace que, si el valor que sale de la expresión anterior
        completa es null, se le asigna el valor determinado (0.0) */
    val evaluado = evaluacion(puntuacion)
    println(evaluado)
}
