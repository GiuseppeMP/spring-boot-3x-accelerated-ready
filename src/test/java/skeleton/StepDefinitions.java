package skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitions {

    Calculadora calculadora;
    int resultado;

    @Given("que eu tenho uma calculadora") // preparo o ambiente
    public void que_eu_tenho_uma_calculadora() {
        this.calculadora = new Calculadora();
    }

    @When("eu somo {int} mais {int}") // interajo com ambiente
    public void eu_somo_a_mais_b(int a, int b) {
        this.resultado = this.calculadora.somar(a, b);
    }

    @Then("o resultado é {int}") // asserções após interação com ambiente
    public void o_resultado_e_x(int esperado) {
        assertThat(this.resultado).isEqualTo(esperado);
    }
}

