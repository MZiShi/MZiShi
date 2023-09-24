package maker;

import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            String str1=args[0];
            String str2=args[2];
            int scope=1;
            int quality=0;
            String path1="";
            String path2="";
            switch (str1){
                case "-n":quality= Integer.parseInt(args[1]);break;
                case "-r":scope= Integer.parseInt(args[1]);break;
                case "-e":path1=args[1];break;
                case "-a":path2=args[1];break;
                default:throw new MyException("参数类型错误");
            }

            switch (str2){
                case "-n":quality= Integer.parseInt(args[3]);break;
                case "-r":scope= Integer.parseInt(args[3]);break;
                case "-e":path1=args[3];break;
                case "-a":path2=args[3];break;
                default:throw new MyException("参数类型错误");
            }
            if((str1.equals("-n") && str2.equals("-r"))||(str1.equals("-r") && str2.equals("-n"))){
                if(scope<1||quality<=0){
                    throw  new MyException("参数错误");
                }else{
                    List<List<String>> equation=Generate.EquationCreate(quality,scope);
                    List<String> answer=Generate.Answer(equation);
                    read.writeTxt(equation,answer,"Exercises.txt","Answers.txt");
                }
            }
            else if((str1.equals("-e") && str2.equals("-a"))||(str1.equals("-a") && str2.equals("-e"))){
                if((!path1.endsWith(".txt"))||(!path2.endsWith(".txt"))){
                    throw new MyException("非txt类型文件");
                }else{
                    Determine.determine(path1,path2,"Grade.txt");
                }
            }
            else {
                throw new MyException("参数组合错误");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少参数");
        }catch (MyException e){
            System.out.println(e);
        }


    }
}
