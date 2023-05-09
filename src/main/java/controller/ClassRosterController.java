package controller;

import dao.ClassRosterDaoException;
import dao.ClassRosterDaoFileImpl;
import dao.classRosterDao;
import dto.Student;
import ui.ClassRosterView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
   private ClassRosterView view;

    private classRosterDao dao;

    public ClassRosterController(classRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    private UserIO io = new UserIOConsoleImpl();

    private int getMenuSelection() {

        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterDaoException {
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
        try {
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
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

}
