package Model;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Formatter;

public class Customer {
    private String salutation;
    private String lastName;
    private String firstName;
    private String street;
    private String zipCode;
    private String city;
    private String phoneNumberPrivate;
    private String phoneNumberMobile;
    private String email;
    private LocalDate dateOfBirth;
    private String username;
    private byte[] password;

    public Customer(String salutation, String lastName, String firstName, String street, String zipCode, String city,
                    String phoneNumberPrivate, String phoneNumberMobile, String email, LocalDate dateOfBirth,
                    String username, byte[] password) {
        this.salutation = salutation;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumberPrivate = phoneNumberPrivate;
        this.phoneNumberMobile = phoneNumberMobile;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString(){
        return salutation + " " + lastName + " " + firstName + ", " + street + ", " + zipCode + " " + city + ", " +
                phoneNumberPrivate + ", " + phoneNumberMobile + ", " + email + ", " + getDateOfBirthString() + ", " + username;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateOfBirth.format(formatter);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
