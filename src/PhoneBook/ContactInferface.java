package PhoneBook;
import javax.swing.*;
import java.awt.*;

/**
 * Created by spbw0-rep6 on 19.07.2016.
 */
public class ContactInferface extends JFrame{
    private JLabel addContact;
    private JButton addName;
    public ContactInferface () {
        super("Телефонная книга");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addName = new JButton("1. Добавить контакт");
        addContact = new JLabel("Телефонная книга");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        add(addContact, BorderLayout.NORTH);
        buttonsPanel.add(addName);
        add(buttonsPanel, BorderLayout.SOUTH);

    }


}
