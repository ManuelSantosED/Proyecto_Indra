fun main() {
    val usuarios = ArrayList<Usuario>() // Lista de usuarios registrados
    val organizadores = ArrayList<Organizador>() // Lista de organizadores registrados
    val eventos = ArrayList<Evento>() // Lista de todos los eventos creados

    var opcion: Int

    do {
        println("\n--- Portal de Gestión de Eventos Sostenibles ---")
        println("1. Registrar Usuario")
        println("2. Registrar Organizador")
        println("3. Crear Evento (Organizador)")
        println("4. Inscribirse a Evento (Usuario)")
        println("5. Cancelar Inscripción (Usuario)")
        println("6. Mostrar Información")
        println("7. Salir")
        print("Selecciona una opción: ")

        opcion = readln().toIntOrNull() ?: 7

        when (opcion) {
            1 -> {
                // Registrar Usuario
                print("Código Usuario (Ej: User-001): ")
                val codUsuario = readln()

                print("Nombre del Usuario: ")
                val nombreUsuario = readln()

                print("Contraseña: ")
                val contrasenaUsuario = readln()

                print("ID Usuario: ")
                val idUsuario = readln().toInt()

                val nuevoUsuario = Usuario(codUsuario, nombreUsuario, contrasenaUsuario, idUsuario)
                usuarios.add(nuevoUsuario)

                println("Usuario $nombreUsuario registrado.")
            }

            2 -> {
                // Registrar Organizador
                print("Código Organizador (Ej: ORG-001): ")
                val codOrganizador = readln()

                print("Nombre del Organizador: ")
                val nombreOrganizador = readln()

                print("Contraseña: ")
                val contrasenaOrganizador = readln()

                print("ID Organizador: ")
                val idOrganizador = readln().toInt()

                val nuevoOrganizador = Organizador(codOrganizador, nombreOrganizador, contrasenaOrganizador, idOrganizador)
                organizadores.add(nuevoOrganizador)

                println("Organizador $nombreOrganizador registrado.")
            }

            3 -> {
                // Crear Evento (Organizador)
                if (organizadores.isEmpty()) {
                    println("No hay organizadores registrados. Registre un organizador primero.")
                } else {
                    print("Código Organizador: ")
                    val codOrganizador = readln()

                    val organizador = organizadores.find { it.codPersona == codOrganizador }

                    if (organizador != null) {
                        print("Código del Evento (Ej: EVT-001): ")
                        val codEvento = readln()

                        print("Nombre del Evento: ")
                        val nombreEvento = readln()

                        print("Fecha Inicio (dd/mm/yyyy): ")
                        val fechaInicio = readln()

                        print("Fecha Fin (dd/mm/yyyy): ")
                        val fechaFin = readln()

                        print("Ubicación (1. PRESENCIAL \n 2. ONLINE): ")
                        val opcionUbicacion = readln().toIntOrNull()
                        val ubicacion = when (opcionUbicacion) {
                            1 -> Ubicacion.PRESENCIAL
                            2 -> Ubicacion.ONLINE
                            else -> {
                                println("Opción de ubicación inválida. Se asignará PRESENCIAL por defecto.")
                                Ubicacion.PRESENCIAL
                            }
                        }

                        val nuevoEvento = organizador.crearEvento(codEvento, nombreEvento, fechaInicio, fechaFin, ubicacion)
                        eventos.add(nuevoEvento)
                    } else {
                        println("No se encontró un organizador con ese código.")
                    }
                }
            }

            4 -> {
                // Inscribirse a Evento (Usuario)
                if (usuarios.isEmpty()) {
                    println("No hay usuarios registrados. Registre un usuario primero.")
                } else if (eventos.isEmpty()) {
                    println("No hay eventos disponibles para inscribirse. Registre un evento primero.")
                } else {
                    print("Código Usuario: ")
                    val codUsuario = readln()

                    val usuario = usuarios.find { it.codPersona == codUsuario }

                    if (usuario != null) {
                        print("Código del Evento: ")
                        val codEvento = readln()

                        val evento = eventos.find { it.codEvento == codEvento }

                        if (evento != null) {
                            usuario.inscribirse(evento)
                        } else {
                            println("No se encontró un evento con ese código.")
                        }
                    } else {
                        println("No se encontró un usuario con ese código.")
                    }
                }
            }

            5 -> {
                // Cancelar Inscripción (Usuario)
                if (usuarios.isEmpty()) {
                    println("No hay usuarios registrados. Registre un usuario primero.")
                } else {
                    print("Código Usuario: ")
                    val codUsuario = readln()

                    val usuario = usuarios.find { it.codPersona == codUsuario }

                    if (usuario != null) {
                        print("Código del Evento: ")
                        val codEvento = readln()

                        val evento = eventos.find { it.codEvento == codEvento }

                        if (evento != null) {
                            usuario.cancelarInscripcion(evento)
                        } else {
                            println("No se encontró un evento con ese código.")
                        }
                    } else {
                        println("No se encontró un usuario con ese código.")
                    }
                }
            }

            6 -> {
                // Mostrar Información
                println("\n--- Información Registrada ---")

                println("Usuarios Registrados:")
                for (u in usuarios) {
                    u.mostrarInformacion()
                    u.mostrarEventosInscritos()
                }

                println("\nOrganizadores Registrados:")
                for (o in organizadores) {
                    o.mostrarInformacion()
                    o.mostrarEventosCreados()
                }

                println("\nEventos Registrados:")
                for (e in eventos) {
                    e.mostrarInformacion()
                }
            }

            7 -> println("¡Gracias por usar el Portal de Gestión de Eventos Sostenibles!")
            else -> println("Opción no válida. Intenta nuevamente.")
        }
    } while (opcion != 7)
}
