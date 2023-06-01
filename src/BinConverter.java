/*
    BinConverter.java
    by: https://github.com/Yassineelg
    mail: yassineelgherrabi@gmail.com
    created: 31/05/2023
*/

public class BinConverter implements Converter {

    /* Fonction pour la conversion string to binaire */
    @Override
    public String convert(String input) {
        StringBuilder binBuilder = new StringBuilder();
        char[] str = input.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            String binValue = charToBin(c);
            binBuilder.append(binValue);
            if (i < str.length - 1)
                binBuilder.append(" ");
        }
        return binBuilder.toString();
    }

    private static String charToBin(char c) {
        StringBuilder binBuilder = new StringBuilder();
        int value = c;

        for (int i = 7; i >= 0; i--) {
            int bit = value % 2;
            binBuilder.insert(0, bit);
            value /= 2;
        }
        return binBuilder.toString();
    }

    /* Fonction pour la conversion binaire to string */
    @Override
    public String convertReverse(String input) {
        StringBuilder result = new StringBuilder();
        String[] binaryValues = input.split(" ");

        for (String binaryValue : binaryValues) {
            int value = binaryToChar(binaryValue);
            if (value == -1) {
                System.err.println("Error: Invalid input");
                return "";
            }
            result.append((char) value);
        }
        return result.toString();
    }

    private static int binaryToChar(String binaryValue) {
        int value = 0;

        for (int i = 0; i < binaryValue.length(); i++) {
            char c = binaryValue.charAt(i);
            if (c != '0' && c != '1') {
                return -1;
            }
            value = value * 2 + (c - '0');
        }
        if (value < 0 || value > 255) {
            return -1;
        }
        return value;
    }
}