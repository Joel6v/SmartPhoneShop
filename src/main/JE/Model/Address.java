package Model;

import org.bson.Document;

public class Address { //extends Model
    private String street;
    private String zipCode;
    private String city;


    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address() {
        street = "";
        zipCode = "";
        city = "";
    }

    public Address (Document document){
        street = document.getString("street");
        zipCode = document.getString("zipCode");
        city = document.getString("city");
    }

    public Document toDocument() {
        return new Document("street", street).append("zipCode", zipCode).append("city", city);
    }

    @Override
    public String toString(){
        return "Strasse: " + street + "\nPLZ: " + zipCode + "\nStadt: " + city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
