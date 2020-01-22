package com.myproject.jsonapp;

import android.os.Parcelable;

import java.io.Serializable;

//Class made to put the data of JSON object into Java Object
public  class Book  implements Serializable {
    public String name;
    public String author;
    public String price;

    public Book() {
    }

    Book(String name, String author, String price){
        this.name=name;
        this.author=author;
        this.price=price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
