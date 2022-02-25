package com.nitin.user.Error;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String s) {
        super(s);
    }
}
