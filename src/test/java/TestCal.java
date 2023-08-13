import org.nagp3.CalculatorApp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

public class TestCal {

    private CalculatorApp calculator;

    @BeforeClass
    public void setUp() {
        calculator = new CalculatorApp();
    }

    @org.testng.annotations.Test
    public void testAdd() {

        Assert.assertEquals(calculator.add(2,4),6);
        Assert.assertEquals(calculator.add(2,5),7);
    }

    @org.testng.annotations.Test
    public void testSubtract() {
        Assert.assertEquals(calculator.subtract(6,5),1);
            }

    @org.testng.annotations.Test
    public void testmutiply() {
        Assert.assertEquals(calculator.multiply(2,5),10);
    }
    @org.testng.annotations.Test
    public void testdivide() {
        Assert.assertEquals(calculator.divide(2,2),1);
    }
}
