Feature: Somar

  Scenario: somar dois números
    Given que eu tenho uma calculadora
    When eu somo 1 mais 3
    Then o resultado é 4

  Scenario: somar dois números pares
    Given que eu tenho uma calculadora
    When eu somo 2 mais 3
    Then o resultado é 5
