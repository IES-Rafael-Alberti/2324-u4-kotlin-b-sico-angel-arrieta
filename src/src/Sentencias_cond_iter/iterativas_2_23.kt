package Sentencias_cond_iter

fun main() {
    fun cuentaDigitos(linea: List<String>): Int {
        var digitos = 0
        for (titulo in linea) {
            for (numero in '0'..'9') {
                digitos += titulo.count { it == numero }
            }
        }
        return digitos
    }
    fun cuentaLineas(libro: List<List<String>>): Int {
        return libro.size
    }
    val registro = mutableListOf<List<String>>()
    val linea = mutableListOf<String>()
    var nuevoTitulo = ""

    while (nuevoTitulo != "*") {
        println("Dime títulos de libros (Introduce / para terminar la línea")
        println(" ó * para terminar el programa):")
        nuevoTitulo = readLine() ?: ""
        when (nuevoTitulo) {
            "/" -> {
                registro.add(linea.toList())
                val digitos = cuentaDigitos(linea)
                println("Línea completa. Aparecen $digitos dígitos numéricos.")
                linea.clear()
            }
            "*" -> {
                val cantidadLineas = cuentaLineas(registro)
                println("Fin. Se leyeron $cantidadLineas líneas completas.")
            }
            "" -> {
                continue
            }
            else -> linea.add(nuevoTitulo)
        }
    }
}
