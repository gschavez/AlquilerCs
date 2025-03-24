import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean play = true;

        Scanner scanner = new Scanner(System.in);
        Vehiculos vehiculos = new Vehiculos();
        Clientes clientes = new Clientes();


        do {


            System.out.println("""
                    
                    Bienvenido a nuestro alquiler de vehiculos!!!
                    ¿Que deseas hacer el dia de hoy?
                    
                        1. Registrar Vehiculo.
                        2. Mostrar lista de vehiculos disponibles.
                        3. Registrar Cliente.
                        4. Mostrar lista de Clientes registrados.
                        5. Registrar retorno del Vehiculo.
                        6) Salir del programa.
                        
                    """);
            int caso = scanner.nextInt();

            switch (caso) {
                case 1 -> {
                    vehiculos.RegistrarVehiculos();
                }
                case 2 -> {
                    vehiculos.mostrarVehiculos();
                }
                case 3 -> {
                    clientes.RegistrarClientes(vehiculos);
                }

                case 4 -> {
                    clientes.mostrarCLientes();
                }
                case  5 -> {
                    clientes.eliminarCliente(vehiculos);
                }
                case  6 ->{

                    play=false;
                }
                default -> System.out.println("opcion no valida");
            }
        }while (play);


    }
}