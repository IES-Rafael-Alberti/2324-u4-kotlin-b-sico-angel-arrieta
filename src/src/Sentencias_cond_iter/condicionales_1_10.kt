package Sentencias_cond_iter

fun main() {
    fun menu(afirmacion: String): Any {
        return when (afirmacion.lowercase()) {
            // para simplificar la expresión when, la variable a comparar la paso como argumento
            "si" -> mutableListOf("pimiento", "tofu")
            "no" -> mutableListOf("pimiento", "tofu", "peperoni", "jamón", "salmón")
            else -> "Error"
        }
    }
    fun anadir(menu: MutableList<*>, ingrediente: String): Any {
        return when (ingrediente) {
            in menu -> {
                menu.remove(ingrediente)
                Pair(menu, ingrediente)
            }
            "salir" -> "fuera"
            else -> "no_hay"
        }
    }
    fun comanda(pizza: List<String>, preferencia: String): Pair<String, String> {
        val tipo = if (preferencia == "si") {"vegetariana "} else {""}
        /* para poder declarar la variable tipo sin block scope, en vez de crear las condiciones
            y declarar la variable dentro, la propia declaración de la variable son las condiciones */
        val componentes = pizza.joinToString(", ")
        return Pair(tipo, componentes)
    }
    val pizza = mutableListOf("tomate", "queso")
    println("Bienvenidos a la pizzeria Bella Napoli")
    print("¿Es usted vegetariano o no? (si/no): ")
    val preferencia = readLine()?.lowercase() ?: ""
    val opciones = menu(preferencia)
    if (opciones is MutableList<*>) {
        while (opciones.isNotEmpty()) {
            println(opciones)
            println("Escoja un ingrediente (Introduce 'salir' para terminar)")
            val ingrediente = readLine()?.lowercase() ?: ""
            val respuesta = anadir(opciones, ingrediente)
            if (respuesta is Pair<*, *>) {
                val (opcionesDebenSer, ingrediente) = respuesta
                pizza.add(ingrediente as String)
                opciones.remove(ingrediente)
            } else {
                if (respuesta == "fuera") {
                    break
                }
                println("El ingrediente no existe o se ha acabado")
            }
        }
        val (tipo, componentes) = comanda(pizza, preferencia)
        println("Has pedido una pizza $tipo con $componentes")
    } else {
        println("Aclaración mal introducida")
    }
}
