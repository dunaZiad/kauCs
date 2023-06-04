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
import GraphFramework.Edge;
import GraphFramework.Vertex;
public class Line extends Edge{
    //CONSTRUCTORS
    public Line() {
        super();
    }

    public Line(int weight) {
        super(weight);
    }

    public Line(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }
}
