Descripción

SpeedFastApp es una aplicación desarrollada en Java para gestionar pedidos de comida, encomiendas y entregas express

El proyecto aplica principios avanzados de Programación Orientada a Objetos, como clases abstractas, herencia, polimorfismo, sobrecarga, sobrescritura e interfaces

Funcionalidades

La aplicación permite:

Crear distintos tipos de pedidos
Asignar repartidores automática y manualmente
Calcular el tiempo estimado de entrega
Mostrar el resumen de cada pedido
Despachar pedidos
Cancelar pedidos
Consultar el historial de eventos mediante un ArrayList
Tipos de pedidos

El sistema incluye las siguientes clases:

PedidoComida
PedidoEncomienda
PedidoExpress

Todas heredan de la clase abstracta Pedido y aplican reglas diferentes para asignar repartidores y calcular el tiempo de entrega.

Interfaces

El proyecto utiliza las siguientes interfaces:

Despachable: define el método despachar().
Cancelable: define el método cancelar().
Rastreable: define el método verHistorial().




