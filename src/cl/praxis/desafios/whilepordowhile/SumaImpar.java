package cl.praxis.desafios.whilepordowhile;

import java.util.Scanner;

public class SumaImpar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, counter = 0;

        System.out.println("Ingresa un numero: ");
        int n = sc.nextInt();
        do{
            if(i % 2 != 0){
                counter = counter + i;
            }
            i++;
        }while(i < n);
        System.out.println("La suma es: " + counter);
    }
}

