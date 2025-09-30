//Commit this baby on your Git/hub;

public class Vertex {

    String name;
    int cost;
    int toVertex;
    // default Constructor
    Vertex(){}
    //Loaded constructor
    Vertex(String name,int cost, int toVertex){
        this.name = name;
        this.cost = cost;
        this.toVertex = toVertex;
    }
    //Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void setToVertex(int toVertex){
        this.toVertex = toVertex;
    }
    //Getter Methods

    public String getName() {
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getToVertex() {
        return toVertex;
    }

}
