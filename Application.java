import java.util.Scanner;
/**
 * Application class is a representation of a serves as the Console (Text-Based) Interface
 * 
 * @author - Deshan Charuka Chandrasekara
 * @version - openjdk 22.0
 */
public class Application
{
    private static final Scanner inputReader = new Scanner(System.in);
    private static int userSelectedOption;
    
    public static void main(String args[]){
        do{
        System.out.println("Library Management System:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. List Books");
        System.out.println("4. Register Member");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Find Book");
        System.out.println("8. Exit");
        
        userSelectedOption = inputReader.nextInt();
        }while(userSelectedOption != 8);
    }
}
