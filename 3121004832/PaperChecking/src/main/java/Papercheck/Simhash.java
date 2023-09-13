package Papercheck;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
public class Simhash {
    public static String MD5(String keyword){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//指定MD5加密
            md.update(keyword.getBytes(StandardCharsets.UTF_8));
            BigInteger b=new BigInteger(1, md.digest());//进行加密
            return b.toString(2);//返回二进制的hash值
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static String GetSimhash(String sentence){
        int[] v=new int[128];
        List<Term> keyList = HanLP.segment(sentence);//分词
        Map<String, Integer> wordFreqMap = new HashMap<>();
        //计算词频作为权重
        for(Term keyword:keyList){
            if (wordFreqMap.containsKey(String.valueOf(keyword))) {
                // 如果单词已经在Map中，则增加其频率计数
                wordFreqMap.put(String.valueOf(keyword), wordFreqMap.get(String.valueOf(keyword)) + 1);
            } else {
                // 如果单词不在Map中，则将其添加到Map，并将频率计数设置为1
                wordFreqMap.put(String.valueOf(keyword), 1);
            }

        }
        //加权计算
        for (Map.Entry<String, Integer> entry : wordFreqMap.entrySet()){
            StringBuilder hash= new StringBuilder(MD5(entry.getKey()));
            if(hash.length()<128){
                hash.append("0".repeat(Math.max(0, 128 - hash.length())));
            }
            for(int j=0;j<128;j++){
                if(hash.charAt(j)=='1'){
                    v[j]+= entry.getValue();
                }
                else{
                    v[j]-= entry.getValue();
                }
            }
        }
        //计算simhash值
        StringBuilder simhash= new StringBuilder();
        for(int i=0;i<128;i++){
            if(v[i]>0){
                simhash.append("1");
            }
            else {
                simhash.append("0");
            }
        }

        return simhash.toString();
    }

}
