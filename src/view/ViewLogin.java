package view;


import controllers.ControlUser;
import models.User;

import java.util.Scanner;

public class ViewLogin {


    private ControlUser controlUser;
    private Scanner scanner = new Scanner(System.in);

    public ViewLogin() {
        this.controlUser = new ControlUser();
    }

    public void meniu() {

        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a va inregistra");

    }

    public void play() {

        boolean run = true;

        int alegere = 0;


        while (run == true) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {

                case 1:
                    login();
                    break;
                default:
                    meniu();
                    break;

            }
        }

    }

   public void login() {
        System.out.println("Introduceti email-ul");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String parola = scanner.nextLine();

        User user = controlUser.usernameSiParola(email, parola);

        if (user != null) {

            if (user.getType().equals("profesor")) {

                ViewProfesor viewProfesor = new ViewProfesor(user);
                viewProfesor.play();
            } else {

                ViewStudent viewStudent = new ViewStudent(user);
                viewStudent.play();
            }
        } else {
            System.out.println("Credentiale incorecte ");
        }


    }

}
