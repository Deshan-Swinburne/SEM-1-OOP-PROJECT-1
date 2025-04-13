import java.util.ArrayList;

/**
 * Member class is a representation of a member entity which
 * contains attributes for the member's id, name
 *
 * @author - Deshan Charuka Chandrasekara
 * @version - openjdk 22.0
 */
public class Member {
    // instance variables
    private String id;
    private String name;
    private ArrayList<String> borrowedBooksISBNList;


    /**
     * Constructor for objects of the Member class
     *
     * @param id   Member's ID Number(Unique)
     * @param name Member's name
     */
    public Member(String id, String name) {
        // initialise instance variables
        this.id = id;
        this.name = name;
        borrowedBooksISBNList = new ArrayList<String>();
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
     * Returns a string representation of the Member object.
     *
     * @return A string containing the member's ID and Name.
     */
    @Override
    public String toString() {
        return "ID:" + id + ", Name:" + name;
    }

}