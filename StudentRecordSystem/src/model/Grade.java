package model;

public class Grade {
    private String studentId;
    private String moduleId;
    private int grade;

    public Grade(String studentId, String moduleId, int grade) {
        this.studentId = studentId;
        this.moduleId = moduleId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public int getGrade() {
        return grade;
    }
}
