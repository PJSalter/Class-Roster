package com.sg.classroster;

import controller.ClassRosterController;
import dao.ClassRosterDaoException;
import dao.ClassRosterDaoFileImpl;
import dao.classRosterDao;
import ui.ClassRosterView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws ClassRosterDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        classRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }
}