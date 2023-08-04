import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.Matchers.equalTo;

public class ErrorCollectorTest {

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();
    private int counter = 0;

    @Before
    public void addCounter() {
        counter++;
    }


    @Test
    public void testarErro1() {
        //errorCollector.checkThat(2, equalTo(counter));
        errorCollector.checkThat(1, equalTo(counter));
    }

    @Test
    public void testarAcerto1() {
        //errorCollector.checkThat(1, equalTo(counter));
    }

    @Test
    public void testarErro2() {
        //errorCollector.checkThat('a', equalTo('b'));
    }
}
