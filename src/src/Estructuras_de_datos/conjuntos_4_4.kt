package Estructuras_de_datos

fun operacionesConjuntos(primSet: Set<String>, segSet: Set<String>): List<Set<String>> {
    val interseccion = primSet intersect segSet
    val soloPrim = primSet subtract segSet
    val soloSeg = segSet subtract primSet
    return listOf(interseccion, soloPrim, soloSeg)
}

fun main() {

    val frutas1 = listOf("manzana", "pera", "naranja", "plátano", "uva")
    val frutas2 = listOf("manzana", "pera", "durazno", "sandía", "uva")

    val setFrutas1 = frutas1.toSet()
    val setFrutas2 = frutas2.toSet()
    val (frutasComunes, frutasSoloEnFrutas1, frutasSoloEnFrutas2) = operacionesConjuntos(setFrutas1, setFrutas2)

    println("Las frutas que se encuentran en ambos conjuntos son $frutasComunes")
    println("Las frutas que solo se encuentran en el primer conjunto $frutasSoloEnFrutas1")
    println("Las frutas que solo se encuentran en el segundo conjunto $frutasSoloEnFrutas2")
}
