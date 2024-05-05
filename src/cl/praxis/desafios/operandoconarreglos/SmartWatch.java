package cl.praxis.desafios.operandoconarreglos;

import java.util.ArrayList;

public class SmartWatch {

    public static void main(String[] args) {
        if (args.length > 0) {
            clearSteps(args);
        }
    }

    private static void clearSteps(String[] valores) {

        ArrayList<Integer> cleanArray = new ArrayList<>();
        int aux, promedio;
        int minimo = 200;
        int maximo = 100000;

        for (String valor : valores) {
            aux = Integer.parseInt(valor);

            if (aux >= minimo && aux <= maximo) {
                cleanArray.add(aux);
            }
        }
        promedio = cleanArray.stream().reduce(0, Integer::sum) / cleanArray.size();
        System.out.println("El promedio de pasos es: " + promedio);
    }
}