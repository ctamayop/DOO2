package cl.speedfast.model;

import cl.speedfast.interfaces.Cancelable;
import cl.speedfast.interfaces.Despachable;

/**
 * Clase abstracta con los datos y comportamientos de los pedidos
 */
public abstract class Pedido implements Despachable, Cancelable {
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidorAsignado;
    protected EstadoPedido estado;


    protected Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.CREADO;
    }

    /**
     * Asignación automática personalizada por cada subclase
     */
    public abstract void asignarRepartidor();

    /**
     *  Sobrecarga para asignar manualmente un repartidor
     */
    public void asignarRepartidor(String nombre) {

        this.repartidorAsignado = nombre;
    }


    public abstract int calcularTiempoEntrega();

    /**
     *  Metodo reutilizado por todos los tipos de pedido
     */
    public void mostrarResumen() {
        String distancia = distanciaKm == Math.floor(distanciaKm)
                ? String.format("%.0f", distanciaKm)
                : String.format("%.1f", distanciaKm);

        System.out.println("[" + obtenerNombreTipo() + "]");
        System.out.println("Pedido #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Repartidor asignado: " + repartidorAsignado);
        System.out.println("Tiempo estimado: " + calcularTiempoEntrega() + " minutos");
    }

    @Override
    public void despachar() {
        if (estado != EstadoPedido.CANCELADO) {
            estado = EstadoPedido.ENTREGADO;
        }
    }

    @Override
    public void cancelar() {
        if (estado != EstadoPedido.ENTREGADO) {
            estado = EstadoPedido.CANCELADO;
        }
    }

    protected abstract String obtenerNombreTipo();

    public int getIdPedido() {
        return idPedido;
    }

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}