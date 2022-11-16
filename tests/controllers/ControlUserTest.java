package controllers;

import models.Course;
import models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControlUserTest {


    @Test
    public void testControlUserLoadUser() {

        User user = new User(1,"Vasile","Andrei","vasile@gmail.com","parolaVasile",24,"profesor");

        ControlUser controlUser = new ControlUser();
        int initialSize = controlUser.size();

        controlUser.add(user);

        assertEquals(initialSize+1,controlUser.size());

    }



}

