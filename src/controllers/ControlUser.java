package controllers;

import models.Course;
import models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {
    private ArrayList<User> listaUsers = new ArrayList<>();

    public ControlUser() {

        loadStudent();
    }

    public void loadStudent() {
        this.listaUsers.clear();

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

    public void creareUser(User user) {



        this.listaUsers.add(user);



    }

    public void add(User user){
        this.listaUsers.add(user);
    }

    public int size(){
        return this.listaUsers.size();
    }


    public  String toSave(){

        String text = "";

        for (User u : listaUsers) {
            text += u.toSave() + "\n";
        }

        return text;
    }


    public  void  save(){

        try {
            File file = new File("C:\\mycode\\oop\\incapsualrea\\proiectScoala\\src\\data\\users.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this.toSave());

            printWriter.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

}
