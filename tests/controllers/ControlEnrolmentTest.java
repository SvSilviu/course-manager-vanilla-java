package controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlEnrolmentTest {

    @Test
    public void testLoadEnrolment(){

        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.loadEnrolment();
        assertEquals(6,controlEnrolment.size());
    }
    @Test
    public void testCelMaiFrecventatCurs(){

        ControlEnrolment controlEnrolment = new ControlEnrolment();
        controlEnrolment.celMaiFrecventatCurs();
        assertEquals(5,controlEnrolment.celMaiFrecventatCurs());
    }

}
