package com.example.linneabark.test;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.model.ActivityRow;

/**
 * Created by Evelinas on 2017-05-27.
 */

public class WriteAndReadFile {

    File path;
    File file;

    public WriteAndReadFile (Context context) {
        path = context.getFilesDir();
        file = new File(path, "myFileName.txt");
    }

    public void writeArrayToFile (List<ActivityRow> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("writeArrayToFile, IOExeption: " + file.toString() );
        }
    }

    public List<ActivityRow> getArrayFromFile () {
        List<ActivityRow> activityRows = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            activityRows = (List<ActivityRow>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("getArrayFromFile, FileNotFoundException: " + e.toString());
        } catch (IOException e) {
            System.out.println("getArrayFromFile, IOException: " + e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("getArrayFromFile, ClassNotFoundException: " + e.toString());
        }
        return activityRows;
    }


}
