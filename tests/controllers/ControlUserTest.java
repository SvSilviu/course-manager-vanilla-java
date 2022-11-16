package controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControlUserTest {


    @Test
    public void testControlUserLoadUser() {

        ControlUser controlUser = new ControlUser();
        controlUser.loadStudent();
        assertEquals(5,controlUser.size());

    }



}

