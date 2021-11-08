package StudentCollection;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentCollection {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentAddIn studentAddIn;

    public StudentCollection() {
        studentAddIn = new StudentAddIn();
        studentList = StudentAddIn.read();
    }

    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("Student Id = " + id);
        String name = inputName();
        byte age = inputAge();
        byte address = inputAge();
        float gpa = inputGpa();
        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentAddIn.write(studentList);
    }


    public  void edit(int id) {
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentAddIn.write(studentList);
        }
    }

    public void delete(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if(studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentAddIn.write(studentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }
    //Sort Student by name
    public void sortStudentByName() {
        Collections.sort(studentList, new SortStudentByName());
    }
    //Sort Student by Id
    public void sortStudentByGPA() {
        Collections.sort(studentList, new SortStudentByGPA());
    }

    /**
     * show list student to screen
     */
    public void show() {
        for (Student student : studentList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%10.1f%n", student.getGpa());
        }
    }

    /**
     * input student id
     *
     * @return student id
     */
    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    /**
     * input student name
     *
     * @return student name
     */
    private String inputName() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    /**
     * input student address
     *
     * @return student address
     */
    private String inputAddress() {
        System.out.print("Input student address: ");
        return scanner.nextLine();
    }

    /**
     * input student age
     *
     * @return student age
     */
    private byte inputAge() {
        System.out.print("Input student age: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    /**
     * input student gpa
     *
     * @return gpa
     */
    private float inputGpa() {
        System.out.print("Input student gpa: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 && gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student age again: ");
            }
        }
    }

    // getter && setter
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void sortStudentbyGPA() {
    }
}


