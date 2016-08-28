package HT_L2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String number = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("C:\\Hillel_QAA");
        String filePath = file.getPath() + file.separator;
        FileActions fileActions = new FileActions();
        Menu.menu(filePath);
        while (!number.equals("exit")) {

//            System.out.println("You are at [" + file.getCanonicalPath().substring(0, file.getCanonicalPath().lastIndexOf(File.separator)+1) + "] directory");

            number = bufferedReader.readLine();
            int inumb = Integer.parseInt(number);

            switch (inumb){
                case 1:
                    fileActions.fileCreator(file, filePath);
                    break;
                case 2:
                    fileActions.fileDeleter(file, filePath);
                    break;
                case 3:
                    fileActions.fileRenamer(file, filePath);
                    break;
                case 4:
                    fileActions.contentPrinter("all", fileActions.getListing(file));
                    break;
                case 5:
                    file = fileActions.changeDir(file);
                    filePath = file.getPath() + file.separator;
                    break;
                case 6:
                    fileActions.findWordOccurrenceInFile(file);
                    break;
                case 7:
                    fileActions.replaceWordInFile(file);
                    break;
                case 0:
                    return;
            }



            //текущее расположение!!!!

            //создать файл
            //удалить файл
            //переименовать файл
            //открыть файл

        }

    }
}
