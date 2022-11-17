package view;

import controllers.ControlCourse;
import controllers.ControlEnrolment;
import controllers.ControlUser;
import models.Course;
import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewProfesor {

    //todo: sa se afiseze cursurilor profesorilor

    private Scanner scanner = new Scanner(System.in);

    private ControlEnrolment controlEnrolment;
    private ControlCourse controlCourse;
    private ControlUser controlUser;
    private User profesorlogat;

    public ViewProfesor(User user) {
        controlCourse = new ControlCourse();
        controlEnrolment = new ControlEnrolment();
        controlUser = new ControlUser();
        profesorlogat = user;
    }

    public void play() {

        boolean run = true;

        int alegere = 0;

        while (run) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1 -> cursulProfesorului();
                case 2 -> adaugareCursProfesor();
                case 3 -> eleviParticipatiLaUnCurs();
                case 4 -> eliminareCursInscris();
                case 5 -> celMaiFrecventatCurs();
                case 6 -> cursuriDeTipReal();
                case 7 -> cursuriDeTipUman();
                case 8 -> cursuriUndeNuEstiInscris();
                default -> {
                }
            }
        }

    }

    public void meniu() {
        System.out.println("");
        System.out.println("Apasati tasta 1 pentru a afisa cursurile unde predati");
        System.out.println("Apasati tasta 2 pentru a adauga un curs nou");
        System.out.println("Apasati tasta 3 pentru a afisa numarul de elevi participanti la un anumit curs");
        System.out.println("Apasati tasta 4 pentru a elimina un curs");
        System.out.println("Apasati tasta 5 pentru a vedea cursul cu cei mai multi studenti");
        System.out.println("Apasati tasta 6 pentru a vedea cursurile din departamentul \"real\"");
        System.out.println("Apasati tasta 7 pentru a elimina cursurile de tip \"uman\"");
        System.out.println("Apasati tasta 8 pentru a vedea cursurile la care nu predati");
        System.out.println("");
    }

    public void cursulProfesorului() {

        ArrayList<Course> course = controlCourse.findByProfesorID(profesorlogat.getId());

        for (Course value : course) {
            System.out.println(value.descriereaCursului());
        }
    }

    public void adaugareCursProfesor() {

        System.out.println("Scrieti numele cursului ");
        String numeCurs = scanner.nextLine();

        System.out.println("Scrieti departamentul cursului");
        String departament = scanner.nextLine();

        Course course = new Course(controlCourse.generateId(), numeCurs, departament, this.profesorlogat.getId());
        controlCourse.add(course);

        System.out.println("V-ati inscris cu succes");
    }

    public void eleviParticipatiLaUnCurs() {

        System.out.println("Scrieti numele cursului ");
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);

        if (course != null) {

            System.out.println("Participantii la acest curs sunt " + controlEnrolment.numarulDeEnrolmenturi(course.getId()) + " studenti");

        }
    }

    public void eliminareCursInscris() {

        System.out.println("Scrieti numele cursului");
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);

        if (course != null) {
            int nrEnrol = controlEnrolment.numarulDeEnrolmenturi(course.getId());
            if (nrEnrol > 0) {
                System.out.println("Nu putem sterge cursul deoarece sunt " + nrEnrol + " elevi inscrisi");
            } else {
                this.controlCourse.stergereCurs(course.getName());
                System.out.println("Ati sters cursul");
            }
        } else {
            System.out.println("Cursul nu exista");
        }
    }

    public void celMaiFrecventatCurs() {

        int curs = controlEnrolment.celMaiFrecventatCurs();
        Course course = controlCourse.findById(curs);
        System.out.println(course.descriereaCursului());

    }

    public void cursuriDeTipReal() {

        int numar = controlCourse.numarulDeCursuriDeTipReal();
        System.out.println("Exista " + numar + " cursuri de tip real in lista");
    }

    public void cursuriDeTipUman() {
        int numar = controlCourse.numarulDeCursuriDeTipUman();
        System.out.println("Exista " + numar + " cursuri de tip uman in lista");
    }

    public void cursuriUndeNuEstiInscris() {

        ArrayList<Course> courseArrayList = controlCourse.findForeignCourses(profesorlogat.getId());
        for (Course course : courseArrayList) {
            System.out.println(course.descriereaCursului());
        }
    }
}
