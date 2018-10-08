package com.mycompany.app;

import java.util.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
    	 ArrayList<Integer> fir=new ArrayList<Integer>();
         fir.add(3);fir.add(265);fir.add(45);fir.add(8);fir.add(11);fir.add(5);fir.add(42);
         ArrayList<Integer> sec=new ArrayList<Integer>();
         sec.add(2);sec.add(3);sec.add(66);sec.add(2);sec.add(3);sec.add(52);sec.add(16);
         ArrayList<String> s=new ArrayList<String>();
         s.add("Amerika");s.add("eofuewnv");s.add("qworfn");s.add("Aqwepq");
         int val1=11;
         int val2=5;
		assertEquals(App.twoWordEncryption(fir, sec, val1, val2, s),"Encrypted: iys{ iys{");
    }
    public void test2App()
    {
    	ArrayList<Integer> fir=new ArrayList<Integer>();
        fir.add(32);fir.add(165);fir.add(85);fir.add(84);fir.add(311);fir.add(555);fir.add(482);
        ArrayList<Integer> sec=new ArrayList<Integer>();
        sec.add(256);sec.add(311);sec.add(623);sec.add(4);sec.add(5);sec.add(5);sec.add(169);
        ArrayList<String> s=new ArrayList<String>();
        s.add("Amerifawfn");s.add("eofuewaweteıan");s.add("qrgserınfn");s.add("Aqgrsernıg");
        int val1=33;
        int val2=6;
		assertEquals(App.twoWordEncryption(fir, sec, val1, val2, s),"Encrypted: iaes ldhv");
    }
    public void testNullString()
    {
        ArrayList<Integer> fir=new ArrayList<Integer>();
        fir.add(32);fir.add(165);fir.add(85);fir.add(84);fir.add(311);fir.add(555);fir.add(482);
        ArrayList<Integer> sec=new ArrayList<Integer>();
        sec.add(256);sec.add(311);sec.add(623);sec.add(4);sec.add(5);sec.add(5);sec.add(169);
        ArrayList<String> s=null; //null string arraylist
        int val1=33;
        int val2=6;
        assertNull(App.twoWordEncryption(fir, sec, val1, val2, s));
    }
    public void testNullList()
    {
        ArrayList<Integer> fir=null;
        ArrayList<Integer> sec=null;
        ArrayList<String> s=new ArrayList<String>(); //null string arraylist
        int val1=33;
        int val2=6;
        assertNull(App.twoWordEncryption(fir, sec, val1, val2, s));
    }
    public void testEmptyString()
    {
        ArrayList<Integer> fir=new ArrayList<Integer>();
        fir.add(32);fir.add(165);fir.add(85);fir.add(84);fir.add(311);fir.add(555);fir.add(482);
        ArrayList<Integer> sec=new ArrayList<Integer>();
        sec.add(256);sec.add(311);sec.add(623);sec.add(4);sec.add(5);sec.add(5);sec.add(169);
        ArrayList<String> s=new ArrayList<String>(); //null string arraylist
        s.add("");
        int val1=33;
        int val2=6;
        assertNull(App.twoWordEncryption(fir, sec, val1, val2, s));
    }
}
