package a0binaryconverter;
import java.lang.Math;


/********************************************************************
 * Programmer:	E Chartrand
 * Class:       CS30S
 *
 * Assignment:     a1 binconvert
 * 
 * Description: my program will convert binary numbers to decimal numbers
 * Input: a 16 bit binary number from a text file.
 *
 * Output: the binary number converted to a decimal
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 //import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
 

public class binconvert {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
    // ********** declaration of variables **********
    
    	String strin;				// string data input from keyboard
    	String strout;				// processed info string to be output
    	
        String banner;                          //string for printing banners
    	String prompt;				// prompt for use in input dialogs
    	
        String[] tokens;            
    	String delim = "[ ,:]+";		// delimiter string for splitting input string
    	String tabSpace = "      ";	// six spaces
        
        char c;             //reads an individual digit as a char
        int count = 0;          //the count for the for loop
        int multiplier = 15;    //the exponent for the digit based on its place in the binary number
        int btennum = 0;        //the base ten number
        
    // create instances of objects for i/o and formatting
    
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("binData.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("Out.txt")));
    	
    // ********** Print output Banner **********
    // below are the mathod calls that tell the program to run the sub-program.
        
        printBanner();                      // print a banner to the output windowl
        fileBanner(fout);                   //prints a banner to outputfile
        banner = windowBanner();         // make a string to print in joption pane

JOptionPane.showMessageDialog(null, banner);    	
    
 	   	
    // ************************ get input **********************	
    
    // get input from the keyboard by calling the getNumber method
    // note the argument that is passed into the method
    // also note that since getNumber has a return type (int) you must use it
    // in a context where the returning value has someplace to go
        strin = fin.readLine(); //control statement
    
    
    // ************************ processing ***************************
          
    while(strin != null){
      System.out.println(strin);
      fout.println(strin);
       for (count = 0 ;count < strin.length(); count++){
         c = strin.charAt(count);//seperates each binary digit

            if (c == 49){ 
              btennum =  btennum + (int) Math.pow(2 , multiplier); //adds the value of an individual bit to the final number
            }// end if
        multiplier = multiplier - 1;// assigns the right value to the exponentto the bit
    }//end for

       System.out.println("final = " + btennum + "\n");//prints the base ten number
       fout.println("final = " + btennum + "\n");//prints the base ten number
      
       multiplier = 15;//resets multiplier
       btennum = 0;//resets btennum
      strin = fin.readLine(); //control statement 
    }//end while
    
    // ************************ print output ****************************
 
    //System.out.println(btennum);

        // ******** closing message *********
        
        System.out.println("end of processing.");
        fout.format("end of processing.");
        
        // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main

// ******************** static methods *****************************

    //************************************************
    // Purpose: get one int value from the keyboad
    // Interface: IN: string prompt
    // Returns: int read from keyboard buffer
    // *****************************************************
    public static int getNumber(String p, String banner, String promt){
        int n = 0;          // local varible to hold integer from keyboard buffer
        
        n = Integer.parseInt(JOptionPane.showInputDialog(banner, promt));
        return(n);
    } // end getNumber
    
    //************************************************
    // Purpose: print an output banner to the output window
    // Interface: IN: none
    // Returns: none
    // *****************************************************
    public static void printBanner(){
        System.out.println("*******************************************\\n");
        System.out.println("Name:		Evan Chartrand");
        System.out.println("Class:		CS30S");
        System.out.println("Assignment:	aibinconvert");
        System.out.println("*******************************************");
    }  // end print banner
    
    //************************************************
    // Purpose: print an output banner to the output file
    // Interface: IN: PrintWriter
    // Returns: none
    // *****************************************************
    public static void fileBanner(PrintWriter fo){
        fo.println("*******************************************");
        fo.println("Name:		Evan Chartrand");
        fo.println("Class:		CS30S");
        fo.println("Assignment:	aibinconvert");
        fo.println("*******************************************");    
    } // end fileBanner
    
    //************************************************
    // Purpose: Make an output banner string to use with message
    //          dialogs
    // Interface: IN: none
    // Returns: output banner string
    // *****************************************************
    public static String windowBanner(){
        // *** local variabls ***
        
        String banner;               // output banner for windows
        
        // **** create banner ****
        
        banner = "*******************************************\n";
        banner += "Name:		Evan Chartrand\n";
        banner += "Class:		CS30S\n";
        banner += "Assignment:	aibinconvert\n";
        banner += "*******************************************\n\n";  
        
        // *** return the banner ***
        
        return banner;           
    } // end windowBanner
}  // end clas