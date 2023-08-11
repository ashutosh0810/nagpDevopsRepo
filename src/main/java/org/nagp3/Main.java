package org.nagp3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {



    @Test
    public static void addmethod()
    {
        int a = 5+5;
        Assert.assertEquals(a,10);
    }

    @Test
    public static void deletemethod()
    {
        int a = 5-5;
        Assert.assertEquals(a,0);
    }

    @Test
    public static void multiplyumethod()
    {
        int a = 5*5;
        Assert.assertEquals(a,25);
    }
    
}