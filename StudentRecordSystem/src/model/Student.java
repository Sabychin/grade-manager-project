package model;

public class Student {
    private String id;
    private String name;
    private String dob;
    private int semester;

    public Student(String id, String name, String dob, int semester) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public int getSemester() {
        return semester;
    }
}
