package Introduccion

fun main(){
    fun listaCompra(productos: String): String{
        val lista = productos.split(",")
        val listado: MutableList<String> = mutableListOf()
        for (producto in lista){
            listado.add(producto.trim())
        }
        return listado.joinToString("\n")
    }
    println("Introduce los productos de tu lista de la compra separado por comas:")
    val listaDeLaCompra = readln()
    val cestaCompra = listaCompra(listaDeLaCompra)
    println(cestaCompra)
}