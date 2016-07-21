package PhoneBook;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Юрий on 11.06.2016.
 */
public class Contact extends JFrame {
    protected ArrayList <String> phone = new ArrayList <>();
    protected String name;
    protected String email;

    public Contact(String s){
        super(s);
    }
    public void setName (String name){
        this.name=name;
    }
    public String getName (){
        return name;
    }
    public void setPhone(String phone) {

        this.phone.add(phone);

    }
    public ArrayList <String> getPhone(){
        return phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail (){
        return email;
    }
    public boolean equals (Object another){
        Contact contact = (Contact) another;
        return this.name.equals(contact.name);
    }
}