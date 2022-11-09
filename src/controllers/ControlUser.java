package controllers;

import models.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {
    private ArrayList<User> listaUsers = new ArrayList<>();

    public ControlUser() {

        loadStudent();
    }

    public void loadStudent() {

        try {
            File file = new File("C:\\mycode\\oop\\incapsualrea\\proiectScoala\\src\\data\\users.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                User user = new User(text);
                listaUsers.add(user);
            }
            System.out.println("Studentii au fost incarcati !");
        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }

    public void afisare() {

        for (User listaUser : listaUsers) {
            System.out.println(" ");
            System.out.println(listaUser.descriere());
            System.out.println(" ");
        }
    }


    //todo functie ce returneaza un user dupa paorla si email

    public User usernameSiParola(String username, String parola) {
        for (User user : listaUsers) {
            if (user.getEmail().equals(username) && user.getPassword().equals(parola)) {

                return user;
            }

        }
        return null;
    }

    public void creareUser() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Introduceti un nume");
        String firstName = scanner.nextLine();
        user.setFirstName(firstName);

        System.out.println("Introduceti un prenume");
        String lastName = scanner.nextLine();
        user.setLastName(lastName);

        System.out.println("Introduceti un email");
        String email = scanner.nextLine();
        user.setEmail(email);

        System.out.println("Introduceti o parola");
        String password = scanner.nextLine();
        user.setPassword(password);

        System.out.println("Introduceti varsta");
        int age = Integer.parseInt(scanner.nextLine());
        user.setAge(age);

        System.out.println("Introduceti tipul de user");
        String type = scanner.nextLine();
        user.setType(type);

        this.listaUsers.add(user);

        System.out.println("");
        System.out.println("User adaugat !");
        System.out.println("");

    }

}
