class Organizador : Persona {
    var idOrganizador: Int = 0 // ID único para la tabla Organizador
    var eventosCreados = ArrayList<Evento>() // Lista de eventos creados por el organizador

    // Constructor secundario
    constructor(codPersona: String, nombre: String, contrasena: String, idOrganizador: Int) : super(codPersona, nombre, contrasena) {
        this.idOrganizador = idOrganizador
    }

    // Crear un evento
    fun crearEvento(codEvento: String, nombreEvento: String, fechaInicio: String, fechaFin: String, ubicacion: Ubicacion): Evento {
        val nuevoEvento = Evento(codEvento, nombreEvento, fechaInicio, fechaFin, this.idOrganizador)
        nuevoEvento.ubicacion = ubicacion
        eventosCreados.add(nuevoEvento)
        println("Evento '${nuevoEvento.nombre}' creado exitosamente.")
        return nuevoEvento
    }

    // Modificar un evento existente
    fun modificarEvento(codEvento: String, nuevoNombre: String, nuevaFechaInicio: String, nuevaFechaFin: String, nuevaUbicacion: Ubicacion) {
        var encontrado = false
        var i = 0

        while (i < eventosCreados.size) {
            if (eventosCreados[i].codEvento == codEvento) {
                eventosCreados[i].nombre = nuevoNombre
                eventosCreados[i].fechaInicio = nuevaFechaInicio
                eventosCreados[i].fechaFin = nuevaFechaFin
                eventosCreados[i].ubicacion = nuevaUbicacion
                encontrado = true
                println("Evento con código $codEvento modificado exitosamente.")
            }
            i++
        }

        if (!encontrado) {
            println("No se encontró un evento con el código $codEvento.")
        }
    }

    // Mostrar eventos creados
    fun mostrarEventosCreados() {
        println("Eventos creados por el organizador $nombre:")

        if (eventosCreados.isEmpty()) {
            println("No has creado ningún evento.")
        } else {
            for (i in 0 until eventosCreados.size) {
                println("- ${eventosCreados[i].nombre} (Código: ${eventosCreados[i].codEvento})")
            }
        }
    }
}
