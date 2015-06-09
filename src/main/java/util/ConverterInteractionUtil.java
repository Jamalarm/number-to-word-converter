package util;

import converters.CompositeNumberToTextConverter;

import java.util.Scanner;

/**
 * basic util class for interacting with my solution
 */
public class ConverterInteractionUtil {

    public static void main(String[] args) {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please provide an int");
            String line = scanner.nextLine();
            try {
                System.out.println(converter.convertToString(Integer.parseInt(line)));
            } catch (NumberFormatException e) {
                System.out.println("Input was not a number! Try again");
            }
        }
    }

}
