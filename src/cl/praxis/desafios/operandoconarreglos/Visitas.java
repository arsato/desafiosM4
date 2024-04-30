package cl.praxis.desafios.operandoconarreglos;

public class Visitas {

    public static void main(String[] args) {
        if (args.length > 0)
            promedio(args);
    }

    private static void promedio(String[] visitas) {
        int suma = 0, promedio;

        for (String visita: visitas){
            suma += Integer.parseInt(visita);
        }

        promedio = suma/visitas.length;

        System.out.println("Para la entrada anterior, el resultado es: " + promedio);
    }
}
