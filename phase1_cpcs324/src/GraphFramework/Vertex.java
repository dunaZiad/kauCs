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
import java.util.*;

public class Vertex {
    
    //ATTRIBUTES
    private String label;
    private boolean isVisited;
    private List<Edge> adjList = new ArrayList<>();

    //--------------------------------------------------------
 
    //CONSTRUCTERS
    public Vertex(String label){
        this.label=label; 
    }

    //--------------------------------------------------------

    //GETTERS AND SETTERS
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public List<Edge> getEdges() {
        return adjList;
    }


    public void setAdjList(List<Edge> adjList) {
        this.adjList = adjList;
    }

    //--------------------------------------------------------

    //Method To Display Information About Vertex
    public void displayInfo(){
        System.out.print(label); 
    }
    @Override
        public String toString() {
            return "Office No." + label;
        }
        
    //Method To Add Edge 
    public void addEdge(Vertex source,Vertex target,int weight,boolean directed){
        if (!directed){
            this.adjList.add(new Edge(source,target,weight));
            target.getEdges().add(new Edge(target,source,weight));
        }
        else {
            this.adjList.add(new Edge(source,target,weight));
        }
    }
    
}
