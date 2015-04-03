package RealEstate;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
    
    
    /**
 *
 * @Edited By Canchana
 */

    public ArrayList<String> addlist() {
        House1ist1.add(Lot_Number);
        House1ist1.add(FirstName);
        House1ist1.add(LastName);
        House1ist1.add(Price);
        House1ist1.add(No_Of_Bed);
        House1ist1.add(Square_Feet);

        return (House1ist1);
    }

    public void printlist(ArrayList arr) {
        System.out.println("printList");
        System.out.println("Array List:"+arr);
    }

    public void makeEmpty(ArrayList arr) {
        // finding size of this list
        int noofelements = arr.size();
         System.out.println("\n"+"makeEmpty");
        System.out.println("List consists of " + noofelements + " elements");
        System.out.println("Performing makeEmpty operation !");
        arr.clear();
//        Collections.<String> emptyList();
        noofelements = arr.size();
        System.out.println("Now, list consists of " + noofelements + " elements");
        if (arr.isEmpty()) {
            System.out.println("Empty"); // doesn't get displayed
        }
    }

    public void find(ArrayList arr) {
        int index = arr.indexOf(3);
        System.out.println("\n"+"find");
        System.out.println("Position of the First Element:"+index);  
    }
    
         public void removeLineFromFile(String file, int lineToRemove) {

        try {

            File inFile = new File(file);// gets the file which was send by the RealEstate

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");//checks the file whether it exist

                return;
            }
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");//new file .temp
            BufferedReader br = new BufferedReader(new FileReader(file));//read the orignal file
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));//writs the temp file

            String line = null;
            String[] result = null;
            boolean bool = false;

            
          
            while ((line = br.readLine()) != null) {//Read from the original file and write to the new
                if (!line.trim().equals(lineToRemove)) {  //unless content matches data to be removed.
                    result = line.split("\\s");
                    for (int x = 0; x < result.length; x++) {
                        if (x == 0) {
                            Lot_Number = result[x];
                            Lotno = Integer.parseInt(Lot_Number);
                        }
                    }
                    if (Lotno != lineToRemove) {
                        pw.println(line);
                        pw.flush();

                    } 
                }
            }
            pw.close();
            br.close();
            //Delete the Orignal file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");
            }
           //  System.out.println("Line has successfully deleted");
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }
         
    public static void main(String[] args) throws Exception {
        SortedList S = new SortedList();
        S.setinfo("2", "Raveen", "Jaya", "20,000", "4", "4000");
        ArrayList arr = new ArrayList();
        arr = S.addlist();
        S.printlist(arr);
        S.find(arr);
        S.insert(arr,"2","3",3);// comment makeempty method 
        S.Remove(arr);
        S.FindKTH(arr);
        S.makeEmpty(arr);
        
        File f = new File("RealEstale.txt");
        String b = S.readLines(f, 2);
        
        System.out.println(b);
        
        String Line1 = S.readLines(f,3);
        int Line = Integer.parseInt(Line1);
        S.removeLineFromFile("RealEstale.txt", Line);
    }

}
