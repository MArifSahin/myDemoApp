[![Build Status](https://travis-ci.org/MArifSahin/myDemoApp.svg?branch=master)](https://travis-ci.org/MArifSahin/myDemoApp)
    
    --TOBB ETU BIL481 HOMEWORK1--

	In this app, we will simply take 5 parameters which 2 of them are Integer
	ArrayList,2 of them are integer and 1 String ArrayList. This code do some 
	operations on integers and find 2 value after that and do some string operations
	using this values. Finally, we get encrypted 2 words of the set of strings
	we take as a parameters.

	Detailed informations of the steps:

	-multiply each of the elements in the first integer arraylist with the first integer
	and sum all of them.
	-Get mode by sum  in second integer and assign it as a key1.
	-do first two steps on the second integer arraylist with the same way and get key2.
	-Get in the middle of the character all of the strings in the String Arraylist.
	-increase all chars by key1 according to ascii values and add all of them in the new
	string respectively. Thus we have first encrypted word.
	-do previous step with using key2 and get second encrypted word.
	-Therefore, we have 2 encrypted words for the set of strings.