package Utilities;

import Properties.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializer {
    // path to the database

    public static final String databasePath1 = "./user.bin", databasePath2 = "./images.bin";
    public static ArrayList<User> userList;
    public static ArrayList<Images> imageList;

    public static void initializeDatabase(){
        userList = deserializeUser();
        if (userList == null) {
            userList = new ArrayList<User>();
        }
        imageList = deserializeImages();
        if (imageList == null) {
            imageList = new ArrayList<Images>();
        }
    }

    // serializing the arraylist to the database file
    public static void serialize() {
        File databaseFile1 = new File(databasePath1);
        File databaseFile2 = new File(databasePath2);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(databaseFile1);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("Hello");
            objectOutputStream.writeObject(userList);

        } catch (Exception exception) {
            System.out.println("Cannot read to file");
            exception.printStackTrace();
        }

        try {
            fileOutputStream = new FileOutputStream(databaseFile2);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(imageList);

        } catch (Exception exception) {
            System.out.println("Cannot read to file again");
        }
    }


    // deserializing the arraylist from the database file
    public static ArrayList<User> deserializeUser() {
        File databaseFile = new File(databasePath1);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        ArrayList<User> list = null;

        try {
            fileInputStream = new FileInputStream(databaseFile);
            objectInputStream = new ObjectInputStream(fileInputStream);

            list = (ArrayList<User>) objectInputStream.readObject();
        } catch (Exception exception) {
            System.out.println("New file has been created.");
        }

        return list;
    }
    public static ArrayList<Images> deserializeImages() {
        File databaseFile = new File(databasePath2);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        ArrayList<Images> list = null;

        try {
            fileInputStream = new FileInputStream(databaseFile);
            objectInputStream = new ObjectInputStream(fileInputStream);

            list = (ArrayList<Images>) objectInputStream.readObject();
        } catch (Exception exception) {
            System.out.println("New file has been created.");
        }

        return list;
    }
}

