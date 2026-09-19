package util;

public class EntradaConsola {
    
    private static final java.util.Scanner SCANNER= new java.util.Scanner(System.in);

    private EntradaConsola() {
        // Constructor privado para evitar instanciación
    }

public static  String leerTexto(String mensaje) {
    System.out.print(mensaje);
    return SCANNER.nextLine().trim();


}


public static int leerEntero(String mensaje) {
    while (true) {
        System.out.print(mensaje);
        String input = SCANNER.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
        }
    }
}
public static String leerDecimal(String mensaje) {
    while (true) {
        System.out.print(mensaje);
        String input = SCANNER.nextLine().trim();
        try {
            Double.parseDouble(input);
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número decimal.");
        }
    }
    }

}

