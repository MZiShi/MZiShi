package Papercheck;
import java.io.*;

public class Filehandling {
    public static String readTxt(String txtPath) {
        if (!txtPath.endsWith(".txt")){
            throw new MyException("非txt类型文件");

        }
        StringBuilder str = new StringBuilder();
        String strLine;

        //将txt文件按行读入 str中
        File file = new File(txtPath);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            //字符串拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                str.append(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }



    public static void writeTxt(String txtElem, String txtPath) {

        if (!txtPath.endsWith(".txt")){
            throw new MyException("非txt类型文件");

        }
        File file = new File(txtPath);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(txtElem);
            fileWriter.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
