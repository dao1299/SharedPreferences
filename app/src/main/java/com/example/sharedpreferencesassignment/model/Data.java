package com.example.sharedpreferencesassignment.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.example.sharedpreferencesassignment.BR;

public class Data extends BaseObservable {
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

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);

    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public String getAccountPayment() {
        return accountPayment;
    }

    public void setAccountPayment(String accountPayment) {
        this.accountPayment = accountPayment;
        notifyPropertyChanged(BR.accountPayment);
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
