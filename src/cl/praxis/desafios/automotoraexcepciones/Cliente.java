package cl.praxis.desafios.automotoraexcepciones;

public class Cliente extends Persona {

    private String correoElectronico;

    public Cliente() {

    }

    public Cliente(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Cliente(String nombre, int rut, int edad, String correoElectronico) {
        super(nombre, rut, edad);
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
