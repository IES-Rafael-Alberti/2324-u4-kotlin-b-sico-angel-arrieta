fun main() {
    fun fechado (fecha: String): String {
        val barras = fecha.filter {it == '/'}
        if ( barras.count() == 2) {
            val fechaPorPartes = fecha.split("/")
            val regex = """[0-9]+""".toRegex()
            for (parte in fechaPorPartes){
                val apto = regex.matchEntire(parte)
                if (apto == null){
                    val mensaje = "No numerico encontrado"
                    return mensaje  }   }
            val dia = fechaPorPartes[0].toInt()
            val mes = fechaPorPartes[1].toInt()
            val ano = fechaPorPartes[2].toInt()
            if (dia > 31) {
                val mensaje = "Dia fuera de alcance"
                return mensaje
            } else if (dia < 1) {
                val mensaje = "Dia fuera de alcance"
                return mensaje
            } else if (mes > 12){
                val mensaje = "Mes fuera de alcance"
                return mensaje
            } else if (mes < 1){
                val mensaje = "Mes fuera de alcance"
                return mensaje      }
            val listaMeses = listOf("enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre")
            val mesEscrito = listaMeses[mes-1]
            val mensaje = "Usted nacio el $dia de $mesEscrito del año $ano"
            return mensaje      }
        else {
            val mensaje = "Formato de fecha incorrecto"
            return mensaje      }   }
    println("Introduzca su fecha de nacimiento (formato dd/mm/aaaa)")
    val fecha = readln()
    val fechaFormateada = fechado(fecha)
    println(fechaFormateada)
}