package cl.praxis.desafios.automotora;

public class Vendedor extends Persona{

    private String direccion;

    public Vendedor(String direccion) {
        this.direccion = direccion;
    }

    public Vendedor(String nombre, int rut, int edad, String direccion) {
        super(nombre, rut, edad);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
