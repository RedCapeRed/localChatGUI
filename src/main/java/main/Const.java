package main;

import main.controllers.AuthorizationController;
import main.controllers.MainController;


public class Const {
    //=========================================== REQUEST CODE =====================================================
    public static int REQUEST_AUTHORIZATION = 100,REQUEST_REGISTRATION = 101,REQUEST_ADD_FRIEND = 102;




    //=========================================== ERROR CODE =======================================================
    public static int ERROR_ACCOUNT_NOT_EXIST_= 300,ERROR_LOGIN_ALREADY_TAKEN = 301;




    //=========================================== SUCCESS CODE =====================================================
    public static int SUCCESS_OPERATION = 200;

    public static AuthorizationController authorizationController;
    public static MainController mainController;
}
