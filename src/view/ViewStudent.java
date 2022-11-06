package view;

import controllers.ControlCourse;
import controllers.ControlEnrolment;
import models.Course;
import models.Enrolment;
import models.User;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private Scanner scanner = new Scanner(System.in);
    private ControlEnrolment controlEnrolment;
    private ControlCourse controlCourse;
    private User userLogat;

    public ViewStudent() {
        controlCourse = new ControlCourse();
        controlEnrolment = new ControlEnrolment();
        userLogat = new User(1, "Vasile", "Andrei", "vasile@gmail.com", "parolaVasile", 24,"PROFESOR");
    }

    public void play() {

        boolean running = true;
        int alegere = 0;


        while (running == true) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    controlCourse.afisare();
                    break;
                case 2:
                    cursuriInscris();
                    break;
                case 3:
                    adaugareInCurs();
                    break;
                case 4:
                    dezabonareCurs();
                    break;
                case 5:
                    celMaiFrecventat();
                    break;
                default:
                    break;

            }
        }
    }


    public void meniu() {

        System.out.println("Apasati tasta 1 pentru a vedea cursurile disponibile");
        System.out.println("Apasati tasta 2 pentru a vedea cursurile unde sunteti inscris");
        System.out.println("Apasati tasta 3 pentru a va inscrie la un curs");
        System.out.println("Apasati tasta 4 pentru a pleaca de la un curs");
        System.out.println("Apasati tasta 5 pentru a vedea cel mai frecventat curs");
    }

    public void cursuriInscris() {

        ArrayList<Enrolment> enrolments = controlEnrolment.listaEnrolmenturilor(userLogat.getId());

        for (Enrolment e : enrolments) {
            Course course = controlCourse.findById(e.getCourseId());
            System.out.println(course.descriereaCursului());
        }
    }

    public void adaugareInCurs() {

        System.out.println("Introduceti numele cursului la care doriti sa va inscrieti");
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);
        Enrolment enrolment = new Enrolment(controlEnrolment.generateId(), course.getId(), userLogat.getId());
        controlEnrolment.addEnrolment(enrolment);
        System.out.println("V-ati inscris !");

    }

    public void dezabonareCurs() {
        System.out.println("Introduceti numele cursului de la care vreti sa va dezabonati ");
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);

        if (course != null && controlEnrolment.verificareCursuriStudent(this.userLogat.getId(), course.getId())) {

            controlEnrolment.deleteEnrolment(userLogat.getId(), course.getId());
            System.out.println("V-ati dezabonat  cu succes !");
        } else {
            System.out.println("Cursul nu exista, incercati din nou !");
        }
    }

    public void celMaiFrecventat(){

        int curs = controlEnrolment.celMaiFrecventatCurs();

        Course course = controlCourse.findById(curs);
        System.out.println(course.descriereaCursului());

    }

}
