package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

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

    public static void main(String[] args )
    {
    	port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            String input1 = req.queryParams("input1");
            ArrayList<Integer> inputIntList1=new ArrayList<>();
            
            if(input1.equals(""))
                inputIntList1=null;
            else
            {
                java.util.Scanner scan1=new java.util.Scanner(input1);
                scan1.useDelimiter("[;\r\n]+");
                while(scan1.hasNext())
                {
                 int val=Integer.parseInt(scan1.next().replaceAll("\\s",""));
                 inputIntList1.add(val);
                }
                scan1.close();
            }
            
            String input2 = req.queryParams("input2");
            ArrayList<Integer> inputIntList2 = new ArrayList<>();
            if(input2.equals(""))
                inputIntList2=null;
            else
            {
                java.util.Scanner scan2 = new java.util.Scanner(input2);
                scan2.useDelimiter("[;\r\n]+");
                while(scan2.hasNext())
                {
                 int val=Integer.parseInt(scan2.next().replaceAll("\\s",""));
                 inputIntList2.add(val);
                }
                scan2.close();
            }

            String input3 = req.queryParams("input3");
            int inputInt1;
            if(input3.equals("")) {
                inputInt1 = 0;
            }
            else
            {
                java.util.Scanner scan3= new java.util.Scanner(input3);
                scan3.useDelimiter("[;\r\n]+");
                inputInt1 = Integer.parseInt(scan3.next().replaceAll("\\s",""));
                scan3.close();
            }

            String input4 = req.queryParams("input4");
            int inputInt2;
            if(input4.equals("")) {
                inputInt2 = 0;
            }
            else
            {
                java.util.Scanner scan4= new java.util.Scanner(input4);
                scan4.useDelimiter("[;\r\n]+");
                inputInt2 = Integer.parseInt(scan4.next().replaceAll("\\s",""));
                scan4.close();
            }

            String input5= req.queryParams("input5");
            ArrayList<String> inputStringList = new ArrayList<>();
            if(input5.equals(""))
                inputStringList.add(null);
            else
            {
                java.util.Scanner scan5 = new java.util.Scanner(input5);
                while(scan5.hasNext())
                {
                    String val= scan5.nextLine();
                    inputStringList.add(val);
                }
                scan5.close();
            }

            String result=App.twoWordEncryption(inputIntList1,inputIntList2,inputInt1,inputInt2,inputStringList);

            Map map = new HashMap();
            map.put("result",result);

            return new ModelAndView(map,"compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute",
            (rq, rs) -> {
                Map map = new HashMap();
                map.put("result", "not computed yet!");
                return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
