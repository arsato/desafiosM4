package cl.praxis.desafios.whilepordowhile;

import java.util.Scanner;

public class SumaImparLimite {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;

        System.out.println("Ingresa el limite inferior: ");
        int min = sc.nextInt();
        System.out.println("Ingresa el limite superior: ");
        int max = sc.nextInt();

        do{
            if(min % 2 != 0){
                counter = counter + min;
            }
            min++;
        }while(min < max);
        System.out.println("La suma es: " + counter);
    }
}

