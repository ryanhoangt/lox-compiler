package lox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LoxTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void test_Assignment_global() throws IOException {
        String testFilepath = "F:\\MY-WORKING-SPACE\\2023\\05-MAY\\lox-interpreter\\test\\assignment\\global.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(
                "before\r\n" +
                        "after\r\n" +
                        "arg\r\n" +
                        "arg",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void test_Assignment_local() throws IOException {
        String testFilepath = "F:\\MY-WORKING-SPACE\\2023\\05-MAY\\lox-interpreter\\test\\assignment\\local.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(
                "before\r\n" +
                        "after\r\n" +
                        "arg\r\n" +
                        "arg",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void test_Block_scope() throws IOException {
        String testFilepath = "F:\\MY-WORKING-SPACE\\2023\\05-MAY\\lox-interpreter\\test\\block\\scope.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(
                "inner a\r\n" +
                        "outer b\r\n" +
                        "global c\r\n" +
                        "outer a\r\n" +
                        "outer b\r\n" +
                        "global c\r\n" +
                        "global a\r\n" +
                        "global b\r\n" +
                        "global c",
                outputStreamCaptor.toString().trim());
    }
}