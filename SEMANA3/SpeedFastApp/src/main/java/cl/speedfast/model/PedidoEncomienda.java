package cl.speedfast.model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {

        repartidorAsignado = "Daniela Tapia";
    }

    @Override
    public void asignarRepartidor(String nombre) {

        super.asignarRepartidor(nombre);
    }

    @Override
    public int calcularTiempoEntrega() {

        return 16 + (int) Math.ceil(distanciaKm * 2);
    }

    @Override
    protected String obtenerNombreTipo() {

        return "Pedido Encomienda";
    }
}
