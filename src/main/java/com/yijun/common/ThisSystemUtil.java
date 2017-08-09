package com.yijun.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * Created by kinglas on 2017/7/28.
 */
public class ThisSystemUtil {
    public static final String KEY_MD5 = "MD5";
    public static  String  md5(String inputStr){
        BigInteger bigInteger=null;
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
            bigInteger = bigInteger.abs();
        } catch (Exception e) {e.printStackTrace();}
        System.out.println("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }
    /*public static void main(String[] args) {
        System.out.println(md5("666666"));
    }*/
    public static Integer parseInt(String target,Integer defaultValue){
        try{
            return Integer.parseInt(target.trim());
        }catch (Exception e){
            return defaultValue;
        }
    }
    public static String uuid(){
        String uuid = UUID.randomUUID().toString();
        int j = 0;
        char[] cs = new char[32];
        for (int i=0;i<uuid.length();i++){
            if ('-'!=(uuid.charAt(i))){
                cs[j] = uuid.charAt(i);
                j++;
            }
        }
        System.out.println(uuid);
        return new String(cs);
    }
    public static void main(String[] args) {
        System.out.println(uuid());
    }
}
