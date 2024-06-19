#Author: Juan Miguel Blanco Medina
Feature: Agregar items al Carrito de compras para el sitio demoblaze
  Quiero agregar un Monitor al carrito de pruebas

  Scenario: Agregando Monitor al carrito
    Given Quiero ingresar al sitio demoblaze
    When Agrego un monitor al carrito de compra
    Then Valido que el item existe en el carrito de compra
