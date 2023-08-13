import org.nagp3.Main;
import org.testng.Assert;

public class Test  extends Main {

    @org.testng.annotations.Test
    public static void addmethod()
    {
        int a = 5+5;
        Assert.assertEquals(a,10);
    }

    @org.testng.annotations.Test
    public static void deletemethod()
    {
        int a = 10-5;
        Assert.assertEquals(a,5);
    }

    @org.testng.annotations.Test
    public static void multiplyumethod()
    {
        int a = 5*5;
        Assert.assertEquals(a,25);
    }
    @org.testng.annotations.Test
    public static void multiply3umethod()
    {
        int a = 15*5;
        Assert.assertEquals(a,75);
    }

    @org.testng.annotations.Test
    public static void testString()
    {
        Assert.assertEquals("ashutosh","ashutosh");
    }

    @org.testng.annotations.Test
    public static void testM()
    {
        Assert.assertEquals(method("test"),"test");

    }
}
