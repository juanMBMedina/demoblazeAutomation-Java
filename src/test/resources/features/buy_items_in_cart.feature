#Author: Juan Miguel Blanco Medina
Feature: Realizar compra de items en el Carrito de compras para el sitio demoblaze
  Realiza una compra en el carrito de pruebas

  Scenario Outline: Title of your scenario outline
    Given Quiero ingresar al sitio demoblaze
    When Voy a comparar items con los datos <fullname> <country> <city> <creditcard> <month> <year>
    Then Valido que la compra fue realizada de forma correcta

    Examples: 
      | fullname    | country  | city  | creditcard | month | year |
      | Juan Miguel | Colombia | Soata |     123456 | Junio | 2024 |
