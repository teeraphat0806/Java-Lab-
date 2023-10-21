public class Address {
    protected String street;
    protected String city;
    public String getStreet(){
        return street;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getAddressInfo(){
        return "Street: "+street+" City: "+city+" ";
    }
}
