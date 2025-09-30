
//Implementing this interface so i can still compare edges late on
public class Edge implements Comparable<Edge> {

    int from;
    int to;
    int weight;

    //Constructors
    Edge(){}

    Edge(int from,int to,int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    //Setter Methods

    public void setTo(int to) {
        this.to = to;
    }
    public void setCost(int weight){
        this.weight = weight;
    }
    public void setFrom(int from){
        this.from = from;

    }
    //Getter
    public int getFrom(){
        return from;
    }
    public int getTo(){
        return to;
    }
    public int getWeight(){
        return  weight;
    }

    //Compare to Edges
    //
    //sorting from ascending
    public int compareTo(Edge other) {
        return this.weight - other.weight;
        }

}


