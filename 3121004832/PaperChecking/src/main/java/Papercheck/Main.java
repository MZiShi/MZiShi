package Papercheck;

public class Main {
    public static void main(String[] args){
        try{
            //读取路径
            String path1 = Filehandling.readTxt(args[0]);
            String path2= Filehandling.readTxt(args[1]);
            String resultFileName = args[2];
            //计算simhash值
            String simHash0 = Simhash.GetSimhash(path1);
            String simHash1 = Simhash.GetSimhash(path2);
            //计算相似度
            String similarity = HammingDistance.GetSimilarity(simHash0, simHash1);
            Filehandling.writeTxt(similarity, resultFileName);
            // 退出程序
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少参数");
        }


    }
}
