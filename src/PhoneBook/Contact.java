package PhoneBook;

import java.util.ArrayList;

/**
 * Created by Мария on 19.06.2016.
 */
public class Contact {
    protected ArrayList <String> phone = new ArrayList <>();
    protected String name;
    protected String email;

    public boolean equals (Object another){
        Contact contact = (Contact) another;
        return this.name.equals(contact.name);
    }
}