fun main() {
    fun compra(totalVenta: Int, ultimoPrecio: Int): Int {
       return when {
            ultimoPrecio < 0 -> totalVenta
            else -> totalVenta + ultimoPrecio
        }
    }
    fun descuento(pedido: Int): Int {
        val diezPorciento = pedido / 10
        return when {
            pedido >= 1000 -> (pedido - diezPorciento)
            else -> pedido
        }
    }
    println("Ingresa los precios de los productos a comprar")
    println("(Si la compra supera más de $1000 se aplica un 10% de descuento)")
    var totalCompra = -1
    var ultimoMonto = 1
    while (ultimoMonto != 0) {
        totalCompra = compra(totalCompra, ultimoMonto)
        print("Precio (Ingrese 0 para terminar) :\t")
        ultimoMonto = readLine()?.toIntOrNull() ?: -1
        if (ultimoMonto < 0) {
            println("Ingrese otro monto")
        }
    }
    totalCompra = descuento(totalCompra)
    println("Total a pagar: $totalCompra")
}