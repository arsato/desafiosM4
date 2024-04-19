package cl.praxis.desafios.whilepordowhile;

import java.util.Scanner;

public class SoloPares2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1, counter = 0;

        System.out.println("Ingresa un numero");
        int n = sc.nextInt();
        do{
            if(i % 2 == 0){
                System.out.println(i);
                counter++;
            }
            i++;
        }while(counter < n);
    }
}
