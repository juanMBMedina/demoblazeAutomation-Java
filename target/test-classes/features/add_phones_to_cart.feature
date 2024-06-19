#Author: Juan Miguel Blanco Medina
Feature: Agregar items tipo Celular al Carrito de compras para el sitio demoblaze
  Quiero agregar un celular al carrito de pruebas

  Scenario: Agregando Celular al carrito
    Given Quiero ingresar al sitio demoblaze
    When Dado que quiero agregar un celular al carrito de compra
    Then Validar que el item existe en el carrito de compra
