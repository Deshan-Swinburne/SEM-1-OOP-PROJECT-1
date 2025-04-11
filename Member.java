import java.util.ArrayList;

/**
 * Member class is a representation of a member entity which
 * contains attributes for the member's id, name and borrowed book list
 * 
 * @author - Deshan Charuka Chandrasekara
 * @version - openjdk 22.0
 */

public class Member {
    private String id;
    private String name;
    private ArrayList<Book> bookList;


    /**
     * Constructor for objects of class Member
     *
     * @param   id Member's ID Number(Unique)
     * @param   name Member's name
     */
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        bookList = new ArrayList<Book>();

    }

    /**
     * Set id of a member
     *
     * @param id member's id
     */
    public void setMemberID(String id) {
        this.id = id;
    }

    /**
     * Set name of a member
     * 
     * @param name member's name
     */
    public void setTitle(String name) {
        this.name = name;
    }

    /**
     * Add a book to a member
     * 
     * @param book member's borrowed book
     */
    public void addBook(Book book) {
        bookList.add(book);
    }

    /**
     * Get id of a member
     * 
     * @return member's id
     */
    public String getID() {
        return id;
    }

    /**
     * Get name of a member
     * 
     * @return member's name
     */
    public String geName() {
        return name;
    }


    /**
     * Get borrowed book list of a member
     * 
     * @return Borrowed Book list
     */
    public ArrayList<Book> getBookList() {
        return bookList;
    }    

    /**
     * Returns a string representation of the Member object.
     * 
     * @return A string containing the member's ID and Name.
     */
    @Override
    public String toString() {
        return "ID:" + id + ", Name:" + name;
    }

}