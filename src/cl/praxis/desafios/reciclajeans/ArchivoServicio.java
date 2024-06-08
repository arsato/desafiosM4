package cl.praxis.desafios.reciclajeans;

import java.io.*;
import java.util.ArrayList;

public class ArchivoServicio {

    private final static String PATH = "src/cl/praxis/desafios/reciclajeans";
    private final static String fileName = "/ProductosImportados.csv";

    public static void showData(ArrayList<Producto> lista) {
        ProductoServicio productoServicio = new ProductoServicio();
        productoServicio.setListaProductos(lista);
        productoServicio.listarProductos();
    }

    public static ArrayList<Producto> cargarDatos(String filePath){
        ArrayList<Producto> lista = new ArrayList<>();
        File file = new File(PATH.concat(filePath).concat(fileName));
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    Producto producto = new Producto();
                    String[] data = line.split(",");
                    producto.setArticulo(data[0]);
                    producto.setPrecio(data[1]);
                    producto.setDescripcion(data[2]);
                    producto.setCodigo(data[3]);
                    producto.setTalla(data[4]);
                    producto.setMarca(data[5]);
                    producto.setColor(data[6]);
                    lista.add(producto);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }else{
            System.out.println("El archivo no existe");
        }
        System.out.println("Datos cargados correctamente en la lista");
        return lista;
    }

    public static void saveData(ArrayList<Producto> lista, String filePath) {
        File file = new File(PATH.concat(filePath).concat(fileName));
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Producto producto : lista) {
                bw.write(producto.getArticulo() + "," + producto.getPrecio() + "," + producto.getDescripcion() + "," + producto.getCodigo() + "," + producto.getTalla() + "," + producto.getMarca() + "," + producto.getColor());
                bw.newLine();
            }
            bw.close();
            System.out.println("Datos registrados correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error de I/O");
        }
    }
}
