package cl.praxis.desafios.reciclajeans;

public class Producto {

    public String articulo;
    public String precio;
    public String descripcion;
    public String codigo;
    public String talla;
    public String marca;
    public String color;

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Datos del Producto: \n\n" + "Nombre articulo: " + articulo + "\n" + "Código" + " " + codigo + "\n" + "Marca: " + marca + "\n" + "Color: " + color + "\n" + "Descripcion: " + descripcion + "\n" + "Precio: " + precio + "\n" + "Talla: " + talla + "\n" + "********************************************";
    }
}
