package cl.praxis.desafios.quienmayor;

import java.util.Scanner;

public class Fechas {

    public static void main(String[] args) {
        String fecha1, fecha2;
        int fecha1Day = 0, fecha2Day = 0, fecha1Month = 0, fecha2Month = 0, fecha1Year = 0, fecha2Year = 0;
        boolean status;
        System.out.println("----------------");
        System.out.println("¿Quién es mayor?");
        System.out.println("----------------");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Ingresa la primera fecha como DD/MM/AAAA:");
            fecha1 = sc.nextLine();
            if (evaluateString(fecha1)) {
                fecha1Day = Integer.parseInt(fecha1.substring(0, 2));
                fecha1Month = Integer.parseInt(fecha1.substring(3, 5));
                fecha1Year = Integer.parseInt(fecha1.substring(6, 10));
                if (fecha1Day > 0 && fecha1Day <= 31 && fecha1Month > 0 && fecha1Month <= 12 && fecha1Year > 1900 && fecha1Year <= 2024) {
                    status = true;
                } else {
                    System.out.println("La fecha tiene un formato incorrecto (dias hasta 31, meses hasta 12 y años hasta 2024)");
                    status = false;
                }
            } else {
                status = false;
            }
        } while (!status);

        do {
            System.out.println("Ingresa la segunda fecha como DD/MM/AAAA:");
            fecha2 = sc.nextLine();
            if (evaluateString(fecha2)) {
                fecha2Day = Integer.parseInt(fecha2.substring(0, 2));
                fecha2Month = Integer.parseInt(fecha2.substring(3, 5));
                fecha2Year = Integer.parseInt(fecha2.substring(6, 10));
                if (fecha2Day > 0 && fecha2Day <= 31 && fecha2Month > 0 && fecha2Month <= 12 && fecha2Year > 1900 && fecha2Year <= 2024) {
                    status = true;
                } else {
                    System.out.println("La fecha tiene un formato incorrecto (dias hasta 31, meses hasta 12 y años hasta 2024)");
                    status = false;
                }
            } else {
                status = false;
            }
        } while (!status);


        if (fecha1Year > fecha2Year) {
            System.out.println("La persona 2 es mayor");
        } else if (fecha1Year == fecha2Year) {
            if (fecha1Month > fecha2Month) {
                System.out.println("La persona 2 es mayor");
            } else if (fecha1Month == fecha2Month) {
                if (fecha1Day > fecha2Day) {
                    System.out.println("La persona 2 es mayor");
                } else if (fecha2Day > fecha1Day) {
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

}
