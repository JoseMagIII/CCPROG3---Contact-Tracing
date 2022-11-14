package models;

/**
 * This class serves as the user's contact information
 */
public class ContactInfo {
    
    private String name;
    private Address home;
    private Address office;
    private String email;
    private long phoneNo;

    /**
     * Initializes the attributes with the given parameters.
     * @param n the name
     * @param h the home address
     * @param o the office address
     * @param e the email address
     * @param pN the phone number
     */
    public ContactInfo(String n, Address h, Address o, String e, long pN) {
        name = n;
        home = h;
        office = o;
        email = e;
        phoneNo = pN;
    }

    /**
     * Initializes the attributes with default values.
     */
    public ContactInfo() {
        this("default,default,default", new Address(), new Address(), "default", 0);
    }

    /**
     * Gets the user's full name.
     * @return the user's full name
     */
    public String getName() {
        return name;
    }

    /**
     * Get user's first name
     * @return first name
     */
    public String getFirstName() {
        String[] split = name.split(",");

        return split[0];
    }

    /**
     * Get the user's middle name
     * @return middle name
     */
    public String getMiddleName() {
        String[] split = name.split(",");

        return split[1];
    }

    /**
     * Get the user's last name
     * @return last name
     */
    public String getLastName() {
        String[] split = name.split(",");

        return split[2];
    }

    /**
     * Gets the user's phone number.
     * @return the user's phone number
     */
    public long getPhoneNo() {
        return phoneNo;
    }

    /**
     * Gets the user's email address.
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets home address
     * @return home address
     */
    public Address getHomeAddress() {
        return home;
    }


    /**
     * Gets office address
     * @return office address
     */
    public Address getOfficeAddress() {
        return office;
    }

    /**
     * Sets name
     * @param n name
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Sets home address
     * @param address home address
     */
    public void setHomeAddress(Address address) {
        home = address;
    }

    /**
     * Sets office address
     * @param address office address
     */
    public void setOfficeAddress(Address address) {
        office = address;
    }

    /**
     * Set phone number
     * @param n phone number
     */
    public void setPhoneNo(long n) {
        phoneNo = n;
    }

    /**
     * Set email address
     * @param e email address
     */
    public void setEmail(String e) {
        email = e;
    }

    /**
     * Checks if user has initialized their contact information.
     * @return true if has initialized, false if otherwise
     */
    public boolean isInitialized() {
        if (!name.equals("default, default, default") &&
            !home.toString().equals(new Address().toString()) &&
            !office.toString().equals(new Address().toString()) &&
            !email.equals("default") &&
            phoneNo != 0) {
            return true;
        }
    
        return false;
    }
}