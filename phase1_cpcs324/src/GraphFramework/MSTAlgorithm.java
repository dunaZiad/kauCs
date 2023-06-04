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
public abstract class MSTAlgorithm{
    Edge[] MSTResultList;
    
    //Mrthod Take Graph Object And Return Cost Of The MST Using Eather Min-Heap Prim Or Kruskal 
    public abstract long displayResultingMST(Graph graph);
        
}
