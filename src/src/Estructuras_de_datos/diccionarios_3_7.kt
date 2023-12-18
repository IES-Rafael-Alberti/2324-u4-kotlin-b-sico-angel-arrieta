package Estructuras_de_datos

fun main() {
    fun controlArticulo(mercancia: String): Int {
        val regex = Regex("[^A-Za-zÁáÉéÍíÓóÚú\\s-]")
        return when {
            regex.find(mercancia) != null -> 1
            else -> 0
        }
    }
    fun controlValor(precio: String): Int {
        val dotCount = precio.count { it == '.' }
        val regex = Regex("[^0-9.]")
        return when {
            dotCount > 2 -> 2
            regex.find(precio) != null -> 2
            else -> 0
        }
    }
    fun cesta(listaDeCompra: Map<String, Double>): String {
        var factura = ""
        var total = 0.0
        listaDeCompra.forEach { (mercancia, precio) ->
            factura += "$mercancia: $precio\n"
            total += precio
        }
        factura += "Total: ${"%.2f".format(total)}"
        return factura
    }
    val listaDeLaCompra = mutableMapOf<String, Double>()
    var error = 0
    var articulo: String
    try {
        do {
            println("¿Qué artículo desea comprar?")
            print("(Inserte 'terminar' para acabar el programa)\n> ")
            articulo = readLine() ?: ""
            if (articulo != "terminar") {
                error = controlArticulo(articulo)
                if (error != 0) {
                    throw IllegalArgumentException(error.toString())
                }
                print("Inserte precio de $articulo ('.' como coma decimal)\n> ")
                val valor = readLine() ?: ""
                error = controlValor(valor)
                if (error != 0) {
                    throw IllegalArgumentException(error.toString())
                }
                listaDeLaCompra[articulo] = valor.toDouble()
            }
        } while (articulo != "terminar")

        if (listaDeLaCompra.isEmpty()) {
            println("Lista de la compra vacía")
        } else {
            val ticket = cesta(listaDeLaCompra)
            println(ticket)
        }
    } catch (e: IllegalArgumentException) {
        when (error) {
            1 -> println("el articulo contiene caracteres no reconocibles\n(Caracteres reconocidos: " +
                    "['A'-'Z', 'a'-'z', 'Á', 'á', 'É', 'é', 'Í', 'í', 'Ó', 'ó', 'Ú', 'ú', ' ',  '-'])")
            2 -> println("el precio contiene caracteres no reconocibles\n" +
                    "(Solo se reconoce del 0 al 9 y '.' solo una vez como separador decimal)")
        }
    }
}
