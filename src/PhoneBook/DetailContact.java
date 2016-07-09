package PhoneBook;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.Serializable;
/**
 * Created by Юрий on 11.06.2016.
 */
public class DetailContact extends Contact implements Comparable<DetailContact> {
    private String address;
    private String workplace;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getWorkplace() {
        return workplace;
    }

    @Override
    public int compareTo(DetailContact o) {
        return this.getName().compareTo(o.getName());
    }

}