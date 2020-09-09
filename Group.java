package learning.java.school;

class Group {
    private Professor professor;
    private int availability;
    private Student[] students;

    public Group(int availability) {
        this.availability = availability;
        students = new Student[availability];
    }

}