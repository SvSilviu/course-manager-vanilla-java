package controllers;

import models.Course;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControlCourseTest {

    @Test
    public void test3ControlCourseLoadCourses() {

        ArrayList<Course> courseArrayList = new ArrayList<>();
        Course course = new Course(20, "Istorie", "uman", 1);
        Course course1 = new Course(21, "Matematica", "real", 1);
        Course course2 = new Course(22, "Fizica", "real", 1);
        Course course3 = new Course(25, "Romana", "uman", 3);
        Course course4 = new Course(44, "Chimie", "real", 5);

        ControlCourse controlCourse = new ControlCourse();
        controlCourse.loadCourses();

        int initialSize = controlCourse.size();
        controlCourse.add(course);
        controlCourse.add(course1);
        controlCourse.add(course2);
        controlCourse.add(course3);
        controlCourse.add(course4);
        controlCourse.save();
        controlCourse.loadCourses();


        assertEquals(initialSize + 5, controlCourse.size());


    }

    @Test
    public void test4FindById() {
//preconditie actiune rezultat

        ControlCourse controlCourse = new ControlCourse();
        Course c = controlCourse.findById(3);
        assertEquals(3, c.getId());
    }

    @Test
    public void testAfisare() {

        ControlCourse controlCourse = new ControlCourse();
        controlCourse.afisare();
        //   assertEquals();

    }

    @Test
    public void testFindByName() {

        ControlCourse controlCourse = new ControlCourse();
        Course course = controlCourse.findByName("Desen");
        assertEquals("Desen", course.getName());

    }

    @Test
    public void testFindById() {

        ControlCourse controlCourse = new ControlCourse();
        Course course = controlCourse.findById(1);
        assertEquals(1, course.getId());
    }

    @Test
    public void testFindByDepartament() {

        ControlCourse controlCourse = new ControlCourse();

        Course course = new Course(20, "Istorie", "uman", 1);
        Course course1 = new Course(21, "Matematica", "real", 1);
        Course course2 = new Course(22, "Fizica", "real", 1);
        Course course3 = new Course(25, "Romana", "uman", 3);
        Course course4 = new Course(44, "Chimie", "real", 5);

        Course initial = controlCourse.findByDepartament("uman");

        controlCourse.add(course);
        controlCourse.add(course1);
        controlCourse.add(course2);
        controlCourse.add(course3);
        controlCourse.add(course4);

        ArrayList<Course> cursuri  = controlCourse.findByDepartament("departament")

        for(int i = 0;i<controlCourse.size();i++){
            if()
        }


        assertEquals(initial+2, course.getDepartament());
    }

    @Test
    public void testNrDeCursuriDeTipReal() {

        ControlCourse controlCourse = new ControlCourse();
        Course course1 = new Course(21, "Matematica", "real", 1);
        Course course2 = new Course(22, "Fizica", "real", 1);
        Course course3 = new Course(44, "Chimie", "real", 5);
        int initial = controlCourse.numarulDeCursuriDeTipReal();//din fisier
        controlCourse.add(course1);
        controlCourse.add(course2);
        controlCourse.add(course3);

        assertEquals(initial + 3, controlCourse.numarulDeCursuriDeTipReal());
    }

    @Test
    public void testNrDeCursuriDeTipUman() {

        ControlCourse controlCourse = new ControlCourse();
        controlCourse.numarulDeCursuriDeTipUman();
        assertEquals(4, controlCourse.numarulDeCursuriDeTipUman());
    }

    @Test
    public void testFindProfById() {
        //preconditie cream 5 cursuri
        Course course = new Course(20, "Istorie", "uman", 1);
        Course course1 = new Course(21, "Matematica", "real", 1);
        Course course2 = new Course(22, "Fizica", "real", 1);
        Course course3 = new Course(25, "Romana", "uman", 3);
        Course course4 = new Course(44, "Chimie", "real", 5);

        ControlCourse controlCourse = new ControlCourse();

        controlCourse.add(course);
        controlCourse.add(course1);
        controlCourse.add(course2);
        controlCourse.add(course3);
        controlCourse.add(course4);

        //Actiune


        ArrayList<Course> courseArrayList = controlCourse.findByProfesorID(1);

        boolean vfFizica = false;
        boolean vfMatematica = false;
        boolean vfChimie = false;
        boolean vfRomana = false;
        boolean vfIstore = false;

        for (int i = 0; i < courseArrayList.size(); i++) {

            if (courseArrayList.get(i).getName().equals("Fizica")) {
                vfFizica = true;
            }
            if (courseArrayList.get(i).getName().equals("Matematica")) {
                vfMatematica = true;
            }
            if (courseArrayList.get(i).getName().equals("Istorie")) {
                vfIstore = true;
            }
            if (courseArrayList.get(i).getName().equals("Romana")) {
                vfRomana = false;
            }
            if (courseArrayList.get(i).getName().equals("Chimie")) {
                vfChimie = false;
            }
        }

        //Verificare
        assertEquals(vfFizica, true);
        assertEquals(vfMatematica, true);
        assertEquals(vfChimie, false);
        assertEquals(vfRomana, false);
        assertEquals(vfIstore, true);


    }

    @Test
    public void testFindProfByIdScenariu2() {

        ControlCourse controlCourse = new ControlCourse();
        ArrayList<Course> courseArrayList = new ArrayList<>();

        Course course = new Course(2, "Gramatica", "uman", 5);
        courseArrayList.add(course);
        boolean vfUman = false;

        for (int i = 0; i < courseArrayList.size(); i++) {
            if (courseArrayList.get(i).getDepartament().equals("uman"))
                vfUman = true;
        }
        assertEquals(vfUman, true);

    }


    @Test
    public void testStergereCurs() {

//        ControlCourse controlCourse = new ControlCourse();
//       controlCourse.stergereCurs("Desen");
//       assertEquals("Desen",controlCourse.stergereCurs("Desen"));
//
    }


}