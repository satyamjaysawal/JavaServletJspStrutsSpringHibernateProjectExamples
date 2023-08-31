package com.LibraryMPSystem;

public class Main {
    public static void main(String[] args) throws InvalidBookException {
        // Create books
        Book book1 = new Book("ISBN123", "Java Programming", "Robert Lafore");
        Book book2 = new Book("ISBN10", "Data Structures", "Gayle Laakmann");
        Book book3 = new Book("ISBN789", "Algorithms", "McDowell");
        Book book4 = new Book("ISBN789", "Algorithms", "McDowell");

        
        // ListLibrary 
        ListLibrary listLibrary = new ListLibrary();
        listLibrary.addBook(book1);
        listLibrary.addBook(book2);
        listLibrary.addBook(book3);
        System.out.println("\nBooks in List Library:");
        listLibrary.displayBooks();
        
        
        // SetLibrary 
        SetLibrary setLibrary = new SetLibrary();
        setLibrary.addBook(book1);
        setLibrary.addBook(book2);
        setLibrary.addBook(book3);
        setLibrary.addBook(book4);
        System.out.println("\nBooks in Set Library:");
        setLibrary.displayBooks();

       

        // MapLibrary 
        MapLibrary mapLibrary = new MapLibrary();
        mapLibrary.addBook(book1);
        mapLibrary.addBook(book2);
        mapLibrary.addBook(book3);
        System.out.println("\nBooks in Map Library:");
        mapLibrary.displayBooks();

        // HashMapLibrary 
        HashMapLibrary hashMapLibrary = new HashMapLibrary();
        try {
            hashMapLibrary.addBook(book1);
            hashMapLibrary.addBook(book2);
            hashMapLibrary.addBook(book3);
            hashMapLibrary.addBook(book3); // Duplicate book
            hashMapLibrary.addBook(book4); // Duplicate book
        } catch (InvalidBookException e) {
            System.out.println("\nException: " + e.getMessage());
        }
        System.out.println("\nBooks in HashMap Library:");
        hashMapLibrary.displayBooks();

        // TreeMapLibrary
        TreeMapLibrary treeMapLibrary = new TreeMapLibrary();
        treeMapLibrary.addBook(book1);
        treeMapLibrary.addBook(book2);
        treeMapLibrary.addBook(book3);
        System.out.println("\nBooks in TreeMap Library:");
        treeMapLibrary.displayBooksSorted();

        // StringManipulation 
        StringManipulation.stringExamples();

        // ExceptionHandling 
        ExceptionHandlingDemo.exceptionExamples();

        // Custom exception handling
        try {
            Book invalidBook = new Book("ISBN123", "Invalid Book", "Invalid Author");
            hashMapLibrary.addBook(invalidBook);
        } catch (InvalidBookException e) {
            System.out.println("\nException: " + e.getMessage());
        }
    }
}
