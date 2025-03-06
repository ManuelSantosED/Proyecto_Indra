class Evento {
    var codEvento: String = ""
    var nombre: String = ""
    var fechaInicio: String = ""
    var fechaFin: String = ""
    var idOrganizador: Int = 0
    var ubicacion: Ubicacion = Ubicacion.PRESENCIAL
    var listaInscritos = ArrayList<Usuario>()

    // Constructor secundario
    constructor(codEvento: String, nombre: String, fechaInicio: String, fechaFin: String, idOrganizador: Int) {
        if (fechaInicio >= fechaFin) {
            throw IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin.")
        }

        this.codEvento = codEvento
        this.nombre = nombre
        this.fechaInicio = fechaInicio
        this.fechaFin = fechaFin
        this.ubicacion = ubicacion
        this.idOrganizador = idOrganizador
    }

    // Método auxiliar para verificar si un usuario ya está inscrito
    fun estaInscrito(usuario: Usuario): Boolean {
        for (u in listaInscritos) {
            if (u.codPersona == usuario.codPersona) {
                return true
            }
        }
        return false
    }

    // Método para registrar un usuario en el evento
    fun registrarInscripcion(usuario: Usuario) {
        if (estaInscrito(usuario)) {
            println("Usuario ${usuario.nombre} ya está inscrito en el evento $nombre.")
        } else {
            listaInscritos.add(usuario)
            println("Usuario ${usuario.nombre} se ha inscrito al evento $nombre.")
        }
    }

    // Método para cancelar la inscripción de un usuario
    fun cancelarInscripcion(usuario: Usuario) {
        var encontrado = false
        var i = 0

        // Buscar al usuario en la lista de inscritos
        while (i < listaInscritos.size) {
            if (listaInscritos[i].codPersona == usuario.codPersona) {
                listaInscritos.removeAt(i) // Eliminar usuario de la lista
                encontrado = true
                println("Usuario ${usuario.nombre} ha cancelado su inscripción al evento $nombre.")
            }
            i++
        }

        if (!encontrado) {
            println("Usuario ${usuario.nombre} no estaba inscrito en el evento $nombre.")
        }
    }

    // Método para mostrar la información del evento
    fun mostrarInformacion() {
        println("Evento: $nombre")
        println("Código: $codEvento")
        println("Fecha Inicio: $fechaInicio")
        println("Fecha Fin: $fechaFin")
        println("Organizador (ID): $idOrganizador")
        println("Inscritos:")

        if (listaInscritos.isEmpty()) {
            println("No hay usuarios inscritos en este evento.")
        } else {
            var i = 0
            while (i < listaInscritos.size) {
                println("- ${listaInscritos[i].nombre}")
                i++
            }
        }
    }
}
