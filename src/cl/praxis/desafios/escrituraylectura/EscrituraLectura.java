package cl.praxis.desafios.escrituraylectura;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EscrituraLectura {

    private final static String PATH = "src/cl/praxis/desafios/escrituraylectura/";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del directorio");
        String dirName = sc.nextLine();
        System.out.println("Ingresa el nombre del fichero");
        String fileName = sc.nextLine();

        crearArchivo(dirName, fileName);

        System.out.println("Ingresa el nombre del fichero a buscar");
        String fichero = sc.nextLine();
        fichero = PATH.concat(dirName).concat("/").concat(fichero).concat(".txt");
        System.out.println("Ingresa el texto a buscar");
        String texto = sc.nextLine();
        buscarTexto(fichero, texto);
    }

    private static void crearArchivo(String directorio, String fichero) {
        String fullPath = PATH.concat(directorio).concat("/").concat(fichero).concat(".txt");
        boolean dirstate = true, state;

        File path = new File(fullPath);

        if(!path.getParentFile().exists()) {
            System.out.println("Directorio no existente");
            state = path.getParentFile().mkdir();
            if(state){
                System.out.println("Directorio creado");
            }else{
                System.out.println("Error al crear el directorio");
            }
            dirstate = state;
        }else
            System.out.println("Directorio existente");

        if (dirstate && !path.exists()) {
            try {
                state = path.createNewFile();
                if(state){
                    System.out.println("Fichero creado");
                    escribirFichero(path);
                }else
                    System.out.println("Error al crear el fichero");
            } catch (IOException e) {
                System.out.println("Ocurrió un error de I/O");
            }
        }else{
            System.out.println("Fichero existente");
        }
    }

    private static void escribirFichero(File file) {
        ArrayList<String> lista = new ArrayList<>();
        Collections.addAll(lista,"Perro", "Gato", "Juan", "Daniel", "Juan", "Gato", "Perro", "Camila", "Daniel", "Camila");
        try {
            FileWriter fileW = new FileWriter(file);
            BufferedWriter bufferedW = new BufferedWriter(fileW);
            for (String i : lista) {
                bufferedW.write(i);
                bufferedW.newLine();
            }
            bufferedW.close();
            System.out.println("Datos registrados correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error de I/O");
        }
    }

    private static void buscarTexto(String nombreFichero, String texto) {
        ArrayList<String> lista = new ArrayList<>();
        if (new File(nombreFichero).exists()) {
            try {
                FileReader fr = new FileReader(nombreFichero);
                BufferedReader br = new BufferedReader(fr);
                br.lines().filter(s -> s.equals(texto)).forEach(lista::add);
                System.out.println("Cantidad de coincidencias del texto '" + texto + "' -> " + lista.size());
            } catch (IOException e) {
                System.out.println("Ocurrió un error de I/O");
            }
        }else
            System.out.println("El fichero ingresado no existe");
    }
}
