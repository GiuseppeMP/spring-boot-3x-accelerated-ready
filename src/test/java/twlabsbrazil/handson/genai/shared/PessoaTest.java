package twlabsbrazil.handson.genai.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

/**
 * PessoaTest
 */
@DisplayNameGeneration(ReplaceUnderscores.class)
public class PessoaTest {


    /**
     * @throws Exception
     */
    @Test
    public void test_nome_deve_ser_valido() throws Exception {
        Pessoa p = Pessoa.create("joao", 12);
        assertNotNull(p);
    }

    @Test
    public void test_nome_deve_ser_valido_2() throws Exception {
        Pessoa p = Pessoa.create("joao", 12);
        assertEquals("joao", p.getName());
        assertEquals(12, p.getAge());
    }

}
