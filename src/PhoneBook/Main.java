package PhoneBook;
import java.util.*;

/**
 * Created by Юрий on 11.06.2016.
 */
public class Main {
    public static void main (String [] args) {
        System.out.println("Телефонная книга.");
        Scanner sc = new Scanner(System.in);
        Comparator <DetailContact> compByNameAscending = (name1, name2) ->
        {return  name1.getName().compareTo(name2.getName());
        };
        Comparator <DetailContact> compByNameDescending = (name1, name2) ->
        {return  name2.getName().compareTo(name1.getName());
        };
        Comparator <DetailContact> compByEmailAscending = (email1, email2) ->
        {return  email1.getEmail().compareTo(email2.getEmail());
        };
        Comparator <DetailContact> compByEmailDescending = (email1, email2) ->
        {return  email2.getEmail().compareTo(email1.getEmail());
        };
        ArrayList<DetailContact> list = new ArrayList<>();
        while (true) {
            System.out.println("Menu: \n 1. Добавить контакт \n 2. Показать все контакты \n 3. Выход \n 4. Удалить контакт \n Нажмите 'ne' для сортировки по имени и email" );
            String choice = sc.next();
            if (choice.equals("1")) {
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
            } else if (choice.equals("2")) {
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
                Collections.sort(list);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getPhone().size() == 1) {
                        System.out.println(list.get(j).getName() + ", " + list.get(j).getPhone() + ", " + list.get(j).getEmail() +
                                ", " + list.get(j).getAddress() + " " + list.get(j).getWorkplace());
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
                else if (choice.equals("3")) {
                    System.out.println("Выход из программы");
                    break;
                }
                else if (choice.equals("4")) {
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
            else if (choice.equals("ne"))
            {
                Collections.sort(list, compByEmailAscending);
                Collections.sort(list, compByNameAscending);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).getName() + " " + list.get(i).getEmail());
                }
            }
            else
            {
                System.out.println("Неверно введенная команда: ");
            }
        }
    }
}
