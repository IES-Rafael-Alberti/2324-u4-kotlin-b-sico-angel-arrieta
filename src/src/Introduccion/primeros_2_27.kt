package Introduccion

import java.math.RoundingMode

fun main(){
    fun calcularPrecio(objeto: String, valor: String, monto: String): String{
        val regInt = """[0-9]+""".toRegex()
        val regFloat = """[0-9]+[.][0-9]+""".toRegex()
        val apto = regInt.matchEntire(valor)
        if (apto == null){
            val valido = regFloat.matchEntire(valor)
            if (valido == null){
                val mensaje = "Precio no reconocido"
                return mensaje
            }
        }
        val precio = valor.toBigDecimal().setScale(2, RoundingMode.UP).toFloat()
        val sirve = regInt.matchEntire(monto)
        if (sirve == null){
            val mensaje = "Cantidad no reconocida"
            return mensaje
        }
        val mensaje = "$monto $objeto vale ${precio * monto.toInt()}"
        return mensaje

    }
    println("Producto a comprar: ")
    val producto = readln()
    println("Precio del producto: ")
    val precio = readln()
    println("Cantidad del producto: ")
    val cantidad = readln()
    val ticket = calcularPrecio(producto, precio, cantidad)
    println(ticket)
}