import org.nagp3.CalculatorApp;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

public class Test {

    private CalculatorApp calculator;

    @BeforeClass
    public void setUp() {
        calculator = new CalculatorApp();
    }

    @org.testng.annotations.Test
    public void testAdd() {
        assertEquals(calculator.add(2, 3), 5);
        assertEquals(calculator.add(-2, 1), -1);
    }

    @org.testng.annotations.Test
    public void testSubtract() {
        assertEquals(calculator.subtract(3, 2), 1);
        assertEquals(calculator.subtract(-1, 2), -3);
    }

    @org.testng.annotations.Test
    public void testmutiply() {
        assertEquals(calculator.subtract(3, 2), 1);
        assertEquals(calculator.subtract(-1, 2), -3);
    }
    @org.testng.annotations.Test
    public void testdivide() {
        assertEquals(calculator.subtract(3, 2), 1);
        assertEquals(calculator.subtract(-1, 2), -3);
    }
}
