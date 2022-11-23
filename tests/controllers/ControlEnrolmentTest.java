package controllers;

import models.Enrolment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlEnrolmentTest {

    @Test
    public void testLoadEnrolment() {

        ArrayList<Enrolment> enrolmentArrayList = new ArrayList<>();
        Enrolment enrolment = new Enrolment(1, 2, 4);

        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.loadEnrolment();


        int intialSize = controlEnrolment.size();

        controlEnrolment.addEnrolment(enrolment);
        controlEnrolment.save();
        controlEnrolment.loadEnrolment();

        assertEquals(intialSize + 1, controlEnrolment.size());

    }

    @Test
    public void testCelMaiFrecventatCurs() {

        ControlEnrolment controlEnrolment = new ControlEnrolment();
        for (int i = 1; i < 1000; i++) {
            Enrolment enrolment = new Enrolment(i, 1, i);
            controlEnrolment.addEnrolment(enrolment);
        }

        assertEquals(1, controlEnrolment.celMaiFrecventatCurs());
    }

    @Test
    public void testListaEnrolmenturilor() {

        ControlEnrolment controlEnrolment = new ControlEnrolment();
        Enrolment enrolment = new Enrolment(5, 7, 9);
        Enrolment enrolment1 = new Enrolment(3, 2, 1);
        Enrolment enrolment2 = new Enrolment(5, 6, 2);
        Enrolment enrolment3 = new Enrolment(1, 2, 1);

        controlEnrolment.addEnrolment(enrolment);
        controlEnrolment.addEnrolment(enrolment1);
        controlEnrolment.addEnrolment(enrolment2);
        controlEnrolment.addEnrolment(enrolment3);

        ArrayList<Enrolment> enrolmentArrayList = controlEnrolment.listaEnrolmenturilor(5);
        boolean ver = true;

        for (Enrolment e : enrolmentArrayList) {
            if (e.getUserID() != 5) {
                ver = false;
            }
        }

        assertEquals(ver, true);
    }

    @Test
    public void testVerificareCursuriStudenti() {

        ControlEnrolment controlEnrolment = new ControlEnrolment();

        Enrolment enrolment = new Enrolment(1,2,3);
        Enrolment enrolment1 = new Enrolment(2,4,3);
        Enrolment enrolment2 = new Enrolment(5,5,3);

        controlEnrolment.addEnrolment(enrolment);
        controlEnrolment.addEnrolment(enrolment2);
        controlEnrolment.addEnrolment(enrolment1);


        assertEquals(true,controlEnrolment.verificareCursuriStudent(3,2));

    }

    @Test
    public void testVerificareCursuriStudentiTrueScenario() {

        ControlEnrolment controlEnrolment = new ControlEnrolment();
        Enrolment enrolment = new Enrolment(1,2,3000);
        Enrolment enrolment1 = new Enrolment(2,2,3000);
        Enrolment enrolment2 = new Enrolment(5,2,3000);

        controlEnrolment.addEnrolment(enrolment);
        controlEnrolment.addEnrolment(enrolment2);
        controlEnrolment.addEnrolment(enrolment1);

        boolean verificare = controlEnrolment.verificareCursuriStudent(2,3000);

        controlEnrolment.deleteEnrolment(2,3000);

        assertEquals(verificare, controlEnrolment.verificareCursuriStudent(2, 3000));
    }

}
