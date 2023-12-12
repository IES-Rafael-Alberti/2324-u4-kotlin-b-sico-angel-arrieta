fun main() {
    fun unaVida(edad: Int): String {
        var resultado = ""
        if (edad == 0) {
            resultado = "0\n"
        } else {
            for (anos in 0 until edad) {
                resultado += "${anos + 1}\n"
            }
        }
        return resultado.trim()
    }
    var edadValida = false
    var edadActual = 0

    while (!edadValida) {
        try {
            print("Introduzca su edad\t")
            val edadIngresada = readLine() ?: ""
            edadActual = edadIngresada.toInt()
            if (edadActual < 0) {
                throw NumberFormatException()
            }
            edadValida = true
        } catch (e: NumberFormatException) {
            println("Por favor, introduzca una edad válida")
        }
    }
    val recorridoVida = unaVida(edadActual)
    println(recorridoVida)
}
