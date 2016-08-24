package HT_L2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String number = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("C:\\Hillel_QAA");
        String filePath = file.getPath() + file.separator;

        Menu.menu(filePath);
        while (!number.equals("exit")) {

//            System.out.println("You are at [" + file.getCanonicalPath().substring(0, file.getCanonicalPath().lastIndexOf(File.separator)+1) + "] directory");

            number = bufferedReader.readLine();
            int inumb = Integer.parseInt(number);

            if(inumb == 1){
                FileActions fileActions = new FileActions();
                fileActions.fileCreator(file, filePath);
            }
            if(inumb == 2){
                FileActions fileActions = new FileActions();
                fileActions.fileDeleter(file, filePath);
            }
            if(inumb == 3){
                FileActions fileActions = new FileActions();
                fileActions.fileRenamer(file, filePath);
            }
            if(inumb == 4) {
                FileActions fileActions = new FileActions();
                fileActions.getListing(file);
            }
            if(inumb == 5) {
                FileActions fileActions = new FileActions();
                file = fileActions.changeDir(file);
                filePath = file.getPath() + file.separator;
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
