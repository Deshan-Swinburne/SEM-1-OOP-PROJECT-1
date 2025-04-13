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
    private final ArrayList<Book> bookList;
    private final ArrayList<Member> memberList;

    /**
     * Constructor for objects of class Library
     */
    public Library() {
        // initialise instance variables
        bookList = new ArrayList<Book>();
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
        if (validateBookInput(isbn)) {
            Book newBook = new Book(isbn, title, author);
            bookList.add(newBook);
        }
    }

    /**
     * Find a book by isbn
     *
     * @param isbn given isbn
     * @return Book for the given ISBN
     */
    public Book findBookByISBN(String isbn) {
        if (!bookList.isEmpty() && !isbn.isEmpty()) {
            for (Book book : bookList) {
                if (compareISBNs(book.getISBN(), isbn)) {
                    return book;
                }
            }
        }
        return null;
    }

    /**
     * Show all books
     *
     * @return String of all the books which library has
     */
    public String showAllBooks() {
        String result = "";
        if (!bookList.isEmpty()) {
            for (Book book : bookList) {
                result += book.toString() + " \n";
            }
        }
        return result;
    }

    /**
     * Register new user to the library
     *
     * @param memberID   Member's ID
     * @param memberName Member's name
     * @throws IllegalArgumentException if Member's id is empty,invalid or duplicate
     */
    public void registerUser(String memberID, String memberName) throws IllegalArgumentException {
        if (validateMemberInput(memberID)) {
            Member member = new Member(memberID, memberName);
            memberList.add(member);
        }
    }

    /**
     * Utility method to validate Member ID
     *
     * @param memberID New Member's ID
     * @return boolean true if all the validations are okay,false if one validation fails
     * @throws IllegalArgumentException if Member's id is empty,invalid or duplicate
     */
    private boolean validateMemberInput(String memberID) throws IllegalArgumentException {
        boolean isValidationOkay = true;
        //1.Check for empty Member ID input
        if (!memberID.isEmpty()) {
            // 2. Regex to validate Member ID
            String memberIDRegex = "^M\\d{3}$";
            Pattern memberIDPattern = Pattern.compile(memberIDRegex);
            Matcher memberIDMatcher = memberIDPattern.matcher(memberID);

            if (memberIDMatcher.matches()) {
                // 3. Check whether a Member exists with the same ID
                if (!memberList.isEmpty()) {
                    for (Member member : memberList) {
                        if (member.getID().equals(memberID)) {
                            throw new IllegalArgumentException("Duplicate Member ID!!");
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Invalid Member ID!!");
            }
        } else {
            throw new IllegalArgumentException("Member ID is empty!!");
        }
        return isValidationOkay;
    }


    /**
     * Utility method to validate Book's ISBN
     *
     * @param isbn New book's isbn
     * @return boolean true if all the validations are okay,false if one validation fails
     * @throws IllegalArgumentException if ISBN is empty,invalid or duplicate
     */
    private boolean validateBookInput(String isbn) throws IllegalArgumentException {
        boolean isValidationOkay = true;

        // 1. Check for empty ISBN
        if (!isbn.isEmpty()) {
            // 2. Regex to validate 10 digit(Old ISBN) and 13 digit (New ISBN)
            String isbnRegex = "^(\\d{10}|\\d{13})$";
            Pattern isbnPattern = Pattern.compile(isbnRegex);
            Matcher isbnMatcher = isbnPattern.matcher(isbnWithoutDashes(isbn));

            if (isbnMatcher.matches()) {
                // 3. Check whether a Book exists with the same ISBN
                Book book = findBookByISBN(isbn);
                if (book != null) {
                    throw new IllegalArgumentException("Duplicate ISBN!!");
                }
            } else {
                throw new IllegalArgumentException("Invalid ISBN format!!");
            }
        } else {
            throw new IllegalArgumentException("ISBN is empty!!");
        }
        return isValidationOkay;
    }

    /**
     * Utility method to compare isbns
     *
     * @param firstISBN  book/query isbn
     * @param SecondISBN book/query isbn
     * @return boolean true if equals,false if it doesn't match
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