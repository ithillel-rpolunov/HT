package HT_L2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileActions {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void fileCreator(File file, String filePath) throws IOException {
        String newFile = "";

        System.out.println("1. Directory\n2. File\n0. Return to main menu");

        int chouse = Integer.parseInt(bufferedReader.readLine());
        System.out.println(file.toString());

        if (chouse == 1) {
            System.out.println("Input directory name");
            newFile = bufferedReader.readLine();
            file = new File(file.toString() + file.separator + newFile);
            file.mkdir();
            System.out.println("\nEmpty directory " + newFile + " created\n");

            Menu.menu(filePath);
        }
        if (chouse == 2) {
            System.out.println("Input file name");
            newFile = bufferedReader.readLine();
            file = new File(file.toString() + file.separator + newFile);

            file.createNewFile();
            System.out.println("\nEmpty file " + newFile + " created\n");

            Menu.menu(filePath);
        }
        if (chouse == 0) {
           Menu.menu(filePath);
        }
    }

    public void fileDeleter(File file, String filePath) throws IOException {

        System.out.println("Input file name");

        String deleteFile = bufferedReader.readLine();
        file=new File(filePath+file.separator+deleteFile);

        file.delete();
        System.out.println("\nFile "+file+" was deleted\n");
    }



    public void fileRenamer(File file, String filePath) throws IOException {
        System.out.println("Input file name to rename");

        String renameFile = bufferedReader.readLine();
        System.out.println("Input new file name");

        String newrenameFile = bufferedReader.readLine();
        File oldFile = new File(filePath + file.separator + renameFile);
        File newFile1 = new File(filePath + file.separator + newrenameFile);

        oldFile.renameTo(newFile1);

        System.out.println("File " + oldFile + " was renamed to " + newFile1 + "\n");
    }

    public void getListing(File file){
        ArrayList<String> filesList = new ArrayList<>();
        ArrayList<String> dirList = new ArrayList<>();
        File[] listArray = file.listFiles();

        file.listFiles();

        for (File file1 : listArray) {
            if (file1.isDirectory()){
                dirList.add(file1.toString().substring(file1.toString().lastIndexOf(File.separator) + 1));
            }
            if (file1.isFile()){
                filesList.add(file1.toString().substring(file1.toString().lastIndexOf(File.separator) + 1));
            }
        }
        System.out.println("-----===== FOLDERS ====-----");
        for (String s : dirList) {
            System.out.println("[" + s + "]");
        }
        System.out.println("-----===== FILES ====-----");
        for (String s : filesList) {
            System.out.println(s);
        }

    }

    public File changeDir(File file) throws IOException {
        System.out.println("type new path");
        String newPath = bufferedReader.readLine();

        File file_new;
        if (newPath.equals("..")){
            file_new  = new File(file.toString().substring(0, file.toString().lastIndexOf(File.separator) + 1));
        } else {
             file_new  = new File(file.toString() + file.separator + newPath);
        }
        String filePath = file_new.getPath() + file.separator;
        Menu.menu(filePath);
        return file_new;
    }

}