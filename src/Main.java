// Program Title : Arithmetic Calculator
// Programmer & Author : Keith Ralph Poncardas
// Programming Language : Java
// Date Launched : April 22, 2024

import java.util.Scanner;

public class Main {
    // Function To Perform Addition
    public static int addition (int a, int b) {
        return a + b;
    }
    // Function To Perform Subtraction
    public static int subtraction (int a, int b) {
        return a - b;
    }
    // Function To Perform Multiplication
    public static int multiplication (int a, int b) {
        return a * b;
    }
    // Function Perform Multiplication
    public static int division (int a, int b) {
        return a / b;
    }
    // Function To Check If The User Select Is Valid
    public static boolean isValidSelection (String operator) {
        String[] validSelections = {"add", "sub", "mul", "div"};

        boolean isValid = false;

        for (String validSelection : validSelections) {
            if (validSelection.equals(operator)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
    // Function To Get Operator Input
    public static String getOperator () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Operator (add, sub, mul, div) [exit] :");
            String operator = scanner.nextLine().trim().toLowerCase();

            if (operator.equals("exit")) {
                return null;
            }

            if (operator.isEmpty()) {
                System.out.println("No Input, Try Again.");
                continue;
            }

            boolean isValidOperator = isValidSelection(operator);

            if (!isValidOperator) {
                System.out.println("Invalid Input, Try Again.");
                continue;
            }

            return operator;
        }
    }
    // Function To Get Value One Input
    public static int getValueOne () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Value 1 [exit] :");
            String valOneInput = scanner.nextLine().trim();

            if (valOneInput.equals("exit")) {
                return 0;
            }

            if (!valOneInput.isEmpty()) {
                try {
                    return Integer.parseInt(valOneInput);
                } catch (NumberFormatException e) {
                    System.out.println("Use Valid Number, Try Again.");
                }
            } else {
                System.out.println("No Input, Try Again.");
            }
        }
    }
    // Function To Get Value Two Input
    public static int getValueTwo () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Value 2 [exit] :");
            String valueTwoInput = scanner.nextLine().trim();

            if (valueTwoInput.equals("exit")) {
                return -1;
            }

            if (!valueTwoInput.isEmpty()) {
                try {
                    return Integer.parseInt(valueTwoInput);
                } catch (NumberFormatException e) {
                    System.out.println("Use Valid Number, Try Again.");
                }
            } else {
                System.out.println("No Input, Try Again.");
            }
        }
    }
    // Function To Perform Calculation
    public static int calculate () {
        String operator = getOperator();

        if (operator == null) {
            System.out.println("Exit.");
            return 0;
        }

        int valOne = getValueOne();

        if (valOne == 0) {
            System.out.println("Exit.");
            return 0;
        }

        int valTwo = getValueTwo();

        if (valTwo == -1) {
            System.out.println("Exit.");
            return 0;
        }

        int result = 0;

        switch (operator) {
            case "add":
                result = addition(valOne, valTwo);
                break;
            case "sub":
                result = subtraction(valOne, valTwo);
                break;
            case "mul":
                result = multiplication(valOne, valTwo);
                break;
            case "div":
                if (valTwo == 0) {
                    System.out.println("Cannot Divide By Zero.");
                    return calculate();
                }
                result = division(valOne, valTwo);
                break;
            default:
                break;

        }

        return result;
    }
    public static void main(String[] args) {
        int calculator = calculate();
        System.out.println("Result : " + calculator);
    }
}