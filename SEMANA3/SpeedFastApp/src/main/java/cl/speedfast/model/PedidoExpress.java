package cl.speedfast.model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {

        repartidorAsignado = "Matías Vega";
    }

    @Override
    public void asignarRepartidor(String nombre) {

        super.asignarRepartidor(nombre);
    }

    @Override
    public int calcularTiempoEntrega() {

        return 10 + (int) Math.ceil(distanciaKm * 1.5);
    }

    @Override
    protected String obtenerNombreTipo() {

        return "Pedido Express";
    }
}