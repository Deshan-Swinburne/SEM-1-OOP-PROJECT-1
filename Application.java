import java.util.Scanner;

/**
 * Application class is a representation of a serves as the Console (Text-Based) Interface.
 * Also handles the User's input out interactions.
 *
 * @author - Deshan Charuka Chandrasekara
 * @version - openjdk 22.0
 */
public class Application {
    private static final Scanner inputReader = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        //Instance Variables
        int userSelectedOption;

        // this loop will run until user input 8
        do {
            System.out.println("Library Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List Books");
            System.out.println("4. Register Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Find Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            userSelectedOption = inputReader.nextInt();

            //Based on user inputs wil call relevant method
            switch (userSelectedOption) {
                case 1:
                    initiateAddBookProcess();
                    break;
                case 2:
                    break;
                case 3:
                    initiateShowAllBookProcess();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    initiateFindBookProcess();
                    break;
                case 8:
                    System.out.println("Program end!");
                    break;
                default:
                    System.out.println("Wrong option selected.");
                    System.out.println("Please select a correct option!!");
            }
        } while (userSelectedOption != 8);
    }

    /**
     * Start the process of adding a book to the library system.
     */
    public static void initiateAddBookProcess() {
        inputReader.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = inputReader.nextLine();
        System.out.print("Enter Title: ");
        String title = inputReader.nextLine();
        System.out.print("Enter Author: ");
        String author = inputReader.nextLine();

        try {
            library.addBook(isbn, title, author);
            System.out.println("Book added successfully!! \n");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Start the process of finding a book from the library system,according to the given ISBN
     */
    public static void initiateFindBookProcess() {
        inputReader.nextLine();
        System.out.print("Enter ISBN of the Book: ");
        String isbn = inputReader.nextLine();
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println(book.toString() + " \n");
        } else {
            System.out.println("Error: Can't find a book for given ISBN!!");
        }
    }

    /**
     * Start the process of show all books of the library system
     */
    public static void initiateShowAllBookProcess() {
        String output = library.showAllBooks();
        System.out.println(output);
    }
}