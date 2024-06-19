package cl.praxis.desafios.indianajeans;

import java.io.*;

public class ExportadorTxt extends ExportarTxt {

    private final static String fullPath = "src/cl/praxis/desafios/indianajeans/dir/ProductosExportados.txt";

    @Override
    public void exportar() {
        boolean state = true;
        File file = new File(fullPath);
        ProductoServicio lista = ProductoServicio.getInstance();

        if (!file.getParentFile().exists()) {
            state = file.getParentFile().mkdir();
            System.out.println(state ? "Directorio creado correctamente" : "Error al crear el directorio");
        } else
            System.out.println("Directorio ya se encuentra creado");

        if (state && !file.exists()) {
            try {
                state = file.createNewFile();
                System.out.println(state ? "Fichero creado correctamente" : "Error al crear el fichero");
                if (state){
                    try {
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Producto producto : lista.getListaProductos()) {
                            bw.write(producto.getArticulo() + "," + producto.getPrecio() + "," + producto.getDescripcion() + "," + producto.getCodigo() + "," + producto.getTalla() + "," + producto.getMarca() + "," + producto.getColor());
                            bw.newLine();
                        }
                        bw.close();
                        System.out.println("Datos registrados correctamente");
                    } catch (IOException e) {
                        System.out.println("Ocurrió un error de I/O");
                    }
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error de I/O");
            }
        } else if (file.exists())
            System.out.println("Fichero existente");
    }
}
