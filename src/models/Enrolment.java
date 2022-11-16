package models;

public class Enrolment {
    private int id = 0;
    private int courseId = 0;
    private int userID = 0;


    public Enrolment(int id, int courseId, int userID) {
        this.id = id;
        this.courseId = courseId;
        this.userID = userID;
    }

    public Enrolment(String text) {

        String[] detalii = text.split(",");
        this.id = Integer.parseInt(detalii[0]);
        this.courseId = Integer.parseInt(detalii[1]);
        this.userID = Integer.parseInt(detalii[2]);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }


    public String descriereEnrolment(){

        String text = "";

        text+="Id - "+id+"\n";
        text+="Course Id - "+courseId+"\n";
        text+="Student id - "+ userID +"\n";

        return text;
    }

    public String toSave(){

       return this.id+","+this.courseId+","+this.userID;

    }


}


