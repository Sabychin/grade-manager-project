package model;

public class Module {
    private String code;
    private String name;
    private int credits;
    private int semester;

    public Module(String code, String name, int credits, int semester) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getSemester() {
        return semester;
    }
}
