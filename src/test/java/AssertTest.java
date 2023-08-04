import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void teste() {
        Assert.assertTrue(true);

        Assert.assertFalse(false);

        Assert.assertEquals(1d, 1.0d, 0.0);

        Assert.assertEquals(Math.PI, 3.14, 0.01);


        //tipo primitivo
        int i = 5;
        Integer i2 = 5;

        Assert.assertEquals(Integer.valueOf(i), i2);

        Assert.assertEquals("bola", "bola");

        //Assert.assertEquals("Bola", "bola");
        Assert.assertTrue("Bola".equalsIgnoreCase("bola"));

        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");

        //depois de criado o equals no object
        Assert.assertEquals(u1, u2);

        // se mesmo objeto
        //Assert.assertSame(u1, u2); //Erro

        Usuario u3 = u1;

        Assert.assertSame(u1, u3);

        Assert.assertNotSame(u1, u2);

        Usuario u4 = null;

        Assert.assertNull("Objeto não nulo", u4);
    }
}
