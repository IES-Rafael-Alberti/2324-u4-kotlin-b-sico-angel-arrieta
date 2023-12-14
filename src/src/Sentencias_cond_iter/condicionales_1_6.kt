package Sentencias_cond_iter

fun main() {
    fun division(sexo: String, nombre: String): String{
        val mujer = listOf("a", "b", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m")
        val hombre = listOf("a", "b", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n")
        val regex = """[^A-Za-z]""".toRegex()
        val noApto = regex.containsMatchIn(nombre)
        if (noApto){
            val resultado = "El nombre contiene caracteres no alfabeticos"
            return resultado
        }
        val inicial = (nombre.lowercase()[0]).toString()
        if (sexo.lowercase() == "hombre"){
            val esta = hombre.indexOf(inicial)
            if (esta >= 0){
                val resultado = "Estas en el grupo B"
                return resultado
            } else {
                val resultado = "Estas en el grupo A"
                return resultado }
        } else if (sexo.lowercase() == "mujer"){
            val esta = mujer.indexOf(inicial)
            if (esta >= 0){
                val resultado = "Estas en el grupo A"
                return resultado
            } else {
                val resultado = "Estas en el grupo B"
                return resultado }
        } else {
            val resultado = "Datos introducidos incorrectamente"
            return resultado
        }
    }
    print("¿Eres hombre o mujer?: ")
    val sexo = readln()
    print("Escribe tu nombre: ")
    val nombre = readln()
    val grupo = division(sexo, nombre)
    println(grupo)
}