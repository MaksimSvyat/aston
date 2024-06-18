package jivern;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FactorialAppTest {
    @Test
    @Order(1)
    public void testFactorialAppZero() {
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 0 равен 1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @Order(2)
    public void testFactorialAppOne() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 1 равен 1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @Order(3)
    public void testFactorialAppThree() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 3 равен 6\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @Order(4)
    public void testFactorialAppFive() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 5 равен 120\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @Order(5)
    public void testFactorialAppSeven() {
        String input = "7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FactorialApp.main(new String[]{});

        String expectedOutput = "Введите число: Факториал числа 7 равен 5040\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
