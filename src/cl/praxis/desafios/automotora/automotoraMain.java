package cl.praxis.desafios.automotora;

public class automotoraMain {

    public static void main(String[] args) {

        Tienda tienda1 = new Tienda();
        int stock = 10;
        Vendedor vendedor1 = new Vendedor("Vendedor1", 1, 20, "Calle 1");
        MiniBus miniBus1 = new MiniBus("Rojo", "AAA111", 50, "Negocios");
        Bus bus1 = new Bus("Verde", "BBB222", 100);
        Taxi taxi1 = new Taxi("Negro", "CCC333", 10);

        tienda1.setVehiculo(miniBus1);
        tienda1.setVendedor(vendedor1);
        tienda1.setStock(stock);

        tienda1.existeStock();

        System.out.println("Asientos disponibles: " + bus1.asientosDisponibles());

        taxi1.pagarPasaje(5);
        taxi1.pagarPasaje(11);

        miniBus1.imprimeBus();

    }
}
