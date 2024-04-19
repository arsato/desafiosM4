package cl.praxis.desafios.whilepordowhile;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        int i = 0, j = 1, k = 0, n, aux;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un numero: ");
        n = sc.nextInt();

        do {
            if(i < 2){
                System.out.println(i);
            }else{
                aux = j;
                j = j + k;
                System.out.println(j);
                k = aux;
            }
            i++;
        } while (i <= n);
    }
}
