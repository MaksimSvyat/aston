package jivern;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class FactorialAppTest {

    @Test(priority = 1)
    public void testFactorialAppZero() {
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 0 равен 1\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test(priority = 2)
    public void testFactorialAppOne() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 1 равен 1\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test(priority = 3)
    public void testFactorialAppThree() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 3 равен 6\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test(priority = 4)
    public void testFactorialAppFive() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 5 равен 120\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test(priority = 5)
    public void testFactorialAppSeven() {
        String input = "7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 7 равен 5040\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}
