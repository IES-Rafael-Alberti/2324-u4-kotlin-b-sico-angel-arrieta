package Estructuras_de_datos
import java.util.*

fun main() {
    fun comprobarAdecuacion(campo: String, info: String): Int {
        var fallo = 0
        var regex: Regex
        when (campo) {
            "NIF" -> {
                regex = Regex("^[1-9][0-9]{7}[A-Z]$")
                if (!regex.matches(info)) { fallo = 1 }
            };"nombre" -> {
            regex = Regex("[^A-Za-z ÁáÉéÍíÓóÚúÑñ]")
            if (regex.find(info) != null) { fallo = 2 }
            }; "dirección" -> {
            regex = Regex("/")
            if (regex.find(info) == null || info.count { it == '/' } > 1) { fallo = 3 }
            else {
                val (via, direccion) = info.split("/")
                regex = Regex("C[.]|Call[.]|Cam[.]|Carr[.]|Avd[.]|Avda[.]|Pl[.]|Urb[.]|Trav[.]")
                if (regex.find(via.trim()) == null) { fallo = 4 }
                else {
                    regex = Regex("[^A-Za-z 0-9ÁáÉéÍíÓóÚúÑñº]")
                    if (regex.find(direccion.trim()) != null)
                    { fallo = 5 } } }
            };"teléfono" -> {
                if (info.length != 9 || !info.all { it.isDigit() })
                { fallo = 6 }
            }; "correo" -> {
                if (info.count { it == '@' } != 1)
                { fallo = 7 }
                else {
                    val (nombreServicio, dominio) = info.split("@")
                    if (dominio.count { it == '.' } != 1)
                    { fallo = 7 }
                    else {
                        val (nombre, servicio) = dominio.split(".")
                        regex = Regex("[^A-Za-z_.0-9-]")
                        val regex1 = Regex("[^a-z]")
                        if (regex.find(nombreServicio) != null || regex1.find(nombre) != null || regex1.find(servicio) != null)
                        { fallo = 8 } }
                    }
            }; "preferente" -> {
                regex = Regex("true|false")
                if (regex.find(info) == null) {
                    fallo = 9 } }
            }
        return fallo
    }
    fun nombresClientes(listaClaves: List<String>, diccionario: MutableMap<String, MutableMap<String, Any>>): List<String>
    {   val duplasNifNombre = mutableListOf<String>()
        for (dni in listaClaves) {
            val datosCliente = diccionario[dni]
            val nombre = datosCliente?.get("nombre").toString()
            duplasNifNombre.add("$dni: $nombre")
        }
        return duplasNifNombre }
    val clientes = mutableMapOf<String, MutableMap<String, Any>>()
    var error: Int
    var opcion = ""
    val scanner = Scanner(System.`in`)
    while (opcion != "6") {
        try {
            print(
                """
                    BBDD de Banco Arrieta
                    ________________________________
                    ${clientes.size} clientes
                    --------------------------------
                    1 - Añadir cliente
                    2 - Eliminar cliente
                    3 - Mostrar cliente
                    4 - Listar todos los clientes
                    5 - Listar clientes preferentes
                    6 - Terminar
                    > 
                """.trimIndent()
            )
            opcion = scanner.nextLine()
            when (opcion) {
                "1" -> {
                    val claves = listOf("nombre", "dirección", "teléfono", "correo", "preferente")
                    print("\nNIF del cliente\n> ")
                    val nif = scanner.nextLine()
                    error = comprobarAdecuacion("NIF", nif)
                    if (error != 0) {
                        throw IllegalArgumentException(error.toString())
                    }
                    val cliente = mutableMapOf<String, Any>()
                    for (clave in claves) {
                        if (clave == "preferente") {
                            print("[Introduce true or false]")
                        }
                        print("\n$clave del cliente\n> ")
                        val nuevoDato = scanner.nextLine()
                        error = comprobarAdecuacion(clave, nuevoDato)
                        if (error != 0) {
                            throw IllegalArgumentException(error.toString())
                        }
                        if (clave == "preferente") {
                            cliente[clave] = nuevoDato.toBoolean()
                        } else {
                            cliente[clave] = nuevoDato
                        }
                    }
                    clientes[nif] = cliente
                }
                "2" -> {
                    if (clientes.isEmpty()) {
                        println("\n No hay clientes para eliminar")
                    } else {
                        println("\nNIFS: ${clientes.keys}")
                        print("\nQué cliente desea borrar de la base de datos\n> ")
                        val eliminar = scanner.nextLine()
                        error = comprobarAdecuacion("NIF", eliminar)
                        if (error != 0) {
                            throw IllegalArgumentException(error.toString())
                        }
                        clientes.remove(eliminar)
                    }
                }
                "3" -> {
                    if (clientes.isEmpty()) {
                        println("\n No hay clientes para mostrar")
                    } else {
                        println("\nNIFS: ${clientes.keys}")
                        print("\nQué cliente desea mostrar de la base de datos\n> ")
                        val buscar = scanner.nextLine()
                        error = comprobarAdecuacion("NIF", buscar)
                        if (error != 0) {
                            throw IllegalArgumentException(error.toString())
                        }
                        val informacion = StringBuilder("\n")
                        val datosBrutos = clientes[buscar]
                        if (datosBrutos != null) {
                            for ((clave, valor) in datosBrutos) {
                                informacion.append("$clave: $valor\n")
                            }
                            println(informacion)
                        }
                    }
                }
                "4" -> {
                    if (clientes.isEmpty()) {
                        println("\n No hay clientes para mostrar")
                    } else {
                        val mensaje = StringBuilder("\nClientes:")
                        val identificadores = clientes.keys.toList()
                        val nombres = nombresClientes(identificadores, clientes)
                        for (referencia in nombres) {
                            mensaje.append("\n$referencia")
                        }
                        println(mensaje)
                    }
                }
                "5" -> {
                    if (clientes.isEmpty()) {
                        println("\n No hay clientes para mostrar")
                    } else {
                        val identificadores = clientes.keys.toList()
                        val idenPreferentes = mutableListOf<String>()
                        for (nif in identificadores) {
                            val datos = clientes[nif]
                            if (datos?.get("preferente") == true) {
                                idenPreferentes.add(nif)
                            }
                        }
                        if (idenPreferentes.isEmpty()) {
                            println("\n No hay clientes preferentes")
                        } else {
                            val mensaje = StringBuilder("\nPreferentes:")
                            val clientesPreferentes = nombresClientes(idenPreferentes, clientes)
                            for (referencia in clientesPreferentes) {
                                mensaje.append("\n$referencia")
                            }
                            println(mensaje)
                        }
                    }
                }
                "6" -> println("\nAdiós, vuelva pronto")
                else -> println("\nOpción no reconocida")
            }

        } catch (e: IllegalArgumentException) {
            when (e.message?.toInt()) {
                1 -> println("El NIF introducido no sigue el formato debido: [123456789A] (No puede empezar por 0)\n")
                2 -> println("El nombre contiene algún carácter que no es alfabético, espacio, vocal mayúscula o minúscula con o sin acento\n")
                3 -> println("La dirección no sigue el formato debido: [C./, Avda./, ... + nombre dirección y número edificio]\n")
                4 -> println("La vía introducida no es reconocida por la Base de datos. Vías Reconocidas:\n" +
                        "[C./, Call./, Cam./, Carr./, Avd./, Avda./, Pl./, Urb./, Trav./]\n")
                5 -> println("El nombre de la dirección contiene algún carácter que no es palabra, espacio, , º,\n" +
                        "vocal mayúscula o minúscula con acento. Carácteres palabra: [A-Za-z]\n")
                6 -> println("El teléfono no se adecua al formato debido. Ejemplo: [123456789] (longitud admitida, 9)\n")
                7 -> println("El correo electrónico no se adecua al formato debido. Ejemplo:[individuo@nombredominio.dominio]\n")
                8 -> println("Alguna parte del correo electrónico contiene carácteres no permitidos. Formato:[individuo@nombredominio.dominio]\n" +
                        "Carácteres permitidos: en individuo: [A-Z, a-z, _, ., 0-9, -] en nombre_dom y dominio: [a-z]\n")
                9 -> println("El valor preferente, no esta bien definido\n")

            }
        } catch (e: Exception) {
            println("\nError inesperado: ${e.message}")
        }
    }
}
