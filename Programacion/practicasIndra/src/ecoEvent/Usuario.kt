package ecoEvent
class Usuario(
    private var nombre: String,
    private var apelllido: String,
    private var correo: String,
    private var contrasena: String,
    private var tlf: Int
) {

    companion object {
        var cont = 1
    }
    private var id: Int = cont++


    // Getters
    fun getId(): Int {
        return id
    }

    fun getNombre(): String {
        return nombre
    }

    fun getApeallido(): String {
        return apelllido
    }



    fun getCorreo(): String {
        return correo
    }

    fun getContrasena(): String {
        return contrasena
    }

    fun getTlf(): Int {
        return tlf
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }





    fun setCorreo(correo: String) {
        this.correo = correo
    }

    fun setContrasena(contrasena: String) {
        this.contrasena = contrasena
    }

    fun setTlf(tlf: Int) {
        this.tlf = tlf
    }


    fun resumen() {
        println("Id: $id")
        println("Nombre: $nombre")
        println("Apellido: $apelllido")
        println("Correo: $correo")
        println("Telefono: $tlf")
    }
}
