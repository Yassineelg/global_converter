/*
    OctConverter.java
    by: https://github.com/Yassineelg
    mail: yassineelgherrabi@gmail.com
    created: 31/05/2023
*/

public class OctConverter implements Converter {

    /* Fonction pour la conversion string to octal */
    @Override
    public String convert(String input) {
        StringBuilder octBuilder = new StringBuilder();
        char[] str = input.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            String octValue = charToOct(c);
            octBuilder.append(octValue);
            if (i < str.length - 1)
                octBuilder.append(" ");
        }
        return octBuilder.toString();
    }

    private static String charToOct(char c) {
        StringBuilder octBuilder = new StringBuilder();
        int value = c;

        while (value > 0) {
            int ret = value % 8;
            char octDigit = (char) (ret + '0');
            octBuilder.insert(0, octDigit);
            value /= 8;
        }
        return octBuilder.toString();
    }

    /* Fonction pour la conversion octal to string */
    @Override
    public String convertReverse(String input) {
        StringBuilder result = new StringBuilder();
        String[] octalValues = input.split(" ");

        for (String octalValue : octalValues) {
            int decimalValue = octalToDecimal(octalValue);
            if (decimalValue == -1) {
                System.err.println("Error: Invalid input");
                return "";
            }
            char c = (char) decimalValue;
            result.append(c);
        }
        return result.toString();
    }

    private static int octalToDecimal(String octalValue) {
        int decimalValue = 0;
        for (int i = 0; i < octalValue.length(); i++) {
            char c = octalValue.charAt(i);
            if (c < '0' || c > '7') {
                return -1;
            }
            int digitValue = c - '0';
            decimalValue = decimalValue * 8 + digitValue;
        }
        return decimalValue;
    }
}