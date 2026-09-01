package cl.speedfast.model;

public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {

        repartidorAsignado = "Nicolás Soto";
    }

    @Override
    public void asignarRepartidor(String nombre) {

        super.asignarRepartidor(nombre);
    }

    @Override
    public int calcularTiempoEntrega() {

        return 15 + (int) Math.ceil(distanciaKm * 2);
    }

    @Override
    protected String obtenerNombreTipo() {

        return "Pedido Comida";
    }
}
