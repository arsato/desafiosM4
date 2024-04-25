package cl.praxis.desafios.patrones;

import java.util.Scanner;

public class Patrones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un numero: ");
        int n = sc.nextInt();

        System.out.println("Patron 1: ");
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                System.out.print("*");
            } else {
                System.out.print(".");
            }
        }

        System.out.println("\nPatron 2: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i % 4 + 1);
        }

        System.out.println("\nPatron 3: ");
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0){
                System.out.print("*");
            }else{
                System.out.print("|");
            }

        }
    }
}
