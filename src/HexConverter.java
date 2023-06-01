/*
    HexConverter.java
    by: https://github.com/Yassineelg
    mail: yassineelgherrabi@gmail.com
    created: 31/05/2023
*/

public class HexConverter implements Converter {

    /* Fonction pour la conversion hexa to string */
    @Override
    public String convert(String input) {
        StringBuilder hexBuilder = new StringBuilder();
        char[] str = input.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            String hexValue = charToHex(c);
            hexBuilder.append(hexValue);
            if (i < str.length - 1)
                hexBuilder.append(" ");
        }
        return hexBuilder.toString();
    }

    private static String charToHex(char c) {
        StringBuilder hexBuilder = new StringBuilder();
        int value = c;

        while (value > 0) {
            int ret = value % 16;
            char hexDigit = (char) (ret < 10 ? ret + '0' : ret - 10 + 'A');
            hexBuilder.insert(0, hexDigit);
            value /= 16;
        }
        return hexBuilder.toString();
    }

    /* Fonction pour la conversion string to hexa */
    @Override
    public String convertReverse(String input) {
        StringBuilder result = new StringBuilder();
        String hexValues = input.replaceAll("\\s", "");

        for (int i = 0; i < hexValues.length(); i += 2) {
            String hexPair = hexValues.substring(i, i + 2);
            int value = hexToDecimal(hexPair);
            if (value == -1) {
                System.err.println("Error: Invalid input");
                return "";
            }
            result.append((char) value);
        }
        return result.toString();
    }

    private static int hexToDecimal(String hexPair) {
        int decimalValue = 0;
        for (int i = 0; i < hexPair.length(); i++) {
            char c = hexPair.charAt(i);
            int digitValue;
            if (c >= '0' && c <= '9') {
                digitValue = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                digitValue = c - 'A' + 10;
            } else if (c >= 'a' && c <= 'f') {
                digitValue = c - 'a' + 10;
            } else {
                return -1;
            }
            decimalValue = decimalValue * 16 + digitValue;
        }
        return decimalValue;
    }
}