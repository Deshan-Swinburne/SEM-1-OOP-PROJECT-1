/**
 * Book class is a representation of a book entity which
 * contains attributes for the book's isbn, title,author and isAvailable
 * 
 * @author - Deshan Charuka Chandrasekara
 * @version - openjdk 22.0
 */

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    /**
     * Constructor for objects of class Book
     *
     * @param   isbn Book's ISBN Number(Unique)
     * @param   title Book's title
     * @param   author Author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        //When the book is created for the first time,Book is available
        isAvailable = true;

    }

    /**
     * Set isbn of a book
     *
     * @param isbn book's isbn
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Set title of a book
     * 
     * @param title book's title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set salary of a book
     * 
     * @param salary book's author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Set status of a book
     * 
     * @param isAvailable book's satuts
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Get isbn of a book
     * 
     * @return book's isbn
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Get title of a book
     * 
     * @return book's title
     */
    public String geTitle() {
        return title;
    }

    /**
     * Get author of a book
     * 
     * @return book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get author of a book
     * 
     * @return book's author
     */
    public boolean getIsAvailable() {
        return isAvailable;
    }    

    /**
     * Returns a string representation of the Book object.
     * 
     * @return A string containing the book's ISBN, Title, Author and Availability.
     */
    @Override
    public String toString() {
        return "ISBN:" + isbn + ", Title:" + title + ", Author:" + author + ", Availability:" +
            (isAvailable ? "Available" : "Borrowed");
    }

}