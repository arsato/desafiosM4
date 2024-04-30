package cl.praxis.desafios.operandoconarreglos;

import java.util.ArrayList;

public class MultiplosDeTres {
    public static void main(String[] args) {
        if (args.length > 0) {
            suma(args);
        }
    }

    public static void suma(String[] numeros) {

        ArrayList<Integer> cleanArray = new ArrayList<>();
        int aux, suma;


        for (String numero : numeros) {
            aux = Integer.parseInt(numero);

            if (aux % 3 == 0) {
                cleanArray.add(aux);
            }
        }

        suma = cleanArray.stream().reduce(0, Integer::sum);
        System.out.println(suma);

        promedio(cleanArray);
    }

    public static void promedio(ArrayList<Integer> numeros) {
        int promedio = numeros.stream().reduce(0, Integer::sum) / numeros.size();
        System.out.println(promedio);
    }
}