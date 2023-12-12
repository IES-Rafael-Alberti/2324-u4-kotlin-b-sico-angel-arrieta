package Sentencias_cond_iter

fun main() {
    fun laMasLarga(frase: String): String {
        var respuesta = ""
        val palabras = frase.split(" ")
        for (palabra in palabras) {
            if (palabra.length > respuesta.length) {
                respuesta = palabra
            }
        }
        return respuesta
    }
    println("Dime una frase y te diré cuál palabra es")
    println("la más larga y cuántas palabras tiene:")
    val frase = readLine() ?: ""
    val fraseSeparada = frase.split(" ")
    println(fraseSeparada)
    val cantidadPalabras = fraseSeparada.size
    val esGrandota = laMasLarga(frase)
    println("Tu frase tiene $cantidadPalabras palabras y su palabra más larga es: $esGrandota")
}
