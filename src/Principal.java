import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarPelicula consulta = new ConsultarPelicula();
        GeneradorDeArchivo generador = new GeneradorDeArchivo();

        System.out.println("=== Consultor de películas SWAPI ===");

        boolean seguir = true;
        while (seguir) {
            System.out.println("\nElige una opción:");
            System.out.println("1 - Película 1");
            System.out.println("2 - Película 2");
            System.out.println("3 - Película 3");
            System.out.println("4 - Película 4");
            System.out.println("5 - Película 5");
            System.out.println("6 - Película 6");
            System.out.println("0 - Salir");
            System.out.print("Ingrese número de película (0-6): ");

            String entrada = scanner.nextLine().trim();

            // Validación básica: que sea un entero entre 0 y 6
            int numero;
            try {
                numero = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido (0-6).");
                continue;
            }

            if (numero == 0) {
                System.out.println("Saliendo. ¡Hasta luego!");
                seguir = false;
                continue;
            }

            if (numero < 1 || numero > 6) {
                System.out.println("Número fuera de rango. Elige entre 1 y 6.");
                continue;
            }

            try {
                // Consultamos la API
                Film pelicula = consulta.buscarPelicula(numero);

                // Mostramos los datos en consola
                System.out.println("\n--- Resultado ---");
                System.out.println(pelicula); // usa el toString() de Film

                // Guardamos JSON en archivo
                generador.guardarJson(pelicula);

            } catch (Exception e) {
                // Mensaje amigable si algo falla (red/parseo)
                System.out.println("Ocurrió un error al obtener la película: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
