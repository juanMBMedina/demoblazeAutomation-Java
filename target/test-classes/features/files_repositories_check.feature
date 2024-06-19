#Author: juan.blanco@sophossolutions.com
Feature: Verificacion archivos en repositorio
  Quiero capturar la cantidad de archivos en un repositorio.

  Scenario Outline: Verificacion de archivos
    Given Quiero entrar a github "https://github.com/"
    When Buscar la cantidad de archivos en el repositorio <repoName>
    Then Validar por tipo la cantidad de archivos en el repositorio

    Examples: 
      | repoName  |
#      | angular   |
      | react     |
#      | node      |
#      | vue       |
