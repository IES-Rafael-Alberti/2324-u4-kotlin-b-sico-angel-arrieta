package Estructuras_de_datos
import kotlin.math.pow

fun main() {
    fun dividir(lista: String): List<String> {
        return lista.split(",").map { it.trim() }
    }
    fun controlLista(lista: List<String>): Int {
        val regex = Regex("\\D")
        var fallo = 0
        for (numero in lista) {
            if (regex.find(numero) != null) {
                fallo = 1
                break
            } else if (numero == "") {
                fallo = 2
                break
            }
        }
        return fallo
    }
    fun adecuacionLista(lista: List<String>): List<Double> {
        return lista.map { it.toDouble() }
    }
    fun mediaAritmetica(lista: List<Double>): Double {
        return lista.sum() / lista.size.toDouble()
    }
    fun desviacion(lista: List<Double>, media: Double): Double {
        val sumatorio = lista.sumOf { (it - media).pow(2) }
        return kotlin.math.sqrt(sumatorio / lista.size)
    }
    var error = 0
    try {
        println("Ingresa una lista de números separada por comas:")
        val listado = readLine() ?: ""
        val listaDividida = dividir(listado)
        error = controlLista(listaDividida)
        if (error != 0) {
            throw IllegalArgumentException(error.toString())
        }
        val listaTipada = adecuacionLista(listaDividida)
        val media = mediaAritmetica(listaTipada)
        val desviacionTipica = desviacion(listaTipada, media)
        val listaAdecuada = mutableListOf<Int>()
        for (numero in listaTipada){
            listaAdecuada.add(numero.toInt())
        }
        println("De $listaAdecuada la media es ${Math.round(media * 100.0) / 100.0} y la desviación típica es " +
                "${Math.round(desviacionTipica * 100.0) / 100.0}")
    } catch (e: IllegalArgumentException) {
        if (error == 1) {
            println("Algún elemento de la lista contiene caracteres no numéricos")
        } else if (error == 2) {
            println("Algún elemento de la lista esta vacío")
        }
    }
}