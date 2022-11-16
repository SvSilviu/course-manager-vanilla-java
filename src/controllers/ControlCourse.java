package controllers;

import models.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCourse {
    private ArrayList<Course> listaCursuri = new ArrayList<>();


    public ControlCourse() {

        loadCourses();
    }

    public void loadCourses() {

        this.listaCursuri.clear();

        try {

            File file = new File("C:\\mycode\\oop\\incapsualrea\\proiectScoala\\src\\data\\courses.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();

                Course course = new Course(text);

                listaCursuri.add(course);

            }
            System.out.println("Cursurile au fost incarcate");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void afisare() {

        for (Course course : listaCursuri) {
            System.out.println(" ");
            System.out.println(course.descriereaCursului());
            System.out.println(" ");
        }
    }


    //todo:functie ce prieste ca parametru id cursului si returneaza cursul cu id respectiv

    public Course findById(int courseId) {

        for (Course course : listaCursuri) {
            if (course.getId() == courseId) {

                return course;
            }
        }
        return null;
    }

    public Course findByName(String name) {

        for (Course course : listaCursuri) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }

    public Course findByDepartament(String departament) {

        for (Course course : listaCursuri) {
            if (course.getDepartament().equals(departament)) {

                return course;
            }
        }
        return null;
    }

    public int numarulDeCursuriDeTipReal() {

        int contor = 0;
        String tip = "real";
        for (Course course : listaCursuri) {
            if (course.getDepartament().equals(tip))
                contor++;

        }
        return contor;
    }

    public int numarulDeCursuriDeTipUman() {
        int contor = 0;
        String tip = "uman";
        for (Course course : listaCursuri) {
            if (course.getDepartament().equals(tip))
                contor++;
        }
        return contor;
    }

    public int generateId() {
        if (listaCursuri.size() == 0) {
            return 1;
        } else {
            return listaCursuri.get(listaCursuri.size() - 1).getId() + 1;
        }
    }

    public ArrayList<Course> findByProfesorID(int profesorID) {

        ArrayList<Course> courseArrayList = new ArrayList<>();
        for (Course course : listaCursuri) {
            if (course.getProfesorId() == profesorID) {
                courseArrayList.add(course);
            }
        }
        return courseArrayList;
    }

    public void add(Course course) {
        this.listaCursuri.add(course);
    }


    public ArrayList<Course> cursuriLibere(int profesorID) {

        ArrayList<Course> courseArrayList = new ArrayList<>();
        for (Course course : listaCursuri) {
            if (course.getProfesorId() != profesorID) {
                courseArrayList.add(course);
            }
        }
        return courseArrayList;
    }
    //todo:functie ce  pirmeste ca parametru numele unui curs si sterge cursul

    public void stergereCurs(String curs) {
        Course course = findByName(curs);
        if (course != null) {
            this.listaCursuri.remove(course);
        }
    }


    public int size() {

        return this.listaCursuri.size();
    }

    public String toSave() {

        String text = "";
        for (Course c : listaCursuri) {
            text += c.toSave() + "\n";

        }
        return text;
    }

    public void save() {

        try {

            File file = new File("C:\\mycode\\oop\\incapsualrea\\proiectScoala\\src\\data\\courses.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();

        } catch (IOException e) {

        }

    }
}


