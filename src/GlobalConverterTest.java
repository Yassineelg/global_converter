/*
    GlobalConverterTest.java
    by: https://github.com/Yassineelg
    mail: yassineelgherrabi@gmail.com
    created: 31/05/2023
*/

import org.junit.Test;

import java.beans.Transient;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GlobalConverterTest {

    /* Test avec la base hexadecimal (utilisant "hexadecimal comme base" et le message */
    @Test
    public void HexConvertBase() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"hexadecimal", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "48 65 6C 6C 6F 20 77 6F 72 6C 64";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base hexadecimal (utilisant "-h" comme base) et le message */
    @Test
    public void HexConvertOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-h", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "48 65 6C 6C 6F 20 77 6F 72 6C 64";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "text" comme base) et la valeur hexadecimal */
    @Test
    public void HexConvertBaseReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"text", "48 65 6C 6C 6F 20 77 6F 72 6C 64"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "-t" comme base) et la valeur hexadecimal */
    @Test
    public void HexConvertOptionReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-t", "48 65 6C 6C 6F 20 77 6F 72 6C 64"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base binaire (utilisant "binary" comme base" et le message */
    @Test
    public void BinConvertBase() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"binary", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "01001000 01100101 01101100 01101100 01101111 00100000 01110111 01101111 01110010 01101100 01100100";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base binaire (utilisant "-b" comme base" et le message */
    @Test
    public void BinConvertOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-b", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "01001000 01100101 01101100 01101100 01101111 00100000 01110111 01101111 01110010 01101100 01100100";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "text" comme base) et la valeur binaire */
    @Test
    public void BinConvertBaseReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"text", "01001000 01100101 01101100 01101100 01101111 00100000 01110111 01101111 01110010 01101100 01100100"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "-t" comme base) et la valeur binaire */
    @Test
    public void BinConvertOptionReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-t", "01001000 01100101 01101100 01101100 01101111 00100000 01110111 01101111 01110010 01101100 01100100"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base décimal (utilisant "decimal" comme base" et le message */
    @Test
    public void DecConvertBase() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"decimal", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "72 101 108 108 111 32 119 111 114 108 100";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base décimal (utilisant "-d" comme base" et le message */
    @Test
    public void DecConvertOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-d", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "72 101 108 108 111 32 119 111 114 108 100";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "text" comme base) et la valeur décimal */
    @Test
    public void DecConvertBaseReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"text", "72 101 108 108 111 32 119 111 114 108 100"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "text" comme base) et la valeur décimal */
    @Test
    public void DecConvertOptionReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-t", "72 101 108 108 111 32 119 111 114 108 100"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base octal (utilisant "octal" comme base" et le message */
    @Test
    public void OctConvertBase() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"octal", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "110 145 154 154 157 40 167 157 162 154 144";
        assertEquals(expectedOutput, output);
    }

    /* Test avec la base octal (utilisant "-o" comme base" et le message */
    @Test
    public void OctConvertOption() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-o", "Hello world"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "110 145 154 154 157 40 167 157 162 154 144";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "text" comme base) et la valeur octal */
    @Test
    public void OctConvertBaseReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"text", "110 145 154 154 157 40 167 157 162 154 144"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test inverse avec la base text (utilisant "text" comme base) et la valeur octal */
    @Test
    public void OctConvertOptionReverse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = {"-t", "110 145 154 154 157 40 167 157 162 154 144"};
        GlobalConverter.main(args);
        String output = outputStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Hello world";
        assertEquals(expectedOutput, output);
    }

    /* Test gestion d'erreur "Trop d'argument" */
    @Test
    public void tooMuchArgError() {
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorStream));
        String[] args = {"-h", "Hello world", "key", "3", "test"};
        GlobalConverter.main(args);
        String errorOutput = errorStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Usage: java GlobalConverter <base> <string> [key <encryption key>]";
        assertEquals(expectedOutput, errorOutput);
    }

    /* Test gestion d'erreur "Pas assez d'argument" */
    @Test
    public void notEnoughArgError() {
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorStream));
        String[] args = {"-h"};
        GlobalConverter.main(args);
        String errorOutput = errorStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Usage: java GlobalConverter <base> <string> [key <encryption key>]";
        assertEquals(expectedOutput, errorOutput);
    }

    /* Test gestion d'erreur base non valide */
    @Test
    public void baseNotValid() {
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorStream));
        String[] args = {"-a", "Hello world"};
        GlobalConverter.main(args);
        String errorOutput = errorStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Error: Invalid base specified. Please enter a valid base.";
        assertEquals(expectedOutput, errorOutput);
    }

    /* Test gestion d'erreur entrée non valide */
    @Test
    public void inputNotValid() {
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorStream));
        String[] args = {"-h", "Hello$ world"};
        GlobalConverter.main(args);
        String errorOutput = errorStream.toString().trim();
        System.setOut(System.out);
        String expectedOutput = "Error: Invalid string specified. Please enter a valid string.";
        assertEquals(expectedOutput, errorOutput);
    }
}
