class Usuario : Persona {
    var idUsuario: Int = 0 // ID único para la tabla Usuario
    var listaInscripciones = ArrayList<Evento>() // Lista de eventos a los que está inscrito

    // Constructor secundario
    constructor(codPersona: String, nombre: String, contrasena: String, idUsuario: Int) : super(codPersona, nombre, contrasena) {
        this.idUsuario = idUsuario
    }

    // Método para inscribirse a un evento
    fun inscribirse(evento: Evento) {
        var yaInscrito = false
        var i = 0

        // Verificar si ya está inscrito en el evento
        while (i < listaInscripciones.size) {
            if (listaInscripciones[i].codEvento == evento.codEvento) {
                yaInscrito = true
            }
            i++
        }

        if (!yaInscrito) {
            listaInscripciones.add(evento)
            evento.registrarInscripcion(this)
            println("Usuario $nombre inscrito al evento: ${evento.nombre}")
        } else {
            println("Usuario $nombre ya está inscrito en el evento: ${evento.nombre}")
        }
    }

    // Método para cancelar inscripción
    fun cancelarInscripcion(evento: Evento) {
        var encontrado = false
        var i = 0

        while (i < listaInscripciones.size) {
            if (listaInscripciones[i].codEvento == evento.codEvento) {
                listaInscripciones.removeAt(i)
                evento.cancelarInscripcion(this)
                encontrado = true
                println("Usuario $nombre canceló la inscripción al evento: ${evento.nombre}")
                break
            }
            i++
        }

        if (!encontrado) {
            println("Usuario $nombre no está inscrito en el evento: ${evento.nombre}")
        }
    }

    // Mostrar inscripciones
    fun mostrarEventosInscritos() {
        println("Eventos inscritos para el usuario $nombre:")
        if (listaInscripciones.isEmpty()) {
            println("No hay eventos registrados.")
        } else {
            for (i in 0 until listaInscripciones.size) {
                println("- ${listaInscripciones[i].nombre}")
            }
        }
    }
}

