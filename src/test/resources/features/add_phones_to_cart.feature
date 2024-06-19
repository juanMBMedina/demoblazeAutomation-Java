#Author: Juan Miguel Blanco Medina
Feature: Agregar items tipo Celular al Carrito de compras para el sitio demoblaze
  Quiero agregar un Celular al carrito de pruebas

  Scenario: Agregando Celular al carrito
    Given Quiero ingresar al sitio demoblaze
    When Agrego un celular al carrito de compra
    Then Valido que el item existe en el carrito de compra
