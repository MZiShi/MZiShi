package maker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class read {
    public static void writeDeyermine(List right,List wrong, String Path){

            String strright="Correct: "+right.size()+" ( "+String.join(" ",right)+ ")";
            String strwrong="Correct: "+wrong.size()+" ( "+String.join(" ",wrong)+" )";
            File filelist = new File(Path);
            FileWriter fileWriterlist;
            try {
                fileWriterlist = new FileWriter(filelist, true);
                fileWriterlist.write(strright);
                fileWriterlist.write("\r\n");
                fileWriterlist.write(strwrong);
                fileWriterlist.write("\r\n");
                // 关闭资源
                fileWriterlist.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public static List<String> readTxt(String listPath) {
        String str;
        String strLine;
        List<String> list=new ArrayList<>();
        // 将 txt文件按行读入 str中
        File file = new File(listPath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 字符串拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                if(strLine.equals(" ")) {continue;}
                String[] a=strLine.split("\\.");
                list.add(a[1]);

            }
            // 关闭资源
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void writeTxt(List<List<String>> list,List<String> resultlist, String listPath,String resultPath){

        for (int i=0;i<resultlist.size();i++){
            int z=i+1;
            String str=z+"."+String.join(" ",list.get(i));
            String result =z+"."+resultlist.get(i);
            File filelist = new File(listPath);
            FileWriter fileWriterlist;

            File fileresult = new File(resultPath);
            FileWriter fileWritersult;

            try {
                fileWriterlist = new FileWriter(filelist, true);
                fileWriterlist.write(str);
                fileWriterlist.write("\r\n");
                // 关闭资源
                fileWriterlist.close();

                fileWritersult = new FileWriter(fileresult, true);
                fileWritersult.write(result);
                fileWritersult.write("\r\n");
                // 关闭资源
                fileWritersult.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

