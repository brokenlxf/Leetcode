package com.broken.leetcode.service;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by lixufan
 * @classname Solution
 * @description LeetCode算法练习
 * @date 2020/9/16 2:58 下午
 */
public class Solution {
    /**
     * 功能描述: 罗马数字转阿拉伯数字<br>
     * 〈〉
     * @Param [s]
     * @Return int
     * @Author lixufan
     * @Date 2020/9/16 2:58 下午
     */
    static public int romanToInt(String s) {
        Map<String, Integer> romanNumerals= new HashMap<>();
        romanNumerals.put("I",1);
        romanNumerals.put("V",5);
        romanNumerals.put("X",10);
        romanNumerals.put("L",50);
        romanNumerals.put("C",100);
        romanNumerals.put("D",500);
        romanNumerals.put("M",1000);

        int sum=0;

        String[] numbersArray = s.split("");
        int temp=0;
        for (int i=numbersArray.length-1;i>=0;i--) {
            for(Map.Entry<String, Integer> entry : romanNumerals.entrySet()){
                String mapKey = entry.getKey();
                int mapValue = entry.getValue();
                if(numbersArray[i].equals(mapKey)){
                    if(mapValue<temp){
                        sum-=mapValue;
                    }else{
                        sum+=mapValue;
                    }
                    temp=mapValue;
                }
            }
        }
        return sum;
    }

    /**
     * 功能描述: 找出字符串共同部分，并返回<br>
     * 〈〉
     * @Param [strs]
     * @Return java.lang.String
     * @Author lixufan
     * @Date 2020/9/16 5:27 下午
     */
    static public String longestCommonPrefix(String[] strs) {
        //共同部分
        String commonStr="";
        int strMinLen=Integer.MAX_VALUE;

        if(strs.length==0){
            return "";
        }
        for (String str: strs) {
            if(str.length()<strMinLen){
                strMinLen=str.length();
            }
        }

        for (int i=1;i<=strMinLen;i++){
            String temp=strs[0].substring(0,i);
            int count=0;
            for (String str: strs) {
                if(str.substring(0,i).equals(temp)){
                    count++;
                }
            }
            if(count==strs.length){
                commonStr = temp;
            }
        }
        return commonStr;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }
}
