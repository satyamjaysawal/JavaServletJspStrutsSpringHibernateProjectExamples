package com.LibraryMPSystem;

public class StringManipulation {
    public static void stringExamples() {
        // Using String
        String str = "Hello";
        
        System.out.println("Original String: " + str);
        str = str.concat(" World"); 
        System.out.println("Concatenated: " + str);
        System.out.println("Length: " + str.length());

        // Using StringBuffer
        StringBuffer stringBuffer = new StringBuffer("Hello");
        
        System.out.println("Original String: " + stringBuffer);
        stringBuffer.append(" World");
        System.out.println("Appended: " + stringBuffer);
        stringBuffer.insert(5, " Java"); // Inserting at index
        System.out.println("Inserted: " + stringBuffer);
        System.out.println("Reversed: " + stringBuffer.reverse());

        // Using StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello");
       
        System.out.println("Original String: " + stringBuilder);
        stringBuilder.append(" World"); 
        System.out.println("Appended: " + stringBuilder);
        stringBuilder.replace(6, 11, "Java"); // Replacing substring
        System.out.println("Replaced: " + stringBuilder);
        System.out.println("Substring: " + stringBuilder.substring(6, 10));

        // Searching for an exact string
       
        boolean strSearch = stringBuilder.toString().contains("Hello");
        if (strSearch) {
            System.out.println("Found 'Hello' in the string.");
        } else {
            System.out.println("No 'Hello' found in the string.");
        }

        // HashCode and .equals()
        String str1 = "Hello";
        String str2 = new String("Hello");

        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1.hashCode(): " + str1.hashCode());
        System.out.println("str2.hashCode(): " + str2.hashCode());
        System.out.println("str1.equals(str2): " + str1.equals(str2));
    }
}
