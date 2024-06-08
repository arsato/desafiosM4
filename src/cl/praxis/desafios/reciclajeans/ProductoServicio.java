package cl.praxis.desafios.reciclajeans;

import java.util.ArrayList;

public class ProductoServicio {

    private ArrayList<Producto> listaProductos;

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println(producto.toString());
        }
    }


}
