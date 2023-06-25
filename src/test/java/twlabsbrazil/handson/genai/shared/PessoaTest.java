package twlabsbrazil.handson.genai.shared;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

/**
 * PessoaTest
 */
@DisplayNameGeneration(ReplaceUnderscores.class)
public class PessoaTest {

    /**
     * @throws Exception
     */
    @Test
    public void test_nome_deve_ser_valido_e_idade_tambem() throws Exception {
        Faker faker = new Faker();
        int age = faker.number().numberBetween(1, 100);
        String name = faker.name().fullName();
        Pessoa p = Pessoa.create(name, age);

        assertThat(p).isNotNull().hasFieldOrPropertyWithValue("name", name)
                .hasFieldOrPropertyWithValue("age", age);
    }

    @Test
    public void test_nome_invalido_deve_disparar_illegal_args_exception() throws Exception {
        Faker faker = new Faker();
        int age = faker.number().numberBetween(1, 100);
        String name = "";
        assertThatThrownBy(() -> Pessoa.create(name, age))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {151, -1, 0, 121})
    public void test_idade_invalida_deve_disparar_illegal_args_exception(int age) throws Exception {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        assertThatThrownBy(() -> Pessoa.create(name, age))
                .as("Invalid age: "  + age)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
