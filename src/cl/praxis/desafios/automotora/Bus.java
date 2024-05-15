package cl.praxis.desafios.automotora;

public class Bus extends Vehiculo {

    private int cantidadDeAsientos;

    public Bus() {

    }

    public Bus(int cantidadDeAsientos) {
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public Bus(String color, String patente, int cantidadDeAsientos) {
        super(color, patente);
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public int getCantidadDeAsientos() {
        return cantidadDeAsientos;
    }

    public void setCantidadDeAsientos(int cantidadDeAsientos) {
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public int asientosDisponibles(){
        return this.cantidadDeAsientos;
    }
}
