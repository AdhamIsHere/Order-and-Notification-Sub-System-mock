package com.example.SDA_2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    String name, userName, password , channelType ,lang ;
    float balance;

    public Customer(String name, String userName, String password, float balance , String lang , String channelType) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.lang = lang;
        this.channelType = channelType ;
    }

    public Customer() {

    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }


    public void setChannelType(String lang) {
        this.channelType = channelType;
    }

    public String getChannelType() {
        return channelType;
    }


    public boolean deductFees(float fee) {
        if (fee > balance) {
            return false;
        }
        balance = balance - fee;
        return true;
    }
    public void addFees(float f){
        balance+=f;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
