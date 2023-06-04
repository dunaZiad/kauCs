/*
CPCS-324 Project, Phase 1
Students Name            | ID         | Section
--------------------------------------------------
Duna Ziad Hejazi         | 2107548    | B0B
Hadeel Ali Alqarni       | 2105488    | B0B
Njoud Naji Alahmadi      | 2109470    | B0B
Sereen Hussain Baageel   | 2105237    | B0B
*/
package PhoneNetworkApp;
import GraphFramework.*;
import java.io.*;
import java.util.*;

public class PhoneNWDesignApp {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //READING DATA FROM INPUTCICSDATA.TXT FILE 
        File readFile = new File("input.txt");

        //CHICK IF THE FILE EXEST OR NOT
        if (!readFile.exists()) {
            System.out.println("Input file : " + readFile + ", does not exist.");
            System.exit(0);
        }

        //CREATE WRITING FILE 
        File outputFile = new File("Output.txt");


        //SCANNER FOR READ DATA FROM FILE 
        Scanner input = new Scanner(readFile);
        
        //---------------------------Requierment |1|----------------------------

        //Create a BluPrGraph Object To Inheretce All the Graph Attribute
        BluPrGraph graph = new BluPrGraph();
        
        //Call (readGraphFromFile) Method To Store Information Of Graph
        graph.readGraphFromFile(graph,readFile);
        
        System.out.println("");
        //---------------------------Requierment |2|----------------------------
        
        //Create a BluPrGraph Object To Inheretce All the Graph Attribute
        BluPrGraph graph1 = new BluPrGraph();
        
        //Call (makeGraph) To Randomly Generate Graph 
        graph.makeGraph(graph1);
    }
    
}
