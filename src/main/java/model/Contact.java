package model;

import java.io.Serializable;

public class Contact extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Contact(String name, String phoneNumber) {
        super(name, phoneNumber);
    }
}

