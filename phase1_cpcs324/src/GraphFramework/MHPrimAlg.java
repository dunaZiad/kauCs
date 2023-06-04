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
public class MHPrimAlg extends MSTAlgorithm{
    
    //MEthod Take Graph Object And Return Cost Of The MST Using Min-Heap Prim
    @Override
    public long displayResultingMST(Graph graph) {
        
        //If Graph Empty There Is Nothing To Print And Calculate 
        if (graph.vertex.isEmpty())
            return 0;

        //Create Varibles Needed In Code
        Set<Vertex> visited = new HashSet<>();
        Map<Vertex, Edge> mst = new HashMap<>(); 
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        
        //Choose Start Vertex And Add In HashSet
        Vertex startvertex = graph.vertex.values().iterator().next();
        visited.add(startvertex);

        //Add The Edge In MinHeap
        for (Edge edge : startvertex.getEdges()) {
            minHeap.add(edge);
        }


        while (!minHeap.isEmpty()) {
            Edge minEdge = minHeap.remove();
            Vertex fromNode = minEdge.getSource();
            Vertex toNode = minEdge.getTarget();

            if (visited.contains(fromNode) && visited.contains(toNode))
                continue;

            if (!visited.contains(fromNode)){
                if(!mst.containsKey(fromNode.getLabel())){
                    mst.put(fromNode, minEdge);
                }
                visited.add(fromNode);
            }

            if (!visited.contains(toNode)){
                if(!mst.containsKey(toNode.getLabel())){
                    mst.put(toNode, minEdge);
                }
                visited.add(toNode);
            }
            Vertex nextNode = visited.contains(fromNode) ? toNode : fromNode;

            for (Edge edge : nextNode.getEdges()) {
                minHeap.add(edge);
            }
        }
        
        // Print The Minimum Spanning Tree
        System.out.println("The Phone Network (Minimum Spanning Tree) Generated By Min-Heap Based Prim Algorithm Is As Follow: ");
        int totalWeight = 0;
        for (Edge edge : mst.values()) {
            if(mst.size() <= 100){
                System.out.println(edge);
            }else{   
            }
            totalWeight += edge.weight;
        }
        System.out.println("The Cost Of Designed Network: " + totalWeight);
        return totalWeight;
    }
    
}
