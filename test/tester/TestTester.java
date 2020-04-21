package tester;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestTester {
    @Test
    public void gutTest1() throws Exception {
        Tester tester = new TesterImpl();
        String Wort1 = tester.testen("MyGoodOldSensor");

        Assert.assertEquals("MyGoodOldSensor", Wort1);
    }

    @Test
    public void schlechtTest1() throws Exception{
        Tester tester = new TesterImpl();
        try {
            String Wort1 = tester.testen("");
            Assert.fail();
        }
        catch(Exception e){
        }

    }

    @Test
    public void schlechtTest2() throws Exception{
        Tester tester = new TesterImpl();
        try {
            boolean leer;
            String Wort1 = tester.testen("");
            leer = Wort1.isEmpty();
            if (leer = true) {
                Assert.fail();
            }
                else {
            }
        }
        catch(Exception e){
                }

        }

    @Test
    public void schlechtTest3() throws Exception {
        Tester tester = new TesterImpl();
        try {
            String Wort1 = tester.testen("0.0");
            Assert.fail();
        }
        catch(Exception e){
        }

    }
}
