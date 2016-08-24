package HT_L2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String number = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("C:\\Hillel_QAA");
        String filePath = file.getPath() + file.separator;

        while (!number.equals("exit")) {

//            System.out.println("You are at [" + file.getCanonicalPath().substring(0, file.getCanonicalPath().lastIndexOf(File.separator)+1) + "] directory");
            System.out.println("You are at [" + filePath + "] directory");
            System.out.println("------======------\n1. create file \n2. delete file\n3. rename file\n0. Exit\n------======------\n");

            number = bufferedReader.readLine();
            int inumb = Integer.parseInt(number);

            if(inumb == 1){
                FileCreator fileCreator = new FileCreator();
                fileCreator.fileCreator(file, filePath);
            }
            if(inumb == 2){
                System.out.println("Input file name");

                String deleteFile = bufferedReader.readLine();
                file = new File(filePath + file.separator + deleteFile);

                file.delete();
                System.out.println("\nFile " + file + " was deleted\n");
            }
            if(inumb == 3){
                System.out.println("Input file name to rename");

                String renameFile = bufferedReader.readLine();
                System.out.println("Input new file name");

                String newrenameFile = bufferedReader.readLine();
                File oldFile = new File(filePath + file.separator + renameFile);
                File newFile1 = new File(filePath + file.separator + newrenameFile);

                oldFile.renameTo(newFile1);

                System.out.println("File " + oldFile + " was renamed to " + newFile1 + "\n");
            }
            if (inumb == 0){
                break;
            }


            //текущее расположение!!!!

            //создать файл
            //удалить файл
            //переименовать файл
            //открыть файл

        }

    }
}
