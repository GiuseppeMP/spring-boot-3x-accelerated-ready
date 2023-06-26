package twlabsbrazil.handson.genai.shared;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import net.datafaker.Faker;

public class CpfTest {

    private Faker faker = new Faker();

    @ParameterizedTest
    @ValueSource(strings = {"26878749018", "868.787.490-18", "996.598.050-04", "182.429.920-61"})
    public void test_if_cpf_is_valid(String cpf) {
        assertThat(Cpf.isValid(cpf)).as("CPF %s should be valid", cpf).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"000000000000", "asdfasdfasdf", "11111111111", "222222222222",
            "33333333333", "44444444444", "55555555555", "66666666666", "77777777777",
            "88888888888", "99999999999", "1234567890"})
    public void test_if_cpf_is_invalid(String cpf) throws Exception {
        assertFalse(Cpf.isValid(cpf));
    }

    @Test
    public void test_if_cpf_generated_is_valid() {
        for (int i = 0; i < 50; i++) {
            assertTrue(Cpf.isValid(faker.cpf().valid()));
        }
    }

}
