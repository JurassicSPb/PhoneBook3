package PhoneBook;
import java.util.*;

/**
 * Created by Юрий on 11.06.2016.
 */
public class Main {
    public static void main (String [] args) {
        System.out.println("Телефонная книга.");
        Scanner sc = new Scanner(System.in);
        Comparator <Contact> compByNameAscending = (name1, name2) -> name1.getName().compareTo(name2.getName());
        Comparator <Contact> compByNameDescending = (name1, name2) -> name2.getName().compareTo(name1.getName());
        Comparator <Contact> compByEmailAscending = (email1, email2) -> email1.getEmail().compareTo(email2.getEmail());
        Comparator <Contact> compByEmailDescending = (email1, email2) -> email2.getEmail().compareTo(email1.getEmail());
        ArrayList<DetailContact> list = new ArrayList<>();
        while (true) {
            System.out.println("Menu: \n 1. Добавить контакт \n 2. Показать все контакты \n 3. Выход \n 4. Удалить контакт \n 5. Настройкка сортировки контактов" );
            int choice = sc.nextInt();
            if (choice == 1) {
                DetailContact book = new DetailContact();
                System.out.println("Введите имя: ");
                book.setName(sc.next());
                while (true) {
                    System.out.println("Введите  телефон или нажмите 'n' для выхода: ");
                    String str = sc.next();
                    if (str.equals("n"))
                        break;
                    else
                        book.setPhone(str);
                }
                System.out.println("Введите email: ");
                book.setEmail(sc.next());
                System.out.println("Введите адрес: ");
                book.setAddress(sc.next());
                System.out.println("Введите место работы: ");
                book.setWorkplace(sc.next());
                list.add(book);
            } else if (choice == 2) {
                if (list.size() == 0) {
                    System.out.println("Телефонная книга пустая.");
                    continue;
                }
//                for (int k = 0; k < list.size() - 1; k++) {
//                    for (int j = 0; j < list.size() - 1 - k; j++) {
//                        char left = list.get(j).getName().toCharArray()[0];
//                        char right = list.get(j + 1).getName().toCharArray()[0];
//                        if (left > right) {
//                            DetailContact temp = list.get(j);
//                            list.set(j, list.get(j + 1));
//                            list.set((j + 1), temp);
//                        }
//                    }
//                }
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getPhone().size() == 1) {
                        System.out.println(list.get(j).getName() + ", " + list.get(j).getPhone() + ", " + list.get(j).getEmail() +
                                ", " + list.get(j).getAddress() + " " + list.get(j).getWorkplace() + "\n");
                    }
                    else {
                        System.out.print("\n" + list.get(j).getName() + ", ");
                        System.out.print(list.get(j).getEmail() + ", " + list.get(j).getAddress() + ", " + list.get(j).getWorkplace() + "\n");
                        System.out.println("<--- phones --->");
                        for (int k = 0; k < list.get(j).getPhone().size(); k++) {
                            System.out.printf("%s \n", list.get(j).getPhone().get(k));
                        }
                        System.out.printf("<<< %s's phones >>> \n", list.get(j).getName());
                        System.out.println();
                    }
                }
            }
                else if (choice == 3) {
                    System.out.println("Выход из программы");
                    break;
                }
                else if (choice == 4) {
                    if (list.size() == 0) {
                        System.out.println("Телефонная книга пустая.");
                        continue;
                    }
                    for (int j = 0; j < list.size(); j++) {
                        System.out.println(list.get(j).getName());
                    }
                    System.out.println("Введите имя из списка для удаления: ");
                    String str = sc.next();
                    for (int j = 0; j < list.size(); j++) {
                        if (str.equals(list.get(j).getName())) {
                            list.remove(j);
                            break;
                        }
                    }
                }
            else if (choice  == 5)
            {
                System.out.println ("Введите \"ne\" для сортировки по имени, а при совпадении по email");
                System.out.println ("Введите \"en\" для сортировки по email, а при совпадении по имени");
                System.out.println ("Введите \"-ne\" для сортировки по имени в обратном порядке, а при совпадении по email");
                System.out.println ("Введите \"-en\" для сортировки по email в обратном порядке, а при совпадении по имени");
                System.out.println ("Введите \"n-e\" для сортировки по имени, а при совпадении по email в обратном порядке");
                System.out.println ("Введите \"e-n\" для сортировки по email, а при совпадении по имени в обратном порядке");
                System.out.println ("Введите \"-n-e\" для сортировки по имени в обратном порядке, а при совпадении по email в обратном порядке");
                System.out.println ("Введите \"-e-n\" для сортировки по email в обратном порядке, а при совпадении по имени в обратном порядке");

                String str = sc.next();
                if (str.equals("ne"))
                {
                    Collections.sort(list, compByEmailAscending);
                    Collections.sort(list, compByNameAscending);
                }
                else if (str.equals("en"))
                {
                    Collections.sort(list, compByNameAscending);
                    Collections.sort(list, compByEmailAscending);
                }
                else if (str.equals("-ne"))
                {
                    Collections.sort(list, compByEmailAscending);
                    Collections.sort(list, compByNameDescending);
                }
                else if (str.equals("-en"))
                {
                    Collections.sort(list, compByNameAscending);
                    Collections.sort(list, compByEmailDescending);
                }
                else if (str.equals("n-e"))
                {
                    Collections.sort(list, compByEmailDescending);
                    Collections.sort(list, compByNameAscending);
                }
                else if (str.equals("e-n"))
                {
                    Collections.sort(list, compByNameDescending);
                    Collections.sort(list, compByEmailAscending);
                }
                else if (str.equals("-n-e"))
                {
                    Collections.sort(list, compByEmailDescending);
                    Collections.sort(list, compByNameDescending);
                }
                else if (str.equals("-e-n"))
                {
                    Collections.sort(list, compByNameDescending);
                    Collections.sort(list, compByEmailDescending);
                }
                else
                {
                    System.out.println("неверно введенная команда.");
                }
            }
            else
            {
                System.out.println("Неверно введенная команда.");
            }
        }
    }
}
