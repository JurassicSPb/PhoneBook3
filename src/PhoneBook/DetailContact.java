package PhoneBook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.Serializable;
/**
 * Created by Юрий on 11.06.2016.
 */
public class DetailContact extends Contact implements Comparable<DetailContact> {
    private String address;
    private String workplace;
    private JButton b1, b2, b3, b4, b5;
    private JLabel l1;
    private int count=0;

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

    public void getInfo (String line){
        String[] information = line.split(", ");
        String name = information[0];
        String phone = information[1];
        String email = information[2];
        String address = information[3];
        String workplace = information[4];
        System.out.print(name + ", " + phone + ", " + email + ", " + address + ", " + workplace + "\n");
    }
    public DetailContact () {
        super ("Телефонная книга");
        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add (l1 = new JLabel("Меню"), BorderLayout.NORTH);
        c.add (b1 = new JButton("Добавить контакт"), BorderLayout.CENTER);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    count =+ 1;
                    updateText();
                }
        });
}
        public void updateText(){
            l1.setText(" " + count);
        }

}


