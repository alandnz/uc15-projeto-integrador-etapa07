package controlepg;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProgramaTeste {

    public ProgramaTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void criarProgramaDadosNoConstrutor() {
        Programa programa = new Programa(
                1,
                "Programa de Pós-Graduação em Informática",
                "PPGI",
                50000.00f
        );

        assertEquals(1, programa.getId());
        assertEquals("Programa de Pós-Graduação em Informática", programa.getNome());
        assertEquals("PPGI", programa.getSigla());
        assertEquals(50000.00f, programa.getValorRecebido(), 0.001f);
    }

    @Test
    public void permitirCamposVaziosNoObjetoPrograma() {
        Programa programa = new Programa();

        programa.setNome("");
        programa.setSigla("");

        assertNotNull(programa.getNome());
        assertNotNull(programa.getSigla());
        assertEquals("", programa.getNome());
        assertEquals("", programa.getSigla());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoPermitirValorRecebidoNegativo() {
        Programa programa = new Programa();

        programa.setValorRecebido(-1000.00f);
    }
}
