package Estructuras_de_datos

fun main() {
    fun dividirTraducciones(diccion: String): List<String> {
        val listaBruta = mutableListOf<String>()
        val dividido = diccion.split(",")
        for (referencia in dividido) {
            listaBruta.add(referencia.trim()) }
        return listaBruta
    }
    fun adecuarDiccionario(listado: List<String>): Map<String, String> {
        val diccionarioAdecuado = mutableMapOf<String, String>()
        for (referencia in listado) {
            val (espanol, ingles) = referencia.split(":")
            diccionarioAdecuado[espanol.lowercase().trim()] = ingles.trim() }
        return diccionarioAdecuado
    }
    fun adecuarFrase(fraseBruta: String): List<String> {
        val frase = mutableListOf<String>()
        val fraseDividida = fraseBruta.split(" ")
        for (palabra in fraseDividida) {
            frase.add(palabra.lowercase()) }
        return frase
    }
    fun traducir(frase: List<String>, diccionario: Map<String, String>): String {
        val traducir = mutableListOf<String>()
        for (palabraEspanola in frase) {
            val anadir = diccionario[palabraEspanola] ?: palabraEspanola
            traducir.add(anadir) }
        return traducir.joinToString(" ")
    }
    fun controlDivision(listado: List<String>): Int {
        for (referencia in listado) {
            if (":" !in referencia) {
                return 1
            } else if (referencia.count { it == ':' } > 1)
            { return 2 } }
        return 0
    }
    fun repeticion(listado: List<String>): Int {
        val espanol = listado.map { it.split(":")[0].trim() }
        for (palabra in espanol) {
            if (espanol.count { it == palabra } > 1)
            { return 3 } }
        return 0
    }
    fun controlDict(traducciones: Map<String, String>): Any {
        val espanol = traducciones.keys.toList()
        val ingles = traducciones.values.toList()
        for (clave in espanol) {
            if (clave.isEmpty()) {
                return 4
            } else if (clave.matches(Regex("[^A-Za-zÁáÉéÍíÓóÚúÑñÜü]")) )
            { return clave } }

        for (valor in ingles) {
            if (valor.isEmpty()) {
                return 4
            } else if (valor.matches(Regex("[^A-Za-z']")))
            { return valor } }

        return 0 }
    fun controlFrase(frase: List<String>): Int {
        for (palabra in frase) {
            if (palabra.matches(Regex("[^A-Za-zÁáÉéÍíÓóÚúÑñÜü]")))
            { return 5 } }
        return 0
    }; var error: Any = 0
    try {
        println("Introduce tu diccionario español-ingles. Sigue el siguiente formato:")
        print("[palabra-en-español: palabra-en-ingles, español: ingles, español: ingles, ...]\n> ")
        val diccionarioBruto = readLine() ?: ""

        val diccionarioDividido = dividirTraducciones(diccionarioBruto)
        error = controlDivision(diccionarioDividido)
        if (error != 0) {
            throw IllegalArgumentException(error.toString())
        }
        error = repeticion(diccionarioDividido) //hora: time, es: it's, de: to, jugar: play
        if (error != 0) {
            throw IllegalArgumentException(error.toString())
        }
        val diccionarioAdecuado = adecuarDiccionario(diccionarioDividido)
        error = controlDict(diccionarioAdecuado)
        if (error != 0) {
            throw IllegalArgumentException(error.toString())
        }
        print("Dime una frase en español para traducir al inglés\n" +
                "(Use solo espacios para dividir las palabras)\n> ")
        val fraseEnEspanol = readLine() ?: ""
        val fraseAdaptada = adecuarFrase(fraseEnEspanol)
        error = controlFrase(fraseAdaptada)
        if (error != 0) {
            throw IllegalArgumentException(error.toString())
        }
        val fraseTraducida = traducir(fraseAdaptada, diccionarioAdecuado)

        println("$fraseEnEspanol.\nSegún el diccionario provisto, la traducción es la siguiente:\n$fraseTraducida.")

    } catch (e: IllegalArgumentException) {
        when (error){
            is String -> println("$error contiene carácteres no reconocibles en su idioma.\n" +
                    "(Formato traducción: [español: ingles, ...])")
            1 -> println("Se ha introducido una traducción con error de forma.\n" +
                    "En una referencia no se ha encontrado ningún ':'")
            2 -> println("Se ha introducido una traducción con error de forma.\n" +
                    "En una referencia se ha encontrado mas de ún ':'" +
                    "(Formato solicitado: [palabra-en-español: palabra-en-ingles, español: ingles, español: ingles, ...]")
            3 -> println("Se ha encontrado una traducción repetida." +
                    "Se ha encontrado una referencia en español más de una vez")
            4 -> println("Se ha encontrado una referencia vacía.")
            5 -> println("Se ha encontrado algún carácter ortográficamente irreconocible en la frase\n" +
                    "Carácteres reconocidos: [A-Za-zÁáÉéÍíÓóÚúÑñÜü]")
        }
    }
}
