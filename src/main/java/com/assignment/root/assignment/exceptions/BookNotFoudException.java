package com.assignment.root.assignment.exceptions;

public class BookNotFoudException extends RuntimeException{

    public BookNotFoudException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}
