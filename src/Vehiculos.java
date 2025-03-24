import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehiculos {
    protected String Marca;
    protected String Modelo;
    protected String Anio;
    protected int PrecioDia;
    protected boolean Disponibilidad;

    List<Vehiculos> LsVehiculos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);



    public Vehiculos() {
    }

    public Vehiculos(String marca, String modelo, String anio, int precioDia, boolean disponibilidad) {
        Marca = marca;
        Modelo = modelo;
        Anio = anio;
        PrecioDia = precioDia;
        Disponibilidad = disponibilidad;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String anio) {
        Anio = anio;
    }

    public int getPrecioDia() {
        return PrecioDia;
    }

    public void setPrecioDia(int precioDia) {
        PrecioDia = precioDia;
    }

    public boolean isDisponobilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        Disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Anio='" + Anio + '\'' +
                ", PrecioDia=" + PrecioDia +
                ", Disponobilidad=" + Disponibilidad +
                '}';
    }

    public void RegistrarVehiculos(){
        System.out.println("""
                Que tipo de Vehiculo quieres alquilar.
                1) Automovil.
                2) Camioneta.
                """);
        int pregunta = scanner.nextInt();
        boolean ok=true;


        switch (pregunta) {
            case 1 -> {
                Automovil automovil = new Automovil();

                System.out.println("Ingrese la marca del vehiculo");
                automovil.setMarca(scanner.next());
                System.out.println("Ingrese el modelo del vehiculo");
                automovil.setModelo(scanner.next());
                System.out.println("Ingrese el año");
                automovil.setAnio(scanner.next());
                System.out.println("Ingrese el precio por dia arrendado");
                automovil.setPrecioDia(scanner.nextInt());
                System.out.println("Ingrese el numero de puertas del automovil");
                automovil.setNumPuertas(scanner.nextInt());
                System.out.println("Ingrese disponibilidad (si/no)");
                String disponibilidad = scanner.next();

                if (disponibilidad.equals("si")) {
                    automovil.setDisponibilidad(true);
                } else if (disponibilidad.equals("no")) {
                    automovil.setDisponibilidad(false);
                } else System.out.println("ingrese si o no");

                LsVehiculos.add(automovil);

                System.out.println("Automovil registrado con exito");
            }
            case 2 -> {
                Camioneta camioneta = new Camioneta();

                System.out.println("Ingrese la marca del vehiculo");
                camioneta.setMarca(scanner.next());
                System.out.println("Ingrese el modelo del vehiculo");
                camioneta.setModelo(scanner.next());
                System.out.println("Ingrese el año");
                camioneta.setAnio(scanner.next());
                System.out.println("Ingrese el precio por dia arrendado");
                camioneta.setPrecioDia(scanner.nextInt());
                System.out.println("Ingrese la capacidad de carga de la camioneta");
                camioneta.setCapacidadCarga(scanner.nextInt());
                System.out.println("Ingrese disponibilidad (si/no)");
                String disp = scanner.next();

                if (disp.equals("si")) {
                    camioneta.setDisponibilidad(true);
                } else if (disp.equals("no")) {
                    camioneta.setDisponibilidad(false);
                } else System.out.println("ingrese si o no");

                LsVehiculos.add(camioneta);

                System.out.println("Camioneta registrada con exito");
            }default ->
                    System.out.println("ingrese 1 para automovil o 2 para camioneta");

        }

    }

    public void buscarCarro (String modelocarro){

        for (Vehiculos vehiculos : LsVehiculos){

            if (vehiculos.getModelo().equals(modelocarro)){
                if (vehiculos.isDisponobilidad()){
                    System.out.println("El vehiculo esta disponible");
                }else System.out.println("El vehiculo no esta disponible");




                System.out.println("el vehiculo " + vehiculos.getMarca() +" modelo "+ vehiculos.getModelo() + " ah sido alquilado correctamente");
                return;
            }

        }
        System.out.println("No se encontro un vehiculo modelo " + modelocarro);
    }

    public void mostrarVehiculos (){
        boolean disponibles = false;

        for (Vehiculos vehiculo : LsVehiculos) {
            if (vehiculo.isDisponobilidad()) {
                System.out.println(vehiculo);
                disponibles = true;
            }
        }

        if (disponibles==false) {
            System.out.println("No hay vehículos disponibles en este momento.");
        }

    }


}