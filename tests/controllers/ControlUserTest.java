package controllers;

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
@Test
    public void testLoadUsers(){
        ArrayList<User> userArrayList = new ArrayList<>();

        User user = new User(1,"Nume","Prenume","e-mail","parola",34,"admin");

        ControlUser controlUser = new ControlUser();
        controlUser.loadStudent();
        int initialSize = controlUser.size();
        controlUser.add(user);
        controlUser.save();
        controlUser.loadStudent();

    assertEquals(initialSize + 1, controlUser.size());
}

    @Test
    public void testReturnUsernameSiParola() {

        ControlUser controlUser = new ControlUser();
        User user = new User(1, "Nume", "Prenume", "e-mail", "parola", 34, "admin");

        controlUser.add(user);

        User user1 = controlUser.usernameSiParola("e-mail","parola");

        assertEquals(1,user1.getId());
        assertEquals("Nume",user1.getFirstName());
        assertEquals("Prenume",user1.getLastName());
        assertEquals("e-mail",user1.getEmail());
        assertEquals("parola",user1.getPassword());
        assertEquals(34,user1.getAge());
        assertEquals("admin",user1.getType());

    }
    @Test
    public void testReturnUserSiParolaNullScenario(){

        ControlUser controlUser = new ControlUser();
        assertEquals(null,controlUser.usernameSiParola("dadada","sfsdfs"));

    }

}

