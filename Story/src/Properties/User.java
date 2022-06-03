package Properties;

import Utilities.Serializer;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String fullName;
    private String userName;
    private String email;
    private String gender;
    private String password;
    private String photoPath;
    private ArrayList <Images> usersImage;

    public User(String fullName, String userName, String email, String gender, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        File f;
        if (this.gender.equals("Female")) {
            f = new File("./resources/default_female.jpg");
        } else {
            f = new File("./resources/default_male.jpg");
        }
        this.photoPath = "File://" + f.toURI().getPath();
        usersImage = new ArrayList<Images>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public ArrayList<Images> getUsersImage() {
        return usersImage;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void addImage(Images usersImage) {
        this.usersImage.add(usersImage);
    }





}
