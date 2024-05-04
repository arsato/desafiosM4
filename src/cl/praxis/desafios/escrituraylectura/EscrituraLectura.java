package cl.praxis.desafios.escrituraylectura;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EscrituraLectura {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del directorio");
        String dirName = sc.nextLine();

        System.out.println("Ingresa el nombre del fichero");
        String fileName = sc.nextLine();

        File newFile = crearArchivo(dirName, fileName);

        if (newFile.exists()) {
            escribirFichero(newFile);
            System.out.println("Ingresa el nombre del fichero a buscar");
            String fichero = sc.nextLine();
            fichero = dirName.concat("/").concat(fichero);
            System.out.println("Ingresa el texto a buscar");
            String texto = sc.nextLine();
            buscarTexto(fichero, texto);
        }
    }

    private static File validarArchivo(String pathName, String type) {
        String dirOrFile = pathName.contains(".txt") ? "Fichero" : "Directorio";
        File path = new File(pathName);
        boolean state;
        if (type.equals("read")) {
            if (!path.exists()) {
                System.out.println("El fichero ingresado no existe");
            } else {
                System.out.println("Fichero existente");
            }
        } else {
            if (!path.exists()) {
                try {
                    state = pathName.contains(".txt") ? path.createNewFile() : path.mkdir();
                    System.out.printf("%s creado%n", dirOrFile);
                    if (!state) {
                        System.out.printf("%s no creado%n", dirOrFile);
                    }
                } catch (IOException e) {
                    System.out.println("IO EXCEPTION");
                }
            } else {
                System.out.printf("%s ya existe%n", dirOrFile);
            }
        }
        return path;
    }

    private static File crearArchivo(String directorio, String fichero) {
        String path = "src/cl/praxis/desafios/escrituraylectura/";
        fichero = fichero.concat(".txt");
        directorio = path.concat(directorio + "/");
        validarArchivo(directorio, "create");
        return validarArchivo(directorio.concat(fichero), "create");
    }

    private static void escribirFichero(File file) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");

        try {
            FileWriter fileW = new FileWriter(file);
            BufferedWriter bufferedW = new BufferedWriter(fileW);
            for (String i : lista) {
                bufferedW.write(i);
                bufferedW.newLine();
            }
            bufferedW.close();
            System.out.println("Fichero escrito correctamente");
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
    }

    private static void buscarTexto(String nombreFichero, String texto) {
        String path = "src/cl/praxis/desafios/escrituraylectura/";
        nombreFichero = path.concat(nombreFichero).concat(".txt");
        ArrayList<String> lista = new ArrayList<>();
        if (validarArchivo(nombreFichero, "read").exists()) {
            try {
                FileReader fr = new FileReader(nombreFichero);
                BufferedReader br = new BufferedReader(fr);
                br.lines().filter(s -> s.equals(texto)).forEach(lista::add);
                System.out.println("Cantidad de coincidencias del texto (" + texto + "): " + lista.size());
                br.close();
            } catch (IOException e) {
                System.out.println("IO EXCEPTION");
            }
        }
    }
}
