package org.nagp3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {


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


}