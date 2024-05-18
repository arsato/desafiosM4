package cl.praxis.desafios.automotoraexcepciones;

import java.io.*;

public class LibroVenta {

    private final static String PATH = "src/cl/praxis/desafios/automotoraexcepciones/ficheros/";
    private String nombreVenta;
    private String fechaVenta;

    public LibroVenta(String nombreVenta, String fechaVenta) {
        this.nombreVenta = nombreVenta;
        this.fechaVenta = fechaVenta;
    }

    public LibroVenta() {

    }

    public String getNombreVenta() {
        return nombreVenta;
    }

    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void guardarVenta(Cliente cliente, Vehiculo vehiculo){
        String fullPath = PATH.concat(nombreVenta).concat(".txt");
        boolean state;
        File file = new File(fullPath);
        try {
            System.out.println("Creando fichero");
            state = file.createNewFile();
            if (state) {
                System.out.println("Se ha creado el fichero");
                try {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("patente,edad,fechaVenta,nombreVenta");
                    bw.newLine();
                    String row = vehiculo.getPatente() + "," + cliente.getEdad() + "," + this.fechaVenta + "," + this.nombreVenta;
                    bw.write(row);
                    bw.close();
                    System.out.println("Datos registrados correctamente");
                } catch (IOException e) {
                    System.out.println("Ocurrió un error de I/O: " + e.getMessage());
                }
            }
            else{
                throw new MyException("Oops! Algo salió mal, al parecer el nombre del fichero ya existe");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error de I/O: " + e.getMessage());
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }
}
