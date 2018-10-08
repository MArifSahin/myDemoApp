package com.mycompany.app;
import java.util.*;
public class App
{
    public static String twoWordEncryption(ArrayList<Integer> fir, ArrayList<Integer> sec,int val1, int val2, ArrayList
    <String> s){
    	if(s==null)
    		return null;
    	if(fir==null)
    		return null;
        if(sec==null)
    		return null;
        int key1=0,key2=0;
        for(int a:fir){
            key1+=a*val1;
        }
        key1=key1%val2;
        for(int b:sec){
            key2+=b*val1;
        }

        key2=key2%val2;
        String firstWord="",secondWord="";
        for(String k: s){
        	char c=0;
        	if(k.length()>0)
        		c=(char)(k.charAt(k.length()/2-1)+key1);
        	else
        		return null;
            firstWord+=""+c;
        }
        for(String k: s){
        	char c=0;
        	if(k.length()>0)
        		c=(char)(k.charAt(k.length()/2-1)+key2);
        	else
        		return null;
            secondWord+=""+c;
        }
        return "Encrypted: "+firstWord+" "+secondWord;
    }
}

