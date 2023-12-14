package Sentencias_cond_iter

fun main() {
    fun cuentaAtras(inicio: Int): String {
        var resultado = ""
        for (n in inicio downTo 0) {
            resultado += "$n, "
        }
        return resultado.dropLast(2)
    }
    var inicioValido = false
    var primeroUtil = 0

    while (!inicioValido) {
        try {
            print("¿Desde qué número comenzamos la cuenta atrás?\t")
            val primerNumero = readLine() ?: ""
            primeroUtil = primerNumero.toInt()
            if (primeroUtil < 1) {
                throw NumberFormatException()
            }
            inicioValido = true
        } catch (e: NumberFormatException) {
            println("Introduzca un inicio de cuenta lógico")
        }
    }
    val cuentaRegresiva = cuentaAtras(primeroUtil)
    println(cuentaRegresiva)
}
