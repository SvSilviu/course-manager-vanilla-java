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

        for (int i = 0; i < listaUsers.size(); i++) {
            System.out.println(" ");
            System.out.println(listaUsers.get(i).descriere());
            System.out.println(" ");
        }
    }


}
