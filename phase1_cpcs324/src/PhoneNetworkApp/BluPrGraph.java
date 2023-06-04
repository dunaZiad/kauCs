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
public class BluPrGraph extends Graph{

    //CONSTRUCTORS
    public BluPrGraph(boolean equals) {
    }
    
    public BluPrGraph() {   
    }

    public BluPrGraph(int veticesNo, int edgeNo, boolean isDigraph) {
        super(veticesNo, edgeNo, isDigraph);
    }

    //----------------------------------------------
    //METHODS

    //Method To Add Vertex Override From Grapph Class
    @Override
    public Vertex addVertex(String label) {
        return this.vertex.putIfAbsent(label, new Office(label));
    }
    
    //--------------------------------------------------------------------------
    
    //Method To Add Edge Override From Grapph Class
    @Override
    public void addEdge(Graph graph,Vertex source, Vertex target, int weight) {

        //CREATE NEW EDGE
        Line e = createEdge(source,target,weight);
        e.setSource(source);
        e.setTarget(target);
        e.setWeight(weight);

        
        //CREATE NEW VERTEX
        Office sourceNode = (Office) graph.vertex.get(String.valueOf(e.getSource().getLabel()));
        Office targetNode = (Office) graph.vertex.get(String.valueOf(e.getTarget().getLabel()));


        if (sourceNode.equals(null))
            throw new IllegalArgumentException();

        if (targetNode == null)
            throw new IllegalArgumentException();

        // ADD EDGES TO VERTEX'S EDGELIST
        sourceNode.addEdge(sourceNode,targetNode,weight,isIsDigraph());
    }
    
    //--------------------------------------------------------------------------
    
    //Method To Create Edge Override From Grapph Class
    public Line createEdge(Vertex source,Vertex target,int weight){  
      return new Line();
      
    }

    //--------------------------------------------------------------------------

    //Method To Read Graph From File Override From Grapph Class
    @Override
    public void readGraphFromFile(Graph graph,File readFile) throws FileNotFoundException {

        Scanner input = new Scanner(readFile);
        
        //line[0] = digraph, line[1] = 0, Then Create New Undirected BluPrGraph Graph
        String[] line = input.nextLine().split(" ");   
        graph = new BluPrGraph(line[1].equals("1"));
        line = input.nextLine().split(" ");
        
        int numberOfEdges = Integer.parseInt(line[1]);

        //Create Vertex Then Add Edge
        while (numberOfEdges-- > 0){
            line = input.nextLine().split(" ");
            graph.addVertex(line[0]);        
            graph.addVertex(line[1]);          
            graph.addEdge(graph,new Office (line[0]),new Office (line[1]), Integer.parseInt(line[2]));
 
        }

        //Create MHPrimAlg Object And Print The MST By Prim Min-heap Based
        MHPrimAlg prim = new MHPrimAlg();
        prim.displayResultingMST(graph);
        
        System.out.println();

        //Create KruskalAlg Object And Print The MST By Kruskal
        KruskalAlg Kruskal = new KruskalAlg();
        Kruskal.displayResultingMST(graph);

    }
    

