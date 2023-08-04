import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class ContadorNaoEstaticoTest {

    private Integer count = 0;

    /**
     * Não consegue manter o mesmo valor da variável count entre as funções
     */

    @Before
    public void soma1() {
        count ++;
    }

    @Test
    public void testaCount1() {
        Assert.assertEquals(1, count, 0);
    }

    @Test
    public void testaCount2() {
        Assert.assertEquals(1, count, 0);
    }

    @Test
    public void testaCount3() {
        Assert.assertNotSame(2, count);
        Assert.assertNotSame(3, count);
    }

}
