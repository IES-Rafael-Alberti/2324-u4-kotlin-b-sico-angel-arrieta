package Estructuras_de_datos

fun main() {
    fun revertirCadena(cadenaInicial: String): String {
        var cadenaInvertidaYSeparada = ""
        val cadenaInvertida = cadenaInicial.reversed()
        var posicion = 0
        while (posicion < cadenaInvertida.length) {
            cadenaInvertidaYSeparada += "${cadenaInvertida[posicion]}\n"
            posicion++
        }
        return cadenaInvertidaYSeparada.dropLast(1)
    }
    try {
        println("Dime una palabra o frase para invertirla:")
        val aInvertir = readLine() ?: ""

        val cadenaDelReves = revertirCadena(aInvertir)

        println(cadenaDelReves)
    } catch (e: Exception) {
        println("El o los valores introducidos no son un string invertible")
    }
}