    //Method To Randomly Generate Graph, Override From Grapph Class
    @Override
    public void makeGraph(Graph graph){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please Choice One Of The Cases To Test (Where n is number of vertices and m is number of edges) : ");
        System.out.println("1. n = 1,000  - m = 10,000");
        System.out.println("2. n = 1,000  - m = 15,000");
        System.out.println("3. n = 1,000  - m = 25,000");
        System.out.println("4. n = 5,000  - m = 15,000");
        System.out.println("5. n = 5,000  - m = 25,000");
        System.out.println("6. n = 10,000 - m = 15,000");
        System.out.println("7. n = 10,000 - m = 25,000");
        System.out.print("Enter Your Choice : ");
        int choice = input.nextInt();
        System.out.println("\n");
        
        //If User Enter Wrong Choice 
        while (choice < 1 || choice > 7) {
            System.out.println("Wrong Choice, Please Chose A Correct Choice : ");
            System.out.print("Enter Your Choice : ");
            choice = input.nextInt();
            System.out.println("\n"); 
        }
        
        //Set The Number Of Vertices And Edges
        int numberOfVertecies = 0;
        int numberOfEdge = 0;
        switch (choice) {
            case 1: {
                numberOfVertecies = 1000;
                numberOfEdge = 10000;
                break;
            }
            case 2: {
                numberOfVertecies = 1000;
                numberOfEdge = 15000;
                break;
            }
            case 3: {
                numberOfVertecies = 1000;
                numberOfEdge = 25000;
                break;
            }
            case 4: {
                numberOfVertecies = 5000;
                numberOfEdge = 15000;
                break;
            }
            case 5: {
                numberOfVertecies = 5000;
                numberOfEdge = 25000;
                break;
            }
            case 6: {
                numberOfVertecies = 10000;
                numberOfEdge = 15000;
                break;
            }
            case 7: {
                numberOfVertecies = 10000;
                numberOfEdge = 25000;
                break;
            }   
        }

        //Create New Grap 
        graph = new BluPrGraph(numberOfVertecies,numberOfEdge,false);
        Random random = new Random();
        ArrayList<Integer> checkList = new ArrayList<>(numberOfVertecies);

        Office source = null;
        Office target = null;

         for (int i = 0; i < numberOfVertecies ; i++) {
            int randomLabel = random.nextInt(numberOfVertecies);
            if (!checkList.contains(randomLabel)) {
                Office ve =  new Office(String.valueOf(randomLabel));
                checkList.add(randomLabel);
            } 
            else {
                --i;
            }
        }
    
        // Create Nessesry Edge With Random Range From 1 - 20 
        for (int i = 0; i < numberOfVertecies - 1; i++) {
            int randomWeight = random.nextInt(10) + 1;
            
            source = new Office(String.valueOf(i));
            target = new Office(String.valueOf(i + 1));
            
            graph.addVertex(source.getLabel());        
            graph.addVertex(target.getLabel());          
            graph.addEdge(graph,source,target, randomWeight);  
        }
        
        //Calculate Remainig Edges 
        int remaning = numberOfEdge - (numberOfVertecies - 1);
        
        //Add The Remain Edge
        for (int i = 0; i < remaning; i++) {

            String sourceId = String.valueOf( (int)( Math.random() * numberOfVertecies) );
            String destinationId = String.valueOf( (int)( Math.random() * numberOfVertecies) );

            //To Make Sure Don't Add A Duplicated Edge
            if (sourceId.equalsIgnoreCase(destinationId) || graph.isDuplicated(source, target) || graph.isDuplicated(target, source)) {
               --i; 
               continue; 
            }
            
            int randomWeight = (int) (1 + Math.random() * 10);
            graph.addEdge(graph,new Office (source.getLabel()),new Office (target.getLabel()), randomWeight);
            addEdge(graph, source, target, randomWeight); 
        }
        
            //Call Prim And Kruskal Then Print Running Time And Cost For Each
            MHPrimAlg prim = new MHPrimAlg();
            double startTime_primMH = System.nanoTime();
            long primCost = prim.displayResultingMST(graph);
            double finishTime_primMH = System.nanoTime();
            System.out.println("Total runtime of Prim's MinHeap Algorithm : " + ((finishTime_primMH - startTime_primMH) / 1000000) + " ns.");
            
            System.out.println("------------------------------------------------");
            
            KruskalAlg Kruskal = new KruskalAlg();
            double startTime_Kruskal = System.nanoTime();
            long KruskalCost = Kruskal.displayResultingMST(graph);
            double finishTime_Kruskal = System.nanoTime();
            System.out.println("Total runtime of Kruskal Algorithm : " + ((finishTime_Kruskal - startTime_Kruskal) / 1000000) + " ns.");
            
    }
    
    
    
    //Method To Make Sure No Duplicated
    @Override
    public boolean isDuplicated(Vertex SourceId, Vertex DestinationId){
        //Walk Through All The Edge 
        for (Edge edge : SourceId.getEdges()) { 
            if ((edge.getSource().getLabel().equalsIgnoreCase(SourceId.getLabel()) && edge.getTarget().getLabel().equalsIgnoreCase(DestinationId.getLabel()))) {
                return true;
            }
        }
        return false;
    }
    
  
}


