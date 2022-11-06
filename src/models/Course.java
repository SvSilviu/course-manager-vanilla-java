package models;

public class Course {

    private int id = 0;
    private String name = "";
    private String departament = "";
    private int profesorId = 0;


    public Course(int id, String name, String departament, int profesorId) {

        this.id = id;
        this.name = name;
        this.departament = departament;
        this.profesorId = profesorId;
    }

    //"1,matematica,stiinte"=>["1","matematica","stiinte"]
    public Course(String text) {
        String[] propr = text.split(",");
        this.id = Integer.parseInt(propr[0]);
        this.name = propr[1];
        this.departament = propr[2];
        this.profesorId = Integer.parseInt(propr[3]);
    }


    public Course() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getDepartament() {
        return this.departament;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getProfesorId() {
        return this.profesorId;
    }

    public String descriereaCursului() {

        String text = "";

        text += "Id - " + id + "\n";
        text += "Name - " + name + "\n";
        text += "Departament - " + departament + "\n";
        text += "Profesor ID - " + profesorId + "\n";

        return text;
    }


}
