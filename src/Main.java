import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    //main
    public static void main (String[] args)  {



        List<Edge> edges = new ArrayList<>();
        int numVertices = 0; // to track the highest vertex index

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\CSC212-Term-4\\src\\graph1.txt"));

            //reading from a file;
            String line;

            while((line = reader.readLine()) != null){

                String[] parts = line.split(" ");

                for(int i = 0;i< parts.length;i++){
                    //append each element you get to parts
                    System.out.println(parts[i]);
                }

                int from = mapLetterToNumber(parts[0]);
                int to = mapLetterToNumber(parts[1]);
                int weight = Integer.parseInt(parts[2]);

                edges.add(new Edge(from,to,weight));

                //Keeping track of largest index for numer ofvertices
                numVertices = Math.max(numVertices, Math.max(from,to));


            }reader.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Kruskal
        Collections.sort(edges); // uses compareTo in Edge
        UnionFind uf = new UnionFind();
        uf.makeSet(numVertices + 1); //initialized unionFInd

        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;

        for (Edge e : edges) {
            //i will only add edge if it connects two seperate componets
            if (uf.find(e.getFrom()) != uf.find(e.getTo())) { //connect them
                uf.union(e.getFrom(), e.getTo()); //merge sets
                mst.add(e); //add to mst
                totalCost += e.getWeight();
            }
        }

        //output
        for( Edge e: mst){
            System.out.println(mapNumberToLetter(e.getFrom()) + " " +
                    mapNumberToLetter(e.getTo()) + " " +
                    e.getWeight());
        }

        System.out.println();
        System.out.println("Qn 1:");
        System.out.println("- Minimum cost of keeping the cities connected is " + totalCost);
        System.out.println("- Algorithm used is Kruskal because it sorts edges by weight " +
                "and builds the MST greedily.");

        }

    private static int mapLetterToNumber(String letter){
        return letter.charAt(0) - 'A';
    }

    private static String mapNumberToLetter(int number){
        return String.valueOf((char) ('A' + number));
    }
}
