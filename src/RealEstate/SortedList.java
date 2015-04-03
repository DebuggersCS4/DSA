/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealEstate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Susanda
 */
public class SortedList {
    
    String Lot_Number, FirstName, LastName, Price, No_Of_Bed, Square_Feet;
    ArrayList<String> House1ist1 = new ArrayList<String>();
    static int Lotno;
    public String findvalue;
    

  


    public void setinfo(String Lot, String FN, String LN, String Prc, String NOB, String SF) {
        Lot_Number = Lot;
        FirstName = FN;
        LastName = LN;
        Price = Prc;
        No_Of_Bed = NOB;
        Square_Feet = SF;
    }
     public void insert(ArrayList arr,String Doors,String Windows,int indextoadd ){
        System.out.println("\n"+"insert");
        arr.add(Doors);
        System.out.println("Insert to the end"+arr);
        arr.add(indextoadd ,Windows);
        System.out.println("Insert to the 3rd position"+arr);
    }
    
    public void Remove(ArrayList arr){
        System.out.println("\n"+"remove");
        // Removes element at 3rd position
        arr.remove(2);
        System.out.println("Now, Size of list: " + arr.size());
        System.out.println("Removed element at 3rd position"+arr);
    }
    
    public void FindKTH(ArrayList arr){
        System.out.println("\n"+"findkth");
      System.out.println("Array List:"+arr);  
    int retval=arr.indexOf("20,000");
    System.out.println("The element 100 is at index " + retval);
}
    
   
    
    
    public String readLines(File file, int findvalue) throws Exception {
        String line = null;
        
        int fv = findvalue;
        String thisLine = null;
        java.util.List<String> results = new ArrayList<String>();
        FileReader fr = new FileReader("RealEstale.txt");//Read the file
        BufferedReader br = new BufferedReader(fr);
        try {
            
            while ((thisLine = br.readLine()) != null) { //reads the file line by line
//                results.clear();
                results.add(thisLine);//adds the line into an arraylist
                // System.out.println(thisLine);
                String[] result = thisLine.split("\\s");// get the current line , split it and add it a result string
                for (int x = 0; x < result.length; x++) {// got through the string
                    if (x == 0) {
                        Lot_Number = result[x];
                        Lotno = Integer.parseInt(Lot_Number);// equate it to variable the first string
                    } 
                }
                if (Lotno == fv) {//checks whether the variable is equale the ArrayList we are gonna delete
                   line=thisLine;//if so equal it to a variable
                }

            }
        } catch (IOException | NumberFormatException e) {
        }
         finally{
            fr.close();
            br.close();
        }
        
       return line; // pass back the variable to ensure its already and a element in the file

    }
    
    
}
