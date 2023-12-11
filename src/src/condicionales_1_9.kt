fun main() {
    fun entrada(edad: Int): String {
        return when {
            edad in 1 until 4 -> "¿A qué esperas? ¡Entra adentro, chic@!"
            edad in 5 until 17 -> "¡Por 5 euros puedes entrar, chaval!"
            edad in 18 until 24 -> "Por solo 10 euros puede entrar, jovencit@"
            edad >= 25 -> "Buenas señor/a, debe pagar 10 euros por la entrada"
            else -> "Perdona, pero no lo entendí bien"
        }
    }
    println("Bienvenido a Fazbear Entertainment")
    print("Introduzca su edad: ")
    val edad = readLine()?.toIntOrNull() ?: 0
    // "?" en "readline()?" si el valor recogido está vacío, el valor pasa a null en vez de levantar un error
    // ".toIntOrNull()" recoge un valor y lo convierte a entero, si no es posible, lo convierte en null
    /* "?: 0" recoge el valor de la expresión anterior completa, si recoge null,
        se le asigna un valor determinado (en este caso 0) */
    val entra = entrada(edad)
    println(entra)
}