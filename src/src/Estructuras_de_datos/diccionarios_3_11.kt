package Estructuras_de_datos

fun main() {
    fun dividir(cadenaBruta: String): Pair<String, List<String>> {
        val listado = cadenaBruta.split("\n")
        val cabecera = listado[0]
        val listado2 = listado.drop(1)
        return cabecera to listado2
    }
    fun personas(listado: List<String>): List<List<String>> {
        val informacion = mutableListOf<List<String>>()
        for (linea in listado) {
            val datos = linea.split(";")
            informacion.add(datos)
        }
        return informacion
    }
    fun diccionario(asociacion: List<String>, infoPersonas: List<List<String>>): Map<String, Map<String, String>> {
        val diccionario = mutableMapOf<String, Map<String, String>>()
        for (persona in infoPersonas) {
            val individuo = mutableMapOf<String, String>()
            var nif = ""
            for ((index, valor) in persona.withIndex()) {
                if (index == 0) {
                    nif = valor
                } else {
                    val clave = asociacion[index]
                    individuo.put(clave, valor)
                }
            }
            diccionario.put(nif, individuo)
        }
        return diccionario
    }

    val directorio = "nif;nombre;email;teléfono;descuento\n"+
    "01234567L;Luis González;luisgonzalez@mail.com;656343576;12.5\n"+
    "71476342J;Macarena Ramírez;macarena@mail.com;692839321;8\n"+
    "63823376M;Juan José Martínez;juanjo@mail.com;664888233;5.2\n"+
    "98376547F;Carmen Sánchez;carmen@mail.com;667677855;15.7"

    val (referencia, directorioDividido) = dividir(directorio)
    val claves = referencia.split(";")
    val datosPersonas = personas(directorioDividido)
    val clientes = diccionario(claves, datosPersonas)

    println(clientes)
}
