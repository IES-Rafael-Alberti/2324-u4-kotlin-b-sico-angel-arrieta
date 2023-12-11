fun main() {
    print("Dime tu correo electrónico: ")
    val correo = readln()
    val correoDividido = correo.split("@")
    if ("@" in correo){
        val correoNuevo = correoDividido[0] + "@ceu.es"
        println(correoNuevo)
    } else {
        println("El correo introducido no es válido")
    }
}