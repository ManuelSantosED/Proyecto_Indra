open class Persona {
    var codPersona = ""
    var nombre: String = ""
    private var contrasena: String = ""


    constructor(codPersona: String, nombre: String, contrasena: String) {
        this.codPersona = codPersona
        this.nombre = nombre
        this.contrasena = contrasena
    }

    // Método para cambiar la contraseña
    fun cambiarContrasena(nuevaContrasena: String) {
        if (nuevaContrasena.isNotBlank()) {
            contrasena = nuevaContrasena
            println("Contraseña actualizada correctamente para $nombre.")
        } else {
            println("La nueva contraseña no puede estar vacía.")
        }
    }

    // Método para mostrar información básica
    open fun mostrarInformacion() {
        println("ID: $codPersona, Nombre: $nombre")
    }
}
