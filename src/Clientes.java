import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clientes {
    protected String nombre;
    protected String numCedula;
    protected String numlicencia;
    protected String modelCarro;
    protected int diasAlquiler;
    protected int totalPagar;

    List<Clientes> lsClientes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Clientes() {
    }

    public Clientes(String nombre, String numCedula, String numlicencia, String modelcarro, int diasAlquiler, int totalPagar) {
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.numlicencia = numlicencia;
        this.modelCarro = modelcarro;
        this.diasAlquiler = diasAlquiler;
        this.totalPagar = totalPagar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getNumlicencia() {
        return numlicencia;
    }

    public void setNumlicencia(String numlicencia) {
        this.numlicencia = numlicencia;
    }

    public String getModelCarro() {
        return modelCarro;
    }

    public void setModelCarro(String modelCarro) {
        this.modelCarro = modelCarro;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "Nombre='" + nombre + '\'' +
                ", Numero de Cedula='" + numCedula + '\'' +
                ", Numero de Licencia='" + numlicencia + '\'' +
                ", Modelo de Vehiculo='" + modelCarro + '\'' +
                '}';
    }

    public void RegistrarClientes(Vehiculos vehiculos) {

        Clientes clientes = new Clientes();


        System.out.println("ingrese el nombre del cliente");
        clientes.setNombre(scanner.next());
        System.out.println("ingrese el numero de cedula:");
        clientes.setNumCedula(scanner.next());
        System.out.println("ingrese el numero de licencia");
        clientes.setNumlicencia(scanner.next());
        System.out.println("ingrese el modelo que desee");
        String modelo = scanner.next();
        clientes.setModelCarro(modelo);
        System.out.println("""
                
                ingrese la cantidad de dias que sera alquilado 
                (Si el alquiler es mayor a 7 días, se aplicará un descuento del 10% sobre el total.)
                
                """);
        clientes.setDiasAlquiler(scanner.nextInt());

        boolean encontrado = false;

        for (Vehiculos vehiculos1 : vehiculos.LsVehiculos) {
            if (vehiculos1.getModelo().equals(modelo)) {
                encontrado=true;
                if (vehiculos1.isDisponobilidad()) {
                    System.out.println("el vehiculo esta disponible");
                    vehiculos1.setDisponibilidad(false);
                    int valor= 0;
                    if (clientes.getDiasAlquiler()>7){
                        valor = vehiculos1.getPrecioDia() * clientes.getDiasAlquiler();
                        int descuento = 10*valor/100;
                        valor = valor - descuento;
                    }else {
                        valor = vehiculos1.getPrecioDia() * clientes.getDiasAlquiler();
                    }

                    clientes.setTotalPagar(valor);
                    System.out.println("el valor a pagar es de" + valor);
                    lsClientes.add(clientes);
                    System.out.println("cliente registrado con exito");
                    return;
                } else System.out.println("""
                        
                        El vehiculo no se encuentra disponible, el cliente no ha sido registrado correctamente 
                        Revise la lista de vehiculos.
                        
                        """);
                return;
            }

        }
    }

    public void mostrarCLientes(){
        for (Clientes clientes : lsClientes){
            System.out.println(clientes);
        }
    }
    public void eliminarCliente(Vehiculos vehiculos){
        System.out.println("Ingrese la cedula del cliente: ");
        String numCedula = scanner.next();

        boolean delete=false;

        for (Clientes clientes: lsClientes){
            if (clientes.getNumCedula().equals(numCedula)){
                lsClientes.remove(clientes);
                System.out.println("El Cliente " + getNombre() + " con Cedula " + numCedula + "Ha sido eliminado de la base...");
                vehiculos.buscarCarro(clientes.getModelCarro());
                delete = true;
                break;

            }else System.out.println("Cliente no encontrado...");

        }

    }



}