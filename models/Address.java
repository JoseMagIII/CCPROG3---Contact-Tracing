package models;

/**
 * This class serves as the user's address
 */
public class Address {
    
    private String street;
    private String city;
    private int postal;
    private String province;

    /**
     * Initializes address
     * @param s street
     * @param c city
     * @param pC postal code
     * @param p province
     */
    public Address(String s, String c, int pC, String p) {
        street = s;
        city = c;
        postal = pC;
        province = p;
    }

    /**
     * Initializes address with default values
     */
    public Address() {
        this("default", "default", 0, "default");
    }

    /**
     * Get street
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Get city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Get postal code
     * @return postal code
     */
    public int getPostalCode() {
        return postal;
    }

    /**
     * Get province
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Get address in string format
     * @return string format of class
     */
    public String toString() {
        return street + ", " + city + ", " + postal + " " + province;
    }

    /**
     * Get data from string to store in attributes
     * @param address string of address
     * @return address object
     */
    public static Address parse(String address) {
        String[] strings = address.split(",");

        String street = strings[0];
        String city = strings[1].substring(1);
     
        int i = strings[2].substring(1).indexOf(" ");
        int postal = Integer.parseInt(strings[2].substring(1, i + 1));
        String province = strings[2].substring(i + 2);

        return new Address(street, city, postal, province);
    }
}