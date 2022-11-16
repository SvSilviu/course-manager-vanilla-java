package models;

import controllers.ControlCourse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

   @Test
    public void test1() {
       //precondtie actiune rezultat
       User user = new User(1, "Marian", "Petre", "marian@yahoo.com", "parola", 23, "student");
       User user2 = new User(2, "Mihai", "Anton", "anton@gmail.com", "parola2", 32, "profesor");
       assertEquals("Marian", user.getFirstName());
    }


    @Test
    public void test2(){
       //preconditie
        User user = new User(1, "Marian", "Petre", "marian@yahoo.com", "parola", 23, "student");
        User user2 = new User(2, "Mihai", "Anton", "anton@gmail.com", "parola2", 32, "profesor");
        //actiunea
        user2.setType("student");
        //rezultat
        assertEquals("student",user2.getType());
    }



}