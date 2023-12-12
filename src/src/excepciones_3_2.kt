fun main() {
    fun impares(ultimo: Int): String {
        var resultado = ""
        for (n in 0 until ultimo step 2) {
            resultado += "${n + 1}, "
        }
        return resultado.dropLast(2)
    }

    var numeroValido = false
    var numeroUtil = 0

    while (!numeroValido) {
        try {
            print("Lista de números impares. Dime hasta qué número llego\t")
            val ultimoNumero = readLine() ?: ""
            numeroUtil = ultimoNumero.toInt()
            if (numeroUtil <= 0) {
                throw NumberFormatException()
            }
            numeroValido = true
        } catch (e: NumberFormatException) {
            println("Por favor, introduzca un rango válido")
        }
    }
    val listaImpares = impares(numeroUtil)
    println(listaImpares)
}
