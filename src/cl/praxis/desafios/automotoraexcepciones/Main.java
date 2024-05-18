package cl.praxis.desafios.automotoraexcepciones;

import java.io.File;
import java.util.Scanner;

public class Main {
    private final static String PATH = "src/cl/praxis/desafios/automotoraexcepciones/ficheros/";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibroVenta libro = new LibroVenta();
        Cliente cliente = new Cliente();
        Vehiculo vehiculo = new Vehiculo();
        boolean state;

        do {
            System.out.println("Ingresa el nombre de la venta realizada para guardar la informacion: ");
            libro.setNombreVenta(sc.nextLine());
            state = manageExistingFile(libro.getNombreVenta());
        }while(state);

        System.out.println("Ingresa la fecha de la venta: ");
        libro.setFechaVenta(sc.nextLine());
        System.out.println("Ingresa el nombre del cliente: ");
        cliente.setNombre(sc.nextLine());
        System.out.println("Ingresa la edad del cliente: ");
        cliente.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingresa la patente del vehiculo: ");
        vehiculo.setPatente(sc.nextLine());
        System.out.println("Ingresa el color del vehiculo: ");
        vehiculo.setColor(sc.nextLine());

        libro.guardarVenta(cliente, vehiculo);
    }

    private static boolean manageExistingFile(String name) {
        boolean state = true;
        Scanner sc = new Scanner(System.in);
        String fullPath = PATH.concat(name).concat(".txt");
        File file = new File(fullPath);
        if (!file.exists()) {
            state = false;
        } else if (file.exists()){
            System.out.println("Fichero existente, desea sobreescribirlo? (s/n)");
            String answer = sc.nextLine();
            if (answer.equals("s")) {
                state = false;
            }
        }
        return state;
    }
}
