package Utilities;

import java.util.ArrayList;

import App.Utility;
import Properties.*;

public class DataValidator {

    public static void validateNewUser(String fullName, String userName, String email, String password,
                                       String confirmPassword, String gender) throws Exception {

        if (fullName.length() < 3 || isNull(fullName) == true || fullName.matches("[a-zA-Z' ']+") == false) {
            throw new Exception("Full name is not correct. Name must be of at least 3 characters and Alphabetic.");
        } else if (isNull(userName) == true || userName.length() < 3 || userName.matches("^[a-zA-Z0-9]*$") == false) {
            throw new Exception("User Name is not correct. User Name must be of at least 3 characters and Alphanumeric.");
        } else if (isUserNameValid(userName) == false) {
            throw new Exception("User Name already taken.");
        } else if (isNull(email) == true || email.length() < 3
                || (email.contains("@") == false || email.contains(".") == false)) {
            throw new Exception("Email is not correct. Please enter a valid email.");
        } else if (isNull(password) == true || password.length() < 6) {
            throw new Exception("Password is not correct. Password must be of at least 6 characters.");
        } else if (confirmPassword.equals(password) == false) {
            throw new Exception("Passwords dont match.");
        } else if (isNull(gender) == true) {
            throw new Exception("Gender is not correct. Maybe you didnt select an option.");
        }

    }

    public static void validateLogin(String userName, String password, String inputCaptcha,
                                     String correctCaptcha) throws Exception {

        if (!inputCaptcha.equals(correctCaptcha)){
            throw new Exception("Captcha entered is incorrect");
        }

        for(int i = 0; i < Serializer.userList.size(); i++) {
            System.out.println(Serializer.userList.get(i).getUserName() + "\n" + Serializer.userList.get(i).getPassword());
            if(Serializer.userList.get(i).getUserName().equals(userName)){
                if (Serializer.userList.get(i).getPassword().equals(password)) {
                    Utility.currentUser = Serializer.userList.get(i);
                    return;
                }
            }
        }

        throw new Exception("Username and Password don't match.");
    }

    public static void validatePhotoUpload(String photoPath, String privacy) throws Exception {
        if (isNull(photoPath) == true) {
            throw new Exception("Photo path is not correct. Maybe you didnt select a photo.");
        } else if (isNull(privacy) == true) {
            throw new Exception("Privacy is not correct. Maybe you didnt select an option.");
        }
    }


    public static <T> boolean isNull(T string) {
        return string == null;
    }

    private static boolean isUserNameValid(String userName) {
        for(int i = 0; i < Serializer.userList.size(); i++) {
            if(Serializer.userList.get(i).getUserName().equals(userName)){
                return false;
            }
        }

        return true;
    }


}
