package PhoneBook;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/**
 * Created by Юрий on 11.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Телефонная книга.");
        DetailContact book = new DetailContact();
        ArrayList<DetailContact> contacts = new ArrayList<>();
        File inputFile = new File("contacts.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Comparator<Contact> compByNameAscending = (name1, name2) -> name1.getName().compareTo(name2.getName());
        Comparator<Contact> compByNameDescending = (name1, name2) -> name2.getName().compareTo(name1.getName());
        Comparator<Contact> compByEmailAscending = (email1, email2) -> email1.getEmail().compareTo(email2.getEmail());
        Comparator<Contact> compByEmailDescending = (email1, email2) -> email2.getEmail().compareTo(email1.getEmail());
        while (true) {
            try {
                System.out.println("Menu: \n 1. Добавить контакт \n 2. Показать все контакты \n 3. Выход \n 4. Удалить контакт \n 5. Настройкка сортировки контактов");
                String input = reader.readLine();
                if (input.equals("1")) {
                    try {
                        PrintWriter writer = new PrintWriter(new FileOutputStream(inputFile, true));
                        System.out.println("Введите имя: ");
                        book.setName(reader.readLine());
                        while (true) {
                            System.out.println("Введите  телефон или нажмите 'n' для выхода: ");
                            input = reader.readLine();
                            if (input.equals("n"))
                                break;
                            else
                                book.setPhone(input);
                        }
                        System.out.println("Введите email: ");
                        book.setEmail(reader.readLine());
                        System.out.println("Введите адрес: ");
                        book.setAddress(reader.readLine());
                        System.out.println("Введите место работы: ");
                        book.setWorkplace(reader.readLine());
                        contacts.add(book);
                        for (int i = 0; i < contacts.size(); i++) {
                            if (contacts.get(i).getPhone().size() == 1)
                            {
                                writer.println(contacts.get(i).getName() + ", " + contacts.get(i).getPhone() + ", " + contacts.get(i).getEmail() +
                                        ", " + contacts.get(i).getAddress() + ", " + contacts.get(i).getWorkplace());
                                writer.flush();
                            }
                            else {
                                writer.print("\n" + contacts.get(i).getName() + ", ");
                                writer.print(contacts.get(i).getEmail() + ", " + contacts.get(i).getAddress() + ", " + contacts.get(i).getWorkplace() + "\n");
                                writer.println("<--- phones --->");
                                for (int k = 0; k < contacts.get(i).getPhone().size(); k++) {
                                    writer.printf("%s \n", contacts.get(i).getPhone().get(k));
                                }
                                writer.printf("<<< %s's phones >>> \n", contacts.get(i).getName());
                                writer.println();
                                writer.flush();
                            }
                        }
                        writer.close();
                    }catch(IOException e){
                            e.printStackTrace();
                        }
                } else if (input.equals("2")) {
                    try {
                        BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
                        String line;
                        while ((line = readerFromFile.readLine()) != null) {
                            System.out.println(line);
                        }
                        readerFromFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
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
                    }else if (input.equals("3")) {
                        System.out.println("Выход из программы");
                        break;
                    } else if (input.equals("4")) {
                        if (contacts.size() == 0) {
                            System.out.println("Телефонная книга пустая.");
                            continue;
                        }
                        for (int j = 0; j < contacts.size(); j++) {
                            System.out.println(contacts.get(j).getName());
                        }
                        System.out.println("Введите имя из списка для удаления: ");
                        input = reader.readLine();
                        for (int j = 0; j < contacts.size(); j++) {
                            if (input.equals(contacts.get(j).getName())) {
                                contacts.remove(j);
                                break;
                            }
                        }
                    } else if (input.equals("5")) {
                        System.out.println("Введите \"ne\" для сортировки по имени, а при совпадении по email");
                        System.out.println("Введите \"en\" для сортировки по email, а при совпадении по имени");
                        System.out.println("Введите \"-ne\" для сортировки по имени в обратном порядке, а при совпадении по email");
                        System.out.println("Введите \"-en\" для сортировки по email в обратном порядке, а при совпадении по имени");
                        System.out.println("Введите \"n-e\" для сортировки по имени, а при совпадении по email в обратном порядке");
                        System.out.println("Введите \"e-n\" для сортировки по email, а при совпадении по имени в обратном порядке");
                        System.out.println("Введите \"-n-e\" для сортировки по имени в обратном порядке, а при совпадении по email в обратном порядке");
                        System.out.println("Введите \"-e-n\" для сортировки по email в обратном порядке, а при совпадении по имени в обратном порядке");

                        input = reader.readLine();
                        if (input.equals("ne")) {
                            Collections.sort(contacts, compByEmailAscending);
                            Collections.sort(contacts, compByNameAscending);
                        } else if (input.equals("en")) {
                            Collections.sort(contacts, compByNameAscending);
                            Collections.sort(contacts, compByEmailAscending);
                        } else if (input.equals("-ne")) {
                            Collections.sort(contacts, compByEmailAscending);
                            Collections.sort(contacts, compByNameDescending);
                        } else if (input.equals("-en")) {
                            Collections.sort(contacts, compByNameAscending);
                            Collections.sort(contacts, compByEmailDescending);
                        } else if (input.equals("n-e")) {
                            Collections.sort(contacts, compByEmailDescending);
                            Collections.sort(contacts, compByNameAscending);
                        } else if (input.equals("e-n")) {
                            Collections.sort(contacts, compByNameDescending);
                            Collections.sort(contacts, compByEmailAscending);
                        } else if (input.equals("-n-e")) {
                            Collections.sort(contacts, compByEmailDescending);
                            Collections.sort(contacts, compByNameDescending);
                        } else if (input.equals("-e-n")) {
                            Collections.sort(contacts, compByNameDescending);
                            Collections.sort(contacts, compByEmailDescending);
                        } else {
                            System.out.println("неверно введенная команда.");
                        }
                    } else {
                        System.out.println("Неверно введенная команда.");
                    }

            } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

