package Papercheck;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
public class Filehandling {
    public static String readTxt(String txtPath) {

        try{
            if (!txtPath.endsWith(".txt")){
                throw new MyException("非txt类型文件");
            }
        }catch (MyException e){
            e.printStackTrace();
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
        String A=str.toString();
        String[] strings = {" ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;", "&amp;", "&lt;", "&gt;", "&quot;", "&qpos;"};
        for (String string : strings) {
            A= A.replaceAll(string, "");
        }
       A = Jsoup.clean(A, Whitelist.none());
        return A;
    }



    public static void writeTxt(String txtElem, String txtPath) {

        try{
            if (!txtPath.endsWith(".txt")){
                throw new MyException("非txt类型文件");
            }
        }catch (MyException e){
            e.printStackTrace();
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
