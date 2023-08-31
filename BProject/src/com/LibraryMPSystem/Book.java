package com.LibraryMPSystem;

public class Book extends LibraryItem {
    private String ISBN;           // ISBN=International Standard Book Number

    public Book(String ISBN, String title, String author) throws InvalidBookException {
        super(title, author);

        if (ISBN == null || ISBN.isEmpty()) {
            throw new InvalidBookException("Book name cannot be empty.");
        }

        this.ISBN = ISBN;
    }

    
    
    public String getISBN() {
		return ISBN;
	}

	

	public void setTitle(String title) {
        this.title = title;
    }
    
    public void setTitle(String title, String subtitle) {
        this.title = title + ": " + subtitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    @Override
    public String toString() {
        return "Book [ISBN: " + ISBN + ", Title: " + getTitle() + ", Author: " + getAuthor() + "]";
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call the parent's displayInfo() method
        System.out.println("Book Title: " + title + ", Book Author: " + author);
    }
}
