package cl.praxis.desafios.quienmayor;

import java.util.Scanner;

public class Fechas {

    public static void main(String[] args) {
        int[] result1, result2;

        System.out.println("----------------");
        System.out.println("¿Quién es mayor?");
        System.out.println("----------------");

        System.out.println("Ingresa la fecha numero 1 como DD/MM/AAAA:");
        result1 = evaluateDate();
        System.out.println("Ingresa la fecha numero 2 como DD/MM/AAAA:");
        result2 = evaluateDate();

        if (result1[3] > result2[3]) {
            System.out.println("La persona 2 es mayor");
        } else if (result1[3] == result2[3]) {
            if (result1[2] > result2[2]) {
                System.out.println("La persona 2 es mayor");
            } else if (result1[2] == result2[2]) {
                if (result1[1] > result2[1]) {
                    System.out.println("La persona 2 es mayor");
                } else if (result2[1] > result1[1]) {
                    System.out.println("La persona 1 es mayor");
                } else {
                    System.out.println("Las personas tienen la misma edad");
                }
            } else {
                System.out.println("La persona 1 es mayor");
            }
        } else {
            System.out.println("La persona 1 es mayor");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("La fecha contiene un valor NO numérico");
            return false;
        }
        return true;
    }

    private static boolean evaluateString(String dateStr) {
        String fechaDayStr, fechaMonthStr, fechaYearStr;
        if (dateStr.length() == 10 && dateStr.indexOf("/") == 2 && dateStr.substring(3, 10).indexOf("/") == 2 && dateStr.chars().filter(ch -> ch == '/').count() == 2) {
            fechaDayStr = dateStr.substring(0, 2);
            fechaMonthStr = dateStr.substring(3, 5);
            fechaYearStr = dateStr.substring(6, 10);
            return isNumeric(fechaDayStr) && isNumeric(fechaMonthStr) && isNumeric(fechaYearStr);
        } else {
            System.out.println("La fecha tiene un formato incorrecto, debe ser DD/MM/AAAA");
            return false;
        }
    }

    private static int[] evaluateDate() {
        int[] result = new int[4];
        String dateStr;
        Scanner sc = new Scanner(System.in);

        do {
            dateStr = sc.nextLine();
            if (evaluateString(dateStr)) {
                result[1] = Integer.parseInt(dateStr.substring(0, 2));
                result[2] = Integer.parseInt(dateStr.substring(3, 5));
                result[3] = Integer.parseInt(dateStr.substring(6, 10));
                if (result[1] > 0 && result[1] <= 31 && result[2] > 0 && result[2] <= 12 && result[3] > 1900 && result[3] <= 2024) {
                    result[0] = 1;
                } else {
                    System.out.println("La fecha tiene un formato incorrecto (dias hasta 31, meses hasta 12 y años hasta 2024)");
                    result[0] = 0;
                }
            } else {
                result[0] = 0;
            }
        } while (result[0] == 0);
        return result;
    }
}


