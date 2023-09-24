package maker;

import java.util.ArrayList;
import java.util.List;

public class Determine {
    public static void determine(String listPath,String resultPath,String Path){
        List<String> list=read.readTxt(listPath);
        List<String> result=read.readTxt(resultPath);

        List<String> computeresult=new ArrayList<>();
        List<String> right=new ArrayList<>();
        List<String> wrong=new ArrayList<>();
        for (String s : list) {
            String[] liststring = s.split(" ");
            List<String> listlist = new ArrayList<>(List.of(liststring));
            computeresult.add(ComputeFourRule.Compute(ComputeFourRule.SuffExpression(listlist)));
        }
        for(int i=0;i<list.size();i++){
            if(computeresult.get(i).equals(result.get(i))){
                right.add(String.valueOf(i+1));
            }
            else wrong.add(String.valueOf(i+1));
        }
        read.writeDeyermine(right,wrong,Path);
    }

}
