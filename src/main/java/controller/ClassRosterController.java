package controller;

import dao.ClassRosterDaoFileImpl;
import dao.classRosterDao;
import dto.Student;
import ui.ClassRosterView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
   private ClassRosterView view = new ClassRosterView();

    private classRosterDao dao = new ClassRosterDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();

    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void removeStudent(){
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }

    public void run() {
        boolean KeepGoing = true;
        int menuSelection = 0;
        while (KeepGoing) {

            menuSelection = getMenuSelection();

//            io.print("Main Menu");
//            io.print("1. List Student IDs");
//            io.print("2. Create New Student");
//            io.print("3. View a Student");
//            io.print("4. Remove a Student");
//            io.print("5. Exit");

//            menuSelection = io.readInt("Please select from the"
//                    + " above choices.", 1, 5);

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    KeepGoing = false;
                    break;
                default:
                    unknownCommand();
            }


        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

}
