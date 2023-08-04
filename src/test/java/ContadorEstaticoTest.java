import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class ContadorEstaticoTest {

    private static Integer count = null;

    @BeforeClass
    public static void initVariables() {
        count = 0;
    }

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
        Assert.assertEquals(2, count, 0);
    }

    @Test
    public void testaCount3() {
        Assert.assertNotSame(4, count);
    }

}
