/*
CPCS-324 Project, Phase 1
Students Name            | ID         | Section
--------------------------------------------------
Duna Ziad Hejazi         | 2107548    | B0B
Hadeel Ali Alqarni       | 2105488    | B0B
Njoud Naji Alahmadi      | 2109470    | B0B
Sereen Hussain Baageel   | 2105237    | B0B
*/
package GraphFramework;
import PhoneNetworkApp.BluPrGraph;
import java.io.*;
import java.util.*;
public abstract class Graph{
    
    //ATTRIBUTES
    private int veticesNo;
    private int edgeNo;
    public boolean isDigraph = true;
    public Map<String, Vertex> vertex = new HashMap<>();

    //------------------------------------------------
    
    //CONSTRUCTERS
    public Graph(){
        this.veticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;    
    }
    
    public Graph(int veticesNo, int edgeNo, boolean isDigraph) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    //------------------------------------------------
    //METHODS
    
    //ABSTRACT METHOD TO ADD VERTEX INTO THE MAP
    public abstract Vertex addVertex(String label);
  
    //ABSTRACT METHOD TO ADD EDGE BETWEEN TWO VERTEXES 
    public abstract void addEdge(Graph graph,Vertex source,Vertex target,int weight);
    
    //ABSTRACT METHOD TO CREATE A LINE OPJECT FOR EDGE
    public abstract Edge createEdge(Vertex source,Vertex target,int weight);
    
    //ABSTRACT METHOD TO READ GRAPH INFORMATION FROM FILE
    public abstract void readGraphFromFile(Graph graph,File readFile) throws FileNotFoundException;
    
    //ABSTRACT METHOD TO Randomly Create Graph And Call The MST Algorithm 
    public abstract void makeGraph(Graph graph);
    
    //Method To Check Weather The Edge Between Two Vertices Exeist 
    public abstract boolean isDuplicated(Vertex SourceId, Vertex DestinationId);
        
}

    