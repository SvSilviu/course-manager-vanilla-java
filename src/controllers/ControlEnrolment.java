package controllers;

import models.Enrolment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {

    private ArrayList<Enrolment> enrolmentArrayList = new ArrayList<>();

    public ControlEnrolment() {

        loadEnrolment();
    }

    public void loadEnrolment() {

        try {
            File file =new File("C:\\mycode\\oop\\incapsualrea\\proiectScoala\\src\\data\\enrolment.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String text = scanner.nextLine();
                Enrolment enrolment = new Enrolment(text);
                enrolmentArrayList.add(enrolment);
            }
        }catch (Exception exception){

        }

    }
    //todo:metoda ce primeste ca parametru un student id si retuneaza lista enrolemnturilor cu studentID respectiv

    public ArrayList<Enrolment> listaEnrolmenturilor(int studentId) {

        ArrayList<Enrolment> enrolments = new ArrayList<>();
        for (int i = 0; i < enrolmentArrayList.size(); i++) {
            if (enrolmentArrayList.get(i).getUserID() == studentId) {

                enrolments.add(enrolmentArrayList.get(i));
            }
        }
        return enrolments;
    }


    public boolean verificareCursuriStudent(int idStudent, int idCurs) {

        for (Enrolment enrolment : enrolmentArrayList) {
            if (enrolment.getUserID() == idStudent && enrolment.getCourseId() == idCurs) {
                return true;
            }
        }
        return false;
    }

    public void addEnrolment(Enrolment enrolment) {

        this.enrolmentArrayList.add(enrolment);

    }

    public int generateId() {
        if (enrolmentArrayList.size() == 0) {
            return 1;
        } else {
            return enrolmentArrayList.get(enrolmentArrayList.size() - 1).getId() + 1;
        }
    }

    public void deleteEnrolment(int userID, int coorseId) {

        for (int i = 0; i < enrolmentArrayList.size(); i++) {
            if (enrolmentArrayList.get(i).getUserID() == userID && enrolmentArrayList.get(i).getUserID() == coorseId) {
                enrolmentArrayList.remove(enrolmentArrayList.get(i).getId());
            }
        }
    }

    //todo:fuunctie ce primeste ca parametru id de curs si returneaza numarrul de enrrolmenturi

    public int numarulDeEnrolmenturi(int idCurs) {
        int contor = 0;
        for (Enrolment enrolment : enrolmentArrayList) {
            if (enrolment.getCourseId() == idCurs)
                contor++;
        }

        return contor;
    }

    //toto functie cel mai frecventat curs

    public int celMaiFrecventatCurs() {
        int idCurs = 0;
        int fMax = 0;
        for (Enrolment enrolment : enrolmentArrayList) {
            int courseId = enrolment.getCourseId();
            int ct = numarulDeEnrolmenturi(courseId);
            if (ct > fMax) {
                fMax = ct;
                idCurs = courseId;
            }
        }
        return idCurs;
    }

    public void afisareEnrolment() {
        for (Enrolment enrolment : enrolmentArrayList) {
            System.out.println(enrolment.descriereEnrolment());
        }
    }


}


