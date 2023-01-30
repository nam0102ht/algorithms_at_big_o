package unit.com.ntnn;

import com.ntnn.leetcode.MinPro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class MinProTest {

    @Test
    public void testMain() throws FileNotFoundException {
        String[] args = {};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        MinPro.main(args);
        Assertions.assertEquals("0 1 1 2 3 5 8 13 21 34", outContent.toString());
    }
}
