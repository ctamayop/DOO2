package cl.speedfast.data;

import cl.speedfast.model.EstadoPedido;
import cl.speedfast.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {
    private final List<Pedido> pedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p) {
        if (p == null || p.getEstado() != EstadoPedido.PENDIENTE) {
            throw new IllegalArgumentException("El pedido debe estar PENDIENTE");
        }
        if (pedidos.contains(p)) {
            throw new IllegalArgumentException("El pedido ya esta en la zona de carga");
        }
        pedidos.add(p);
        System.out.println("[Zona de carga] Agregado: " + p);
    }

    public synchronized Pedido retirarPedido() {
        if (pedidos.isEmpty()) {
            return null;
        }

        return pedidos.remove(0);
    }
}
