package HT_L2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vasya on 23.08.2016.
 */
public class FileCreator {

    public void fileCreator(File file, String filePath) throws IOException {
        String newFile = "";
        System.out.println("Input file name");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        newFile = bufferedReader.readLine();
        file = new File(filePath + file.separator + newFile);

        file.createNewFile();
        System.out.println("\nEmpty file " + newFile + " created\n");
    }
}