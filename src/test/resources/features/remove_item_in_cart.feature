#Author: Juan Miguel Blanco Medina
Feature: Agregar items tipo Laptop al Carrito de compras para el sitio demoblaze
  Quiero agregar una Laptop al carrito de pruebas

  Scenario: Agregando Laptop al carrito
    Given Quiero ingresar al sitio demoblaze
    When Agrego un celular al carrito de compra
    When Agrego un monitor al carrito de compra
    When Agrego una laptop al carrito de compra
    Then Valido que el item existe en el carrito de compra