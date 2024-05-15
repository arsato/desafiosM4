package cl.praxis.desafios.automotora;

public class Taxi extends Vehiculo {

    private int valorPasaje;

    public Taxi(String color, String patente, int valorPasaje) {
        super(color, patente);
        this.valorPasaje = valorPasaje;
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    public void setValorPasaje(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }

    public void pagarPasaje(int montoPagar) {
        if (montoPagar >= this.valorPasaje) {
            System.out.println("Su vuelto es: " + (montoPagar - this.valorPasaje));
        } else {
            System.out.println("No alcanza, el valor del pasaje es: " + this.valorPasaje);
        }
    }
}
