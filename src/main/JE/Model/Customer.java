package Model;

import Controller.MainController;
import org.bson.Document;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private String salutation;
    private String lastName;
    private String firstName;
    private ArrayList<Address> addresses;
    private String phoneNumberPrivate;
    private String phoneNumberMobile;
    private String email;
    private LocalDate dateOfBirth;
    private String username;
    private byte[] password;

    public Customer(String salutation, String lastName, String firstName, ArrayList<Address> addresses,
                    String phoneNumberPrivate, String phoneNumberMobile, String email, LocalDate dateOfBirth,
                    String username, byte[] password) {
        this.salutation = salutation;
        this.lastName = lastName;
        this.firstName = firstName;
        this.addresses = addresses;
        this.phoneNumberPrivate = phoneNumberPrivate;
        this.phoneNumberMobile = phoneNumberMobile;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    public Customer(){

    }

    public Customer(Document document){
        salutation = document.getString("salutation");
        lastName = document.getString("lastName");
        firstName = document.getString("firstName");
        ArrayList<Integer> addressesId = (ArrayList<Integer>) document.get("addresses");
        addresses = MainController.address.getElement(addressesId);
        phoneNumberPrivate = document.getString("phoneNumberPrivate");
        phoneNumberMobile = document.getString("phoneNumberMobile");
        email = document.getString("email");
        setDateOfBirth(document.getString("dateOfBirth"));
        username = document.getString("username");
        setPasswordHex(document.getString("password"));
    }

    public Document toDocument() {
        return new Document("salutation", salutation).append("lastName", lastName).append("firstName", firstName)
                .append("addresses", MainController.address.getIndexElement(addresses)).append("phoneNumberPrivate", phoneNumberPrivate).append("phoneNumberMobile", phoneNumberMobile)
                .append("email", email).append("dateOfBirth", getDateOfBirthString()).append("username", username).append("password", getPasswordHex());
    }

    @Override
    public String toString(){
        return "Titel: " + salutation + "\nNachname: " + lastName + "\nVorname: " + firstName + "\nAdresse: " + getAddressesString() +
                "\nTelefon privat: " + phoneNumberPrivate + "\nTelefon mobil: " + phoneNumberMobile + "\nEmail: " + email + "\nGeburtsdatum: " +
                getDateOfBirthString() + "\nBenutzername: " + username + "\nPasswort: " + getPasswordHex();
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public String getAddressesString() {
        StringBuilder sb = new StringBuilder();
        for (Address address : addresses) {
            sb.append(address.toString()).append(", ");
        }
        return sb.toString();
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public void setAddressesIndices(ArrayList<Integer> indices) {
        addresses = MainController.address.getElement(indices);
    }

    public String getPhoneNumberPrivate() {
        return phoneNumberPrivate;
    }

    public void setPhoneNumberPrivate(String phoneNumberPrivate) {
        this.phoneNumberPrivate = phoneNumberPrivate;
    }

    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    public void setPhoneNumberMobile(String phoneNumberMobile) {
        this.phoneNumberMobile = phoneNumberMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfBirthString() {
        return LocalDateFormatter.convertToString(dateOfBirth);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirthString) {
        dateOfBirth = LocalDateFormatter.convertStringToDate(dateOfBirthString);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //256 bit = 32 byte

            md.update(password.getBytes());
            this.password = Arrays.copyOf(md.digest(), 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void setPasswordHex(String hex){
        for (int i = 0; i < 32; i++) {
            password[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
    }

    public String getPasswordHex() {
        StringBuilder hexString = new StringBuilder();
        for (byte b : password) {
            hexString.append(String.format("%02X", b)); //%02X -> 2 digits
        }
        return hexString.toString();
    }
}
