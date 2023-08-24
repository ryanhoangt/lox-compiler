package lox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class LoxTest {
    private final String testDirPath = Paths.get("..\\test")
            .normalize().toAbsolutePath().toString();
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
        String testFilepath = testDirPath + "\\assignment\\global.lox";
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
        String testFilepath = testDirPath + "\\assignment\\local.lox";
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
        String testFilepath = testDirPath + "\\block\\scope.lox";
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

    @Test
    void test_Loop_fibonacci() throws IOException {
        String testFilepath = testDirPath + "\\loop\\fibonacci.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(
                "0\r\n" +
                        "1\r\n" +
                        "1\r\n" +
                        "2\r\n" +
                        "3\r\n" +
                        "5\r\n" +
                        "8\r\n" +
                        "13\r\n" +
                        "21\r\n" +
                        "34\r\n" +
                        "55\r\n" +
                        "89\r\n" +
                        "144\r\n" +
                        "233\r\n" +
                        "377\r\n" +
                        "610\r\n" +
                        "987\r\n" +
                        "1597\r\n" +
                        "2584\r\n" +
                        "4181\r\n" +
                        "6765",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void test_function_no_return_stmt() throws IOException {
        String testFilepath = testDirPath + "\\function\\no_return.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(outputStreamCaptor.toString().trim(), "6");
    }

    @Test
    void test_function_parameters() throws IOException {
        String testFilepath = testDirPath + "\\function\\parameters.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(outputStreamCaptor.toString().trim(), "0\r\n" +
                "1\r\n" +
                "3\r\n" +
                "6\r\n" +
                "10\r\n" +
                "15\r\n" +
                "21\r\n" +
                "28\r\n" +
                "36");
    }
    
    @Test
    void test_function_recursion() throws IOException {
        String testFilepath = testDirPath + "\\function\\recursion.lox";
        Lox.main(new String[]{testFilepath});
        assertEquals(outputStreamCaptor.toString().trim(), "21");
    }
}