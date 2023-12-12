fun main() {
    fun contrasena(usuario: String): Boolean {
        return usuario == "contrasena"
    }
    var contrasenaValida = false

    while (!contrasenaValida) {
        try {
            println("Introduce la contraseña:")
            val usuarioIntroduce = readLine() ?: ""

            contrasenaValida = contrasena(usuarioIntroduce)

            if (!contrasenaValida) {
                throw IllegalArgumentException("Incorrect Password!!")
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
