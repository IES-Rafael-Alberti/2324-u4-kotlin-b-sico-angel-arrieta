package Estructuras_de_datos

fun main() {
    fun comprobar(nombre: String): Int {
        val pattern = Regex("[^A-Za-z ÁáÉéÍíÓóÚúÑñ]")
        return if (pattern.containsMatchIn(nombre)) 1 else 0
    }
    var error = 0
    val primaria = mutableSetOf<String>()
    val secundaria = mutableSetOf<String>()
    var alumno = ""
    try {
        // Proceso
        while (alumno != "x") {
            print("Introduce los nombres de pila de los alumnos de primaria de la escuela\n" +
                    "(introduce 'x' para acabar y seguir con el programa)\n> ")
            alumno = readLine() ?: ""
            error = comprobar(alumno)
            if (error != 0) throw IllegalArgumentException(error.toString())
            if (alumno == "x" && primaria.isEmpty()) {
                error = 2
                throw IllegalArgumentException(error.toString())
            } else {
                primaria.add(alumno.lowercase().trim())
            }
        }
        alumno = ""
        while (alumno != "x") {
            println("Introduce los nombres de pila de los alumnos de secundaria de la escuela")
            print("(introduce 'x' para terminar los inputs y seguir con el programa)\n> ")
            alumno = readLine() ?: ""
            error = comprobar(alumno)
            if (error != 0) throw IllegalArgumentException(error.toString())
            if (alumno == "x" && secundaria.isEmpty()) {
                error = 3
                throw IllegalArgumentException(error.toString())
            } else {
                secundaria.add(alumno.lowercase().trim())
            }
        }
        val todosLosAlumnos = primaria union secundaria
        val nombresRepetidos = primaria intersect secundaria
        val primariaNoRepetidos = primaria subtract secundaria
        val primariaEnSecundaria = if (secundaria.containsAll(primaria)) "si" else "no"

        // Salida
        println("Alumnos de la escuela: $todosLosAlumnos\n")
        if (nombresRepetidos.isEmpty()) {
            println("No hay nombres repetidos en la escuela\n")
        } else {
            println("Nombres repetidos en la escuela: $nombresRepetidos\n")
        }
        println("Nombres de primaria que no se encuentran en secundaria: $primariaNoRepetidos\n")
        println("Todos los nombres de los alumnos de primaria $primariaEnSecundaria " +
                "se pueden encontrar en los de secundaria")

    } catch (e: IllegalArgumentException) {
        when (error) {
            1 -> println("El nombre introducido tiene caracteres ilógicos")
            2 -> println("No has introducido ningún alumno de primaria")
            3 -> println("No has introducido ningún alumno de secundaria")
        }
    }
}
