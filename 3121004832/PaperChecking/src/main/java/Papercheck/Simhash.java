package Papercheck;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.hankcs.hanlp.corpus.occurrence.TermFrequency;
import com.hankcs.hanlp.mining.word.TermFrequencyCounter;


public class Simhash {
    public static String MD5(String keyword){
        try {
            if(keyword==""){
                throw new MyException("文本出错");
            }
            MessageDigest md = MessageDigest.getInstance("MD5");//指定MD5加密
            BigInteger b=new BigInteger(1, md.digest(keyword.getBytes(StandardCharsets.UTF_8)));//进行加密
            return b.toString(2);//返回二进制的hash值
        } catch (NoSuchAlgorithmException | MyException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static String GetSimhash(String sentence){
        int[] v=new int[128];
        try {
            if(sentence.length()<10){
                throw new MyException("文本过短无意义");
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
        //计算词频并得出关键词
        TermFrequencyCounter counter = new TermFrequencyCounter();
        counter.add(sentence);
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for(TermFrequency keyword:counter){
            wordFreqMap.put(keyword.getTerm(), keyword.getFrequency());
        }
        //加权计算
        for (Map.Entry<String, Integer> entry : wordFreqMap.entrySet()){
            //获得hash值
            StringBuilder hash= new StringBuilder(Objects.requireNonNull(MD5(entry.getKey())));
            if(hash.length()<128){
                hash.append("0".repeat(Math.max(0, 128 - hash.length())));
            }
            //以词频作为权值
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
        StringBuilder simHash= new StringBuilder();
        for(int i=0;i<128;i++){
            if(v[i]>0){
                simHash.append("1");
            }
            else {
                simHash.append("0");
            }
        }
        return simHash.toString();
    }
}
