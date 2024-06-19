package cl.praxis.desafios.indianajeans;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void navigationMenu(){
        String op = Menu.mainMenu();
        do {
            if (op.equals("1")) {
                Menu.listMenu();
                Menu.enterToContinue();
            } else if (op.equals("2")) {
                Menu.addMenu();
                Menu.enterToContinue();
            } else if (op.equals("3")) {
                System.out.println("Exportar datos");
                ExportadorTxt export = new ExportadorTxt();
                export.exportar();
                Menu.enterToContinue();
            }else{
                System.out.println("Opcion no valida");
                Menu.enterToContinue();
            }
            op = Menu.mainMenu();
        } while (!op.equals("4"));
    }

    public static String mainMenu(){
        Utils.clearScreenFalse();
        System.out.println("--------------");
        System.out.println("Menu Principal");
        System.out.println("--------------");
        System.out.println();
        System.out.println("1. Listar Producto");
        System.out.println("2. Agregar Producto");
        System.out.println("3. Exportar Datos");
        System.out.println("4. Salir");
        System.out.println();
        System.out.println("Ingresa una opción: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void listMenu(){
        ProductoServicio productoServicio = ProductoServicio.getInstance();
        ArrayList<Producto> lista = productoServicio.getListaProductos();
        if (!lista.isEmpty()) {
            ProductoServicio.listarProductos();
        } else {
            System.out.println("Lista vacia, favor importar datos");
        }
    }

    private static void addMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Crear Producto");
        System.out.println("Ingresar nombre articulo: ");
        String nombre  = sc.nextLine();
        System.out.println("Ingresar precio: ");
        String precio  = sc.nextLine();
        System.out.println("Ingresar descripción: ");
        String descripcion  = sc.nextLine();
        System.out.println("Ingresar código: ");
        String codigo  = sc.nextLine();
        System.out.println("Ingresar talla: ");
        String talla  = sc.nextLine();
        System.out.println("Ingresar marca: ");
        String marca  = sc.nextLine();
        System.out.println("Ingresar color: ");
        String color  = sc.nextLine();
        Producto producto = new Producto(nombre, precio, descripcion, codigo, talla, marca, color);
        ProductoServicio productoServicio = ProductoServicio.getInstance();
        productoServicio.agregarProductos(producto);
    }

    public static void enterToContinue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Presione enter para continuar");
        sc.nextLine();
    }
}
