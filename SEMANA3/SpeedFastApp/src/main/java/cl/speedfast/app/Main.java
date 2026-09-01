package cl.speedfast.app;

import cl.speedfast.model.EstadoPedido;
import cl.speedfast.model.PedidoComida;
import cl.speedfast.model.PedidoEncomienda;
import cl.speedfast.model.PedidoExpress;
import cl.speedfast.service.ControladorDeEnvios;

public class Main {

    public static void main(String[] args) {

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        // Creación de los pedidos
        PedidoComida comida = new PedidoComida(
                201,
                "Calle Los Aromos 310",
                3.8
        );

        PedidoEncomienda encomienda = new PedidoEncomienda(
                202,
                "Av. Las Acacias 890",
                6
        );

        PedidoExpress express = new PedidoExpress(
                203,
                "Pasaje El Molino 145",
                2.5
        );

        /*
         * ASIGNACIÓN AUTOMÁTICA
         * Se ejecuta el metodo sobrescrito de cada subclase
         */
        System.out.println("=== ASIGNACIÓN AUTOMÁTICA ===");

        comida.asignarRepartidor();
        express.asignarRepartidor();

        System.out.println(
                "Pedido Comida #" + comida.getIdPedido()
                        + " - Repartidor: "
                        + comida.getRepartidorAsignado()
        );

        System.out.println(
                "Pedido Express #" + express.getIdPedido()
                        + " - Repartidor: "
                        + express.getRepartidorAsignado()
        );


        // ASIGNACIÓN MANUAL
        System.out.println("\n=== ASIGNACIÓN MANUAL ===");

        encomienda.asignarRepartidor("Camila Rojas");

        System.out.println(
                "Pedido Encomienda #" + encomienda.getIdPedido()
                        + " - Repartidor: "
                        + encomienda.getRepartidorAsignado()
        );


        // RESUMEN Y CÁLCULO DEL TIEMPO
        System.out.println("\n=== RESUMEN DEL PEDIDO ===");

        encomienda.mostrarResumen();


        // DESPACHO DE PEDIDOS
        System.out.println("\n=== DESPACHO DE PEDIDOS ===");

        controlador.despachar(comida);

        if (comida.getEstado() == EstadoPedido.ENTREGADO) {
            System.out.println(
                    "Pedido Comida #" + comida.getIdPedido()
                            + " despachado correctamente."
            );
        }

        controlador.despachar(encomienda);

        if (encomienda.getEstado() == EstadoPedido.ENTREGADO) {
            System.out.println(
                    "Pedido Encomienda #" + encomienda.getIdPedido()
                            + " despachado correctamente."
            );
        }


        //CANCELACIÓN DE UN PEDIDO
        System.out.println("\n=== CANCELACIÓN DE PEDIDO ===");

        System.out.println(
                "Cancelando Pedido Express #"
                        + express.getIdPedido() + "..."
        );

        controlador.cancelar(express);

        if (express.getEstado() == EstadoPedido.CANCELADO) {
            System.out.println(
                    "Pedido Express #" + express.getIdPedido()
                            + " cancelado exitosamente."
            );
        }


        // HISTORIAL DE ENTREGAS
        System.out.println("\n=== HISTORIAL DE ENTREGAS ===");

        controlador.verHistorial();
    }
}