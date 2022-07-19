package com.example.clientgetdatasharepreferences;


public class Data{
    private String userName;
    private String email;
    private String address;
    private String accountPayment;

    public Data() {
    }

    public Data(String userName, String email, String address, String accountPayment) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.accountPayment = accountPayment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountPayment() {
        return accountPayment;
    }

    public void setAccountPayment(String accountPayment) {
        this.accountPayment = accountPayment;
    }

    @Override
    public String toString() {
        return "Data{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", accountPayment='" + accountPayment + '\'' +
                '}';
    }
}
