package Estructuras_de_datos

fun main() {
    fun explicacionEjercicio(palabra: String): String {
        val explicacion = """
        Teniendo la palabra '$palabra' asigando a 'val pieza', sabemos que es una cadena. 
        El significado de 'pieza.substring(0)' es lo mismo que 'val pieza',
        lo obviamente diferente '.substring(0)' es para aplicar la operación
        subcadena, por la cual se extraen elementos a las cadenas de texto
    """.trimMargin()

        return explicacion
    }
    val explicado = explicacionEjercicio("fruta")
    println(explicado)
}
