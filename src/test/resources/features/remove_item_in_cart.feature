#Author: Juan Miguel Blanco Medina
Feature: Eliminar items del Carrito de compras para el sitio demoblaze
  Quiero eliminar todos los items del carrito de pruebas

  Scenario: Eliminado todos los items en el carrito de compras
    Given Quiero ingresar al sitio demoblaze
    When Agrego varios items al carrito de compra
    Then Valido que el item no existe en el carrito de compra    