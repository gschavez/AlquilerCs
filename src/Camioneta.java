public class Camioneta extends Vehiculos{
    protected int CapacidadCarga;

    public Camioneta() {
    }

    public Camioneta(String marca, String modelo, String anio, int precioDia, boolean disponobilidad, int capacidadCarga) {
        super(marca, modelo, anio, precioDia, disponobilidad);
        CapacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return CapacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        CapacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.toString() + "Camioneta{" +
                "CapacidadCarga=" + CapacidadCarga +
                '}';
    }


}