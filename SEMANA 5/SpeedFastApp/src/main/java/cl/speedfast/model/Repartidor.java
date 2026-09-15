package cl.speedfast.model;

import cl.speedfast.data.ZonaDeCarga;

public class Repartidor implements Runnable {
    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null) {
                System.out.println("[" + nombre + "] Sin mas pedidos por retirar");
                return;
            }

            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("[" + nombre + "] Retira pedido #" + pedido.getId()
                    + " | Estado: " + pedido.getEstado());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[" + nombre + "] Entrega interrumpida del pedido #"
                        + pedido.getId() + ". No se marca como ENTREGADO");
                return;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("[" + nombre + "] Entrego pedido #" + pedido.getId()
                    + " | Estado: " + pedido.getEstado());
        }
    }
}
