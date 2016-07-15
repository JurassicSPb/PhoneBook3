package PhoneBook;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/**
 * Created by Юрий on 11.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Телефонная книга.");
            DetailContact book = new DetailContact();
            ArrayList<DetailContact> contacts = new ArrayList<>();
            File inputFile = new File("contacts.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            Comparator<Contact> compByNameAscending = (name1, name2) -> name1.getName().compareTo(name2.getName());
            Comparator<Contact> compByNameDescending = (name1, name2) -> name2.getName().compareTo(name1.getName());
            Comparator<Contact> compByEmailAscending = (email1, email2) -> email1.getEmail().compareTo(email2.getEmail());
            Comparator<Contact> compByEmailDescending = (email1, email2) -> email2.getEmail().compareTo(email1.getEmail());
            while (true) {
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
                          if (contacts.get(i).getPhone().size() == 1) {
                              writer.print(contacts.get(i).getName() + " ," + contacts.get(i).getPhone() + ", " + contacts.get(i).getEmail() + " ," + contacts.get(i).getAddress() + " ," + contacts.get(i).getWorkplace() + "\n");
                              writer.flush();
                              contacts.get(i).getPhone().clear();
                            }
                            else {
                               writer.print(contacts.get(i).getName() + " ,");
                               for (int k = 0; k < contacts.get(i).getPhone().size(); k++) {
                                   writer.print(contacts.get(i).getPhone().get(k) + " ");
                                }
                               writer.print(" ," + contacts.get(i).getEmail() + " ," + contacts.get(i).getAddress() + " ," + contacts.get(i).getWorkplace());
                                //writer.println("<--- phones --->");
                                //writer.printf("<<< %s's phones >>> \n", contacts.get(i).getName());
                               writer.println();
                               writer.flush();
                                contacts.get(i).getPhone().clear();
                            }
                       }
                       contacts.clear();
                      writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (input.equals("2")) {
                    try {
                        BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
                        while ((line = readerFromFile.readLine()) != null) {
                            String[] information = line.split(" ,");
                            String name = information[0];
                            String phone = information[1];
                            String email = information[2];
                            String address = information[3];
                            String workplace = information[4];
                            System.out.print(name + " ," + phone + " ," + email + " ," + address + " ," + workplace + "\n");
                        }
                        readerFromFile.close();
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println ("Список контактов пустой");
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
                } else if (input.equals("3")) {
                    System.out.println("Выход из программы");
                    break;
                } else if (input.equals("4")) {
                    try {
                        BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
                        while ((line = readerFromFile.readLine()) != null) {
                            String[] information = line.split(" ,");
                            book = new DetailContact();
                            String name = information[0];
                            String phone = information[1];
                            String email = information[2];
                            String address = information[3];
                            String workplace = information[4];
                            book.setName(name);
                            book.setPhone(phone);
                            book.setEmail(email);
                            book.setAddress(address);
                            book.setWorkplace(workplace);
                            contacts.add(book);
                            System.out.println(name + " ");
                        }
                        readerFromFile.close();
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println ("Список контактов пустой");
                        continue;
                    }
                    System.out.println("Введите имя из списка для удаления: ");
                    input = reader.readLine();
                    for (int i = 0; i < contacts.size(); i++) {
                        if (input.equals(contacts.get(i).getName())) {
                            contacts.remove(i);
                        }
                    }
                        PrintWriter writer = new PrintWriter(new FileOutputStream(inputFile));
                        for (int i = 0; i < contacts.size(); i++) {
                            writer.print(contacts.get(i).getName() + " ," + contacts.get(i).getPhone() + " ," +
                                    contacts.get(i).getEmail() + " ," + contacts.get(i).getAddress() + " ," + contacts.get(i).getWorkplace() + "\n");
                            writer.flush();
                        }
                    writer.close();
                } else if (input.equals("5")) {
                    BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
                    while ((line = readerFromFile.readLine()) != null) {
                        String[] information = line.split(" ,");
                        book = new DetailContact();
                        String name = information[0];
                        String phone = information[1];
                        String email = information[2];
                        String address = information[3];
                        String workplace = information[4];
                        book.setName(name);
                        book.setPhone(phone);
                        book.setEmail(email);
                        book.setAddress(address);
                        book.setWorkplace(workplace);
                        contacts.add(book);
                        }
                        readerFromFile.close();
                        System.out.println("Введите \"ne\" для сортировки по имени, а при совпадении по email");
                        System.out.println("Введите \"en\" для сортировки по email, а при совпадении по имени");
                        System.out.println("Введите \"-ne\" для сортировки по имени в обратном порядке, а при совпадении по email");
                        System.out.println("Введите \"-en\" для сортировки по email в обратном порядке, а при совпадении по имени");
                        System.out.println("Введите \"n-e\" для сортировки по имени, а при совпадении по email в обратном порядке");
                        System.out.println("Введите \"e-n\" для сортировки по email, а при совпадении по имени в обратном порядке");
                        System.out.println("Введите \"-n-e\" для сортировки по имени в обратном порядке, а при совпадении по email в обратном порядке");
                        System.out.println("Введите \"-e-n\" для сортировки по email в обратном порядке, а при совпадении по имени в обратном порядке");
                        String [] sortArray = new String[] {"n", "e", "-n", "-e" };

//                        input = reader.readLine();
//                        if (input.equals("ne")) {
//                            Collections.sort(contacts, compByEmailAscending);
//                            Collections.sort(contacts, compByNameAscending);
//                        } else if (input.equals("en")) {
//                            Collections.sort(contacts, compByNameAscending);
//                            Collections.sort(contacts, compByEmailAscending);
//                        } else if (input.equals("-ne")) {
//                            Collections.sort(contacts, compByEmailAscending);
//                            Collections.sort(contacts, compByNameDescending);
//                        } else if (input.equals("-en")) {
//                            Collections.sort(contacts, compByNameAscending);
//                            Collections.sort(contacts, compByEmailDescending);
//                        } else if (input.equals("n-e")) {
//                            Collections.sort(contacts, compByEmailDescending);
//                            Collections.sort(contacts, compByNameAscending);
//                        } else if (input.equals("e-n")) {
//                            Collections.sort(contacts, compByNameDescending);
//                            Collections.sort(contacts, compByEmailAscending);
//                        } else if (input.equals("-n-e")) {
//                            Collections.sort(contacts, compByEmailDescending);
//                            Collections.sort(contacts, compByNameDescending);
//                        } else if (input.equals("-e-n")) {
//                            Collections.sort(contacts, compByNameDescending);
//                            Collections.sort(contacts, compByEmailDescending);
//                        }
//                        else {
//                            System.out.println("неверно введенная команда.");
//                        }
                } else {
                    System.out.println("Неверно введенная команда.");
                }
            }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }

