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

public class Edge {
    
    //ATTRIBUTES
    public int weight;
    public Vertex source;
    public Vertex target;
    private Vertex parent;

    //------------------------------------------------
    
    //CONSTRUCTERS
    public Edge(){
    } 
    
    public Edge(int weight){
        this.weight=weight;  
    }
    
    public Edge(Vertex source,Vertex target,int weight){
        this.source= source;
        this.target= target;  
        this.weight=weight;
    }

    //------------------------------------------------

   //GETTERS AND SETTERS
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    //------------------------------------------------
    //METHODS
    //Methods To Display Information
    public void displayInfo(){
       System.out.print("weight Is : " + weight + "Sourse Is : " + source.getLabel() + "Target Is : " + target.getLabel());  
    }
    
    @Override
    public String toString() {
        return source + " - " + target + ": line length: " + weight;
    }

    
}
