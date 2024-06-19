package cl.praxis.desafios.indianajeans;

import java.util.ArrayList;

public class ProductoServicio {

    private static ProductoServicio productoServicio;
    private static ArrayList<Producto> listaProductos;

    private ProductoServicio() {
        listaProductos = new ArrayList<Producto>();
    }

    public static ProductoServicio getInstance() {
        if (productoServicio == null) {
            productoServicio = new ProductoServicio();
        }
        return productoServicio;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public static void listarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println(producto.toString());
        }
    }

    public void agregarProductos(Producto producto){
        listaProductos.add(producto);
    }


}
