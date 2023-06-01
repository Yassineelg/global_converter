/*
    DecConverter.java
    by: https://github.com/Yassineelg
    mail: yassineelgherrabi@gmail.com
    created: 31/05/2023
*/

public class DecConverter implements Converter {

    /* Fonction pour la conversion décimal to string */
    @Override
    public String convert(String input) {
        StringBuilder decBuilder = new StringBuilder();
        char[] str = input.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            int decValue = c;
            decBuilder.append(decValue);
            if (i < str.length - 1)
                decBuilder.append(" ");
        }
        return decBuilder.toString();
    }

    /* Fonction pour la conversion string to décimal */
    @Override
    public String convertReverse(String input) {
        StringBuilder result = new StringBuilder();
        String[] decimalValues = input.split(" ");

        for (String decimalValue : decimalValues) {
            int value = decimalToChar(decimalValue);
            if (value == -1) {
                System.err.println("Error: Invalid input");
                return "";
            }
            result.append((char) value);
        }
        return result.toString();
    }

    private static int decimalToChar(String decimalValue) {
        int value = 0;

        for (int i = 0; i < decimalValue.length(); i++) {
            char c = decimalValue.charAt(i);
            if (c < '0' || c > '9') {
                return -1;
            }
            value = value * 10 + (c - '0');
        }
        if (value < 0 || value > 255) {
            return -1;
        }
        return value;
    }
}