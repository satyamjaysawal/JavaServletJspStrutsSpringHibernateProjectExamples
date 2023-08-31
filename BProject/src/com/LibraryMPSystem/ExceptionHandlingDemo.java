package com.LibraryMPSystem;

public class ExceptionHandlingDemo {
    public static void exceptionExamples() {
        try {
            // ArithmeticException
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }

        try {
            // ArrayIndexOutOfBoundsException
            int[] arr = new int[5];
            arr[10] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        try {
            // NullPointerException
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }

        try {
            // CustomException
            throw new InvalidBookException("This is a custom exception.");
        } catch (InvalidBookException e) {
            System.out.println("CustomException caught: " + e.getMessage());
        }
    }
}

