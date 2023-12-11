import java.math.RoundingMode

fun main() {
    fun desglose(precio: Float): String {
        val redondeado = precio.toBigDecimal().setScale(2, RoundingMode.UP).toString()
        val precioPorPartes = redondeado.split(".")
        val unidades = precioPorPartes[0]
        val decimales = precioPorPartes[1]
        val mensaje = "El artículo vale $unidades euros y $decimales centimos"
        return mensaje
    }
    print("Introduzca el precio de un producto: ")
    val valor = readln()
    val numero = valor.toFloat()
    val desglosado = desglose(numero)
    println(desglosado)
}
