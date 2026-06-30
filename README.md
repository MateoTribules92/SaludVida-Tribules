# Farmacia SaludVida

Sistema académico para la gestión integral de una red de farmacias. El proyecto busca digitalizar procesos comerciales, administrativos y logísticos mediante un MVP funcional desarrollado para el periodo 2026A.

## Descripción

Farmacia SaludVida necesita controlar productos, proveedores, inventario por farmacia, clientes, pedidos, rutas de distribución y usuarios con diferentes niveles de acceso.

El sistema permitirá validar reglas críticas del negocio, como evitar la venta de productos vencidos o sin stock disponible.

## Alcance del MVP

El proyecto contempla los siguientes módulos:

- Usuarios y roles
- Categorías y proveedores
- Productos
- Farmacias
- Inventario por farmacia
- Clientes
- Pedidos
- Estados de pedido
- Rutas de distribución
- Reportes básicos

## Reglas de Negocio

- Cada producto debe tener una categoría.
- Cada producto debe estar asociado a un proveedor o laboratorio.
- Cada farmacia maneja su propio stock.
- No se puede vender un producto vencido.
- No se puede vender un producto sin disponibilidad.
- El stock se descuenta al confirmar un pedido.
- Los clientes se clasifican según frecuencia y volumen de compra.
- Los pedidos pasan por estados definidos antes de ser entregados.
- Las rutas consideran ubicación del cliente, vehículo y personal disponible.
- Los usuarios acceden solo a las funciones autorizadas por su rol.

## Tecnologías

- Java
- Spring Boot
- Spring Tool Suite
- Spring Data JPA
- PostgreSQL
- pgAdmin
- GitHub
