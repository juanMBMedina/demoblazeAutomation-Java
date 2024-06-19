#Author: Juan Miguel Blanco Medina
Feature: Precio Total en el Carrito de compras para el sitio demoblaze
  Quiero validar el precio total del carrito de pruebas

  Scenario: Validar el precio en el carrito de compras
    Given Quiero ingresar al sitio demoblaze
    When Agrego diferentes items en el carrito de compra
    Then Valido que el precio totla mostrado es correcto

