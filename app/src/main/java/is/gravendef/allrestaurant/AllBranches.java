package is.gravendef.allrestaurant;

public class AllBranches {

    // variables for our address, phone and activity time of branch
    private static String city;
    private static String address; // include street & num
    private static String phone;
    private static String openIn;

    public void setCity(String city) {this.city = city;}
    public void setAddress(String address) {this.address = address;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setOpenIn(String openIn) {this.openIn = openIn;}

    public static String getCity() { return city; }
    public static String getAddress(){ return address; }
    public static String getPhone(){ return phone; }
    public static String getOpenIn(){ return openIn; }



    // constructor
    public AllBranches(String city,String street,String phone, String openIn ){
        this.city = city;
        this.address = street;
        this.phone = phone;
        this.openIn = openIn;
    }
}
