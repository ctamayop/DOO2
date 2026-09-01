package cl.speedfast.service;

import cl.speedfast.interfaces.Cancelable;
import cl.speedfast.interfaces.Despachable;
import cl.speedfast.interfaces.Rastreable;
import cl.speedfast.model.EstadoPedido;
import cl.speedfast.model.Pedido;

import java.util.ArrayList;


public class ControladorDeEnvios implements Rastreable {

    private ArrayList<String> historial = new ArrayList<>();

    public void despachar(Pedido pedido) {
        Despachable despachable = pedido;
        despachable.despachar();

        if (pedido.getEstado() == EstadoPedido.ENTREGADO) {
            historial.add(pedido.getClass().getSimpleName()
                    + " #" + pedido.getIdPedido()
                    + " - entregado por " + pedido.getRepartidorAsignado());
        }
    }

    public void cancelar(Pedido pedido) {
        Cancelable cancelable = pedido;
        cancelable.cancelar();
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial:");
        for (String entrega : historial) {
            System.out.println("- " + entrega);
        }
    }
}
