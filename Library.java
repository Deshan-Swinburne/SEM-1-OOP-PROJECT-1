import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.IllegalArgumentException;

/**
 * Library class is  responsible for maintaining a collection of books
 * and a list of registered members
 *
 * @author - Deshan Charuka Chandrasekara
 * @version - openjdk 22.0
 */
public class Library {
    // instance variables
    private final ArrayList<Book> booklist;
    private final ArrayList<Member> memberList;

    /**
     * Constructor for objects of class Library
     */
    public Library() {
        // initialise instance variables
        booklist = new ArrayList<Book>();
        memberList = new ArrayList<Member>();
    }

    /**
     * addBook method to add book to the library
     *
     * @param isbn   New book's isbn
     * @param title  New book's title
     * @param author New book's author
     * @throws IllegalArgumentException if ISBN is empty,invalid or duplicate
     */
    public void addBook(String isbn, String title, String author) throws IllegalArgumentException {
        // 1. validation of isbn

        // 1.1 Chechk for empty ISBN
        if (!isbn.isEmpty()) {
            // 1.2 Regex to validate 10 digit(Old ISBN) and 13 digit (New ISBN)
            String isbnRegex = "^(\\d{10}|\\d{13})$";
            Pattern isbnPattern = Pattern.compile(isbnRegex);
            Matcher matcher = isbnPattern.matcher(isbnWithoutDashes(isbn));

            if (matcher.matches()) {
                // 1.3 Check whether a Book exists with the same ISBN
                Book book = findBookByISBN(isbn);
                if (book == null) {
                    Book newBook = new Book(isbn, title, author);
                    booklist.add(newBook);
                } else {
                    throw new IllegalArgumentException("Duplicate ISBN!!");
                }
            } else {
                throw new IllegalArgumentException("Invalid ISBN format!!");
            }


        } else {
            throw new IllegalArgumentException("ISBN is empty!!");
        }
    }

    /**
     * Find a book by isbn
     *
     * @param isbn given isbn
     * @return Book for the given ISBN
     */
    public Book findBookByISBN(String isbn) {
        if (!booklist.isEmpty() && !isbn.isEmpty()) {
            for (Book book : booklist) {
                if (compareISBNs(book.getISBN(), isbn)) {
                    return book;
                }
            }
        }
        return null;
    }

    /**
     * Utility method to compare isbns
     *
     * @param firstISBN  book/query isbn
     * @param SecondISBN book/query isbn
     * @return boolean true if equals,false if doesn't match
     */
    public boolean compareISBNs(String firstISBN, String SecondISBN) {
        String rawFirstISBN = isbnWithoutDashes(firstISBN);
        String rawSecondISBN = isbnWithoutDashes(SecondISBN);
        return rawFirstISBN.equals(rawSecondISBN);
    }

    /**
     * Utility method to get isbn without dashes
     *
     * @param isbn book's/query's isbn
     * @return isbn String without dashes
     */
    public String isbnWithoutDashes(String isbn) {
        if (isbn.contains("-")) {
            return isbn.replaceAll("-", "");
        } else {
            return isbn;
        }
    }
}