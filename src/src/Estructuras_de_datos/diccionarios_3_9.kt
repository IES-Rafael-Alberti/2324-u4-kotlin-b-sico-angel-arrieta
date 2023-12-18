package Estructuras_de_datos

import java.util.Scanner

fun controlFactura(factura: String): Int {
    val fallo: Int
    if (!factura.contains(":") || factura.count { it == ':' } > 1) {
        fallo = 1
    } else {
        val (identificativo, dinero) = factura.split(":").map { it.trim() }
        if (identificativo.isEmpty() || dinero.isEmpty() ||
            identificativo.matches(Regex("[^0-9]")) ||
            identificativo.startsWith("0") ||
            dinero.count { it == '.' } > 1 ||
            dinero.matches(Regex("[^0-9.]"))
        ) {
            fallo = when {
                identificativo.isEmpty() || dinero.isEmpty() -> 1
                identificativo.matches(Regex("[^0-9]")) -> 2
                identificativo.startsWith("0") -> 3
                dinero.count { it == '.' } > 1 || dinero.matches(Regex("[^0-9.]")) -> 4
                else -> 0
            }
        } else { fallo = 0 } }
    return fallo
}
fun controlIdentificador(identidad: String): Int {
    return when {
        identidad.isEmpty() -> 5
        identidad.matches(Regex("[^0-9]")) -> 6
        else -> 0 }
}
fun recogerIdentificadores(facturasClientes: Map<Int, Double>): List<Int>
    { return facturasClientes.keys.toList() }
fun deudaClientes(facturas: Map<Int, Double>): Double
    { return facturas.values.sum() }

fun main() {
    val contabilidad = mutableMapOf<Int, Double>()
    var dineroCobrado = 0.0
    var opcion = -1
    val scanner = Scanner(System.`in`)
    while (opcion != 0) {
        try {
            print(
                """
                    Contabilidad Revilofe S.A.
                    ________________________________
                    ${contabilidad.size} facturas almacenadas
                    --------------------------------
                    1 - Añadir factura
                    2 - Pagar factura
                    0 - Salir del programa
                    > 
                """.trimIndent()
            )
            opcion = scanner.nextInt()
            scanner.nextLine() // Consumir la nueva línea

            when (opcion) {
                1 -> {
                    val identificadores =
                        if (contabilidad.isEmpty()) "" else recogerIdentificadores(contabilidad).toString()
                    print(
                        """
                            Formato para añadir factura: {nºidentificación: importe}
                            Identificadores existentes: $identificadores
                            > 
                        """.trimIndent()
                    )
                    val nuevaFactura = scanner.nextLine()
                    val error = controlFactura(nuevaFactura)
                    if (error != 0) {
                        throw IllegalArgumentException(error.toString())
                    }
                    val (identificador, importe) = nuevaFactura.split(":").map { it.trim() }
                    if (contabilidad.containsKey(identificador.toInt())) {
                        println("\nIdentificador existente. Facturación invalidada")
                    } else {
                        contabilidad[identificador.toInt()] = importe.toDouble()
                        val pendiente = deudaClientes(contabilidad)
                        println("\n$dineroCobrado importe ya cobrado. $pendiente por cobrar")
                    }
                }
                2 -> {
                    val identificadores =
                        if (contabilidad.isEmpty()) "" else recogerIdentificadores(contabilidad).toString()
                    print(
                        """
                            Indique qué factura le van a pagar
                            Identificadores existentes: $identificadores
                            > 
                        """.trimIndent()
                    )
                    val facturaQuePagar = scanner.nextLine()
                    val error = controlIdentificador(facturaQuePagar)
                    if (error != 0) {
                        throw IllegalArgumentException(error.toString())
                    }
                    val facturaAPagar = facturaQuePagar.toInt()
                    if (!contabilidad.containsKey(facturaAPagar)) {
                        println("\nFactura inexistente. Cobro invalidado")
                    } else {
                        dineroCobrado += contabilidad[facturaAPagar] ?: 0.0
                        contabilidad.remove(facturaAPagar)
                        val pendiente = deudaClientes(contabilidad)
                        println("\nFactura $facturaAPagar pagada. $dineroCobrado importe ya cobrado. $pendiente por cobrar")
                    }
                }
                0 -> println("\nAdiós, vuelva pronto")
                else -> println("\nOpción no reconocida")
            }

        } catch (e: IllegalArgumentException) {
            when (e.message?.toInt()) {
                1 -> println("\nFormato de factura incorrecto. Ejemplos válidos: [66: 40.75] ó [007051: 178.33]")
                2 -> println("\nNo dígito encontrado en intento de nueva factura.")
                3 -> println("\nEl identificador en el nuevo intento de factura no puede empezar por 0.")
                4 -> println("\nImporte mal introducido en intento de nueva factura.")
                5 -> println("\nIntroduzca al menos un identificador.")
                6 -> println("\nNo dígito encontrado en la factura a pagar.")
            }
        } catch (e: Exception) {
            println("\nError inesperado: ${e.message}")
        }
    }
}
