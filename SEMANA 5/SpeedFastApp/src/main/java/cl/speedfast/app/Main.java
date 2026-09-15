package cl.speedfast.app;

import cl.speedfast.data.ZonaDeCarga;
import cl.speedfast.model.EstadoPedido;
import cl.speedfast.model.Pedido;
import cl.speedfast.model.Repartidor;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== COORDINACIÓN DE ENTREGAS ===");
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        Pedido[] pedidos = {
                new Pedido(1, "Pasaje Cuatro 90"),
                new Pedido(2, "Los Aromos 103"),
                new Pedido(3, "Las Acacias 1182"),
                new Pedido(4, "Los Olivos 4"),
                new Pedido(5, "Av. Baquedano 500"),
                new Pedido(6, "Arrecife 1744")
        };

        // Se cargan todos los pedidos
        for (Pedido pedido : pedidos) {
            zonaDeCarga.agregarPedido(pedido);
        }

        Thread[] hilos = {
                new Thread(new Repartidor("Repartidor: Ricardo", zonaDeCarga)),
                new Thread(new Repartidor("Repartidor: Alex", zonaDeCarga)),
                new Thread(new Repartidor("Repartidor: Carlos", zonaDeCarga))
        };

        System.out.println("\n=== INICIO DEL REPARTO ===");
        for (Thread hilo : hilos) {
            hilo.start();
        }

        try {

            for (Thread hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            for (Thread hilo : hilos) {
                hilo.interrupt();
            }
            Thread.currentThread().interrupt();
            System.out.println("La simulación fue interrumpida");
            return;
        }


        System.out.println("\n=== ESTADO FINAL DE LOS PEDIDOS ===");
        boolean todosEntregados = true;
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            if (pedido.getEstado() != EstadoPedido.ENTREGADO) {
                todosEntregados = false;
            }
        }

        if (todosEntregados) {
            System.out.println("\nTodos los pedidos han sido entregados correctamente");
        } else {
            System.out.println("\nHay pedidos que no fueron entregados");
        }
    }
}
