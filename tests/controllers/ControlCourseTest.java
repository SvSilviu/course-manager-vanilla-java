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
        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(20, "Istorie", "uman", 1);
        controlCourse.add(course);
        assertEquals("uman", controlCourse.findById(20).getDepartament());
        assertEquals("Istorie", controlCourse.findById(20).getName());
        assertEquals(20, controlCourse.findById(20).getId());
        assertEquals(1, controlCourse.findById(20).getProfesorId());
    }

    @Test
    public void testFindByName() {

        ControlCourse controlCourse = new ControlCourse();
        Course course3 = new Course(44, "Chimie", "real", 5);
        controlCourse.add(course3);

        assertEquals("Chimie", controlCourse.findByName("Chimie").getName());
        assertEquals(44, controlCourse.findByName("Chimie").getId());
        assertEquals("real", controlCourse.findByName("Chimie").getDepartament());
        assertEquals(5, controlCourse.findByName("Chimie").getProfesorId());

    }

    @Test
    public void testFindByNameNullScenario() {

        ControlCourse controlCourse = new ControlCourse();
        assertEquals(null, controlCourse.findByName("kakakasdasdjas"));

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

        Course course = new Course(20, "Istorie", "uman", 1);
        Course course3 = new Course(25, "Romana", "uman", 3);

        int initial = controlCourse.numarulDeCursuriDeTipUman();

        controlCourse.add(course);
        controlCourse.add(course3);

        assertEquals(initial + 2, controlCourse.numarulDeCursuriDeTipUman());

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

        ControlCourse controlCourse = new ControlCourse();

        int id = controlCourse.generateId();
        Course course = new Course(id, "test", "uman", 5);
        controlCourse.add(course);
        assertEquals(id, controlCourse.findByName("test").getId());
        controlCourse.stergereCurs("test");


        assertEquals(null, controlCourse.findByName("test"));


    }

    @Test
    public void testFindByIdNullScenario() {
        ControlCourse controlCourse = new ControlCourse();
        assertEquals(null, controlCourse.findById(1231231231));
    }

    @Test
    public void testFindByDepartament() {

        //PRECONDTITE
        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(10, "Matematica", "TEST", 10);
        controlCourse.add(course);


        Course course1 = controlCourse.findByDepartament("TEST");


        assertEquals(10, course1.getId());
        assertEquals("Matematica", course1.getName());
        assertEquals("TEST", course1.getDepartament());
        assertEquals(10, course1.getProfesorId());

    }

    @Test
    public void testFindByDepartamentNullScenario() {

        ControlCourse controlCourse = new ControlCourse();
        assertEquals(null, controlCourse.findByDepartament("jsajskaka"));
    }

    @Test
    public void testGenerateID() {

        ControlCourse controlCourse = new ControlCourse();

        int id = controlCourse.generateId();

        assertEquals(null, controlCourse.findById(id));

    }

    @Test
    public void testCursuriLibere() {

        ControlCourse controlCourse = new ControlCourse();
        Course course = new Course(20, "Istorie", "uman", 20);
        Course course1 = new Course(21, "Matematica", "real", 1);
        Course course2 = new Course(22, "Fizica", "real", 1);
        Course course3 = new Course(25, "Romana", "uman", 20);
        Course course4 = new Course(44, "Chimie", "real", 5);

        controlCourse.add(course);
        controlCourse.add(course1);
        controlCourse.add(course2);
        controlCourse.add(course3);
        controlCourse.add(course4);

        ArrayList<Course> arrayList = controlCourse.findForeignCourses(20);

        boolean test = true;

        for (Course C : arrayList) {
            if (C.getProfesorId() == 20){
                test = false;
            }

        }


        assertEquals(true, test);


    }

}