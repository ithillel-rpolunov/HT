package HT_L2;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public  Map<String, ArrayList<String>> getListing(File file){
        ArrayList<String> filesList = new ArrayList<>();
        ArrayList<String> dirList = new ArrayList<>();
        File[] listArray = file.listFiles();
        Map<String, ArrayList<String>> arrayListMap = new HashMap<>();

        file.listFiles();

        for (File file1 : listArray) {
            if (file1.isDirectory()){
                dirList.add(file1.toString().substring(file1.toString().lastIndexOf(File.separator) + 1));
            }
            if (file1.isFile()){
                filesList.add(file1.toString().substring(file1.toString().lastIndexOf(File.separator) + 1));
            }
        }

        arrayListMap.put("folders",dirList);
        arrayListMap.put("files",filesList);
        return arrayListMap;
    }

    public void contentPrinter(String fileORFolder,  Map<String, ArrayList<String>> arrayListMap){
        ArrayList<String> stringArrayList;

        switch (fileORFolder){
            case "folders":
                stringArrayList = arrayListMap.get("folders");
                System.out.println("-----===== FOLDERS ====-----");
                for (String s : stringArrayList) {
                    System.out.println(s);
                }
                break;
            case "files":
                stringArrayList = arrayListMap.get("files");
                System.out.println("-----===== FILES ====-----");
                for (String s : stringArrayList) {
                    System.out.println(s);
                }
                break;
            case "all":
                stringArrayList = arrayListMap.get("folders");
                System.out.println("-----===== FOLDERS ====-----");
                for (String s : stringArrayList) {
                    System.out.println(s);
                }
                stringArrayList = arrayListMap.get("files");
                System.out.println("-----===== FILES ====-----");
                for (String s : stringArrayList) {
                    System.out.println(s);
                }
                break;
        }
    }

    public File changeDir(File file) throws IOException {
        contentPrinter("folders", getListing(file));
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

    public void findWordOccurrenceInFile(File file) throws IOException {

//        System.out.println(file);
        contentPrinter("files", getListing(file));

        BufferedReader stringBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nInput name of file");
        String fileToSearchIn = stringBufferedReader.readLine();
        File file1 = new File(file.getPath() + file.separator + fileToSearchIn);

        System.out.println("\nInput word");
        String wordToSearch = stringBufferedReader.readLine();

        String line;
        int counter = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        while ((line = bufferedReader.readLine()) != null){
            List<String> strings =  Arrays.asList(line.split(" "));
            for (String string : strings) {
                if (string.contentEquals(wordToSearch)){
                    counter++;
                }
            }
        }
        System.out.println("Was founded " + counter + " " + wordToSearch);
        return;
    }

    public void replaceWordInFile(File file) throws IOException {
        contentPrinter("files", getListing(file));

        BufferedReader stringBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nInput name of file");
        String fileToSearchIn = stringBufferedReader.readLine();
        File file1 = new File(file.getPath() + file.separator + fileToSearchIn);

        System.out.println("\nInput word");
        String wordToReplace = stringBufferedReader.readLine();

        System.out.println("\nInput new word");
        String newWord = stringBufferedReader.readLine();

        String line, lineWithReplase;
        String newline = "";
//        lineWithReplase = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        while ((line = bufferedReader.readLine()) != null){
            newline = newline + line + "\n";
        }
        bufferedReader.close();

        lineWithReplase = newline.replaceAll(wordToReplace, newWord);
        System.out.println(lineWithReplase);
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write(lineWithReplase);
        fileWriter.flush();
        fileWriter.close();
        return;

    }

    public void showLineNumbersWhereWordWasFound(){

    };


}