#Author: Juan Miguel Blanco Medina
Feature: Eliminar items del Carrito de compras para el sitio demoblaze
  Quiero eliminar un item al carrito de pruebas

  Scenario: Eliminado un item en el carrito de compras
    Given Quiero ingresar al sitio demoblaze
    When Agrego varios items al carrito de compra
    Then Valido que el item no existe en el carrito de compra