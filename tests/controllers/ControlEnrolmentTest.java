package controllers;

import models.Enrolment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlEnrolmentTest {

    @Test
    public void testLoadEnrolment(){

        ControlEnrolment controlEnrolment = new ControlEnrolment();

        Enrolment enrolment =new Enrolment(1,2,4);

        int intialSize = controlEnrolment.size();

        controlEnrolment.addEnrolment(enrolment);

        assertEquals(intialSize+1,controlEnrolment.size());

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

}
