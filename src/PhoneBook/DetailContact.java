package PhoneBook;
import java.util.ArrayList;

/**
 * Created by Мария on 19.06.2016.
 */
public class DetailContact extends Contact {
private String address;
private String workplace;

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
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress (){
        return address;
    }
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public String getWorkplace() {
        return workplace;
    }
}
