fun main() {
    fun declaracion(renta: Int): String {
        return when {
            renta in 1 until 10000 -> "Su renta anual es del 5%"
            renta in 10000 until 20000 -> "Su renta anual es del 15%"
            renta in 20000 until 35000 -> "Su renta anual es del 20%"
            renta in 35000 until 60000 -> "Su renta anual es del 30%"
            renta >= 60000 -> "Su renta anual es del 45%"
            else -> "Valor de renta sin sentido"
        }
        /* la expresión "when { variable -> 1  variable -> 2 }" sirve para expresar
            condiciones "if-elseif-else" de manera más concisa */
    }
    print("Introduzca su renta anual\n")
    val renta = readLine()?.toIntOrNull() ?: 0
    // "?" en "readline()?" hace que si lo introducido está vacío, el valor sea null en vez de levantar un error
    /* ".toIntOrNull()" coge el valor que se le pasa y lo convierte a entero, si no es posible, lo convierte en null
        (el valor que se le pasa viene de lo anterior "readline()?", en este caso) */
    /* la expresión "?: 0" hace que, si el valor que sale de la expresión anterior completa
        (la cual es "readLine()?.toIntOrNull()") es null, se le asigna el valor determinado
        (en este caso 0) */
    val declarado = declaracion(renta)
    println(declarado)
}
