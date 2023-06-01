/*
    GlobalConverter.java
    by: https://github.com/Yassineelg
    mail: yassineelgherrabi@gmail.com
    created: 31/05/2023
*/

import java.util.HashMap;
import java.util.Map;

public class GlobalConverter {

    /* Déclaraction de constantes */
    private static final String BASE_HEXADECIMAL = "hexadecimal";
    private static final String BASE_OCTAL = "octal";
    private static final String BASE_DECIMAL = "decimal";
    private static final String BASE_BINARY = "binary";
    private static final String BASE_TEXT = "text";
    private static final String OPTION_HEX = "-h";
    private static final String OPTION_OCTAL = "-o";
    private static final String OPTION_DECIMAL = "-d";
    private static final String OPTION_BINARY = "-b";
    private static final String OPTION_TEXT = "-t";

    /* Fonction principal de l'application */
    public static void main(String[] args) {
        if (!error_handler(args))
            return;

        String base = args[0];
        String input = args[1];

        Map<String, Converter> converters = createConverters();

        if (isConverterSupported(base)) {
            System.out.println(convertInput(base, input, converters));
        } else if (isTextConversion(base)) {
            convertText(input, converters);
        } else {
            System.err.println("Error: no such converter");
        }
    }

    /* Conversion de la valeur d'entrée */
    public static String convertInput(String base, String input, Map<String, Converter> converters) {
        Converter converter = converters.get(base);
        String convertedValue = converter.convert(input);
        return convertedValue;
    }

    /* Conversion inverse de la valeur d'entrée */
    private static void convertText(String input, Map<String, Converter> converters) {
        NumberType numberType = getNumberType(input);
        Converter converter = getConverterByNumberType(numberType, converters);

        if (converter != null) {
            String convertedValue = converter.convertReverse(input);
            System.out.println(convertedValue);
        } else {
            System.err.println("Error: Invalid input");
        }
    }

    /* Récupération du convertisseur suivant le type */
    private static Converter getConverterByNumberType(NumberType numberType, Map<String, Converter> converters) {
        switch (numberType) {
            case BINARY:
                return converters.get("-b");
            case OCTAL:
                return converters.get("-o");
            case DECIMAL:
                return converters.get("-d");
            case HEXADECIMAL:
                return converters.get("-h");
            default:
                return null;
        }
    }

    /* Vérification si la base n'est pas "texte" ou "-t" */
    private static boolean isConverterSupported(String base) {
        return !base.equals("text") && !base.equals("-t");
    }

    /* Vérification si la conversion de texte est demandée */
    private static boolean isTextConversion(String base) {
        return base.equals("text") || base.equals("-t");
    }

    /* Gestion d'erreurs */
    private static boolean error_handler(String[] args) {
        if (args.length < 2 || args.length > 4) {
            System.err.println("Usage: java GlobalConverter <base> <string> [key <encryption key>]");
            return false;
        }

        if (!isValidBase(args[0])) {
            System.err.println("Error: Invalid base specified. Please enter a valid base.");
            return false;
        }

        if (!isValidInput(args[1])) {
            System.err.println("Error: Invalid string specified. Please enter a valid string.");
            return false;
        }
        return true;
    }

    /* Vérification si la base est valide */
    private static boolean isValidBase(String base) {
        String[] validBases = {BASE_HEXADECIMAL, OPTION_HEX,
                                BASE_OCTAL, OPTION_OCTAL,
                                BASE_DECIMAL,OPTION_DECIMAL,
                                BASE_BINARY, OPTION_BINARY,
                                BASE_TEXT, OPTION_TEXT};
        for (int i = 0; i < validBases.length; i++)
            if (base.equals(validBases[i]))
                return true;
        return false;
    }

    /* Vérification si la chaîne de caractère est valide */
    private static boolean isValidInput(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }

    /* Type possible du nombre pour la conversion inverse */
    enum NumberType {
        BINARY,
        OCTAL,
        DECIMAL,
        HEXADECIMAL,
        INVALID
    }

    /* Regex pour trouver le type du nombre */
    private static NumberType getNumberType(String input) {
        String cleanedInput = input.replaceAll("\\s", "");

        if (cleanedInput.matches("[01]+")) {
            return NumberType.BINARY;
        } else if (cleanedInput.matches("[0-7]+")) {
            return NumberType.OCTAL;
        } else if (cleanedInput.matches("[0-9]+")) {
            return NumberType.DECIMAL;
        } else if (cleanedInput.matches("[0-9A-Fa-f]+")) {
            return NumberType.HEXADECIMAL;
        } else {
            return NumberType.INVALID;
        }
    }

    /* Set up de la collection de convertisseurs */
    public static Map<String, Converter> createConverters() {
        Map<String, Converter> converters = new HashMap<>();
        converters.put(BASE_HEXADECIMAL, new HexConverter());
        converters.put(BASE_OCTAL, new OctConverter());
        converters.put(BASE_DECIMAL, new DecConverter());
        converters.put(BASE_BINARY, new BinConverter());
        converters.put(BASE_TEXT, new BinConverter());
        converters.put(OPTION_HEX, new HexConverter());
        converters.put(OPTION_OCTAL, new OctConverter());
        converters.put(OPTION_DECIMAL, new DecConverter());
        converters.put(OPTION_BINARY, new BinConverter());
        converters.put(OPTION_TEXT, new BinConverter());
        return converters;
    }
}