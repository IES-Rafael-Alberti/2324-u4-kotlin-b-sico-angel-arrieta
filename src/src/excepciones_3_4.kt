fun main() {
    fun esEntero(numero: Any): Boolean {
        return numero !is Int
    }
    var entradaInvalida = false

    while (!entradaInvalida) {
        try {
            print("Introduce números enteros\t")
            val entrada = readLine() ?: ""
            val entradaUtil = entrada.toInt()
            entradaInvalida = esEntero(entradaUtil)
        } catch (e: NumberFormatException) {
            println("La entrada no es correcta")
            entradaInvalida = true
        }
    }
}