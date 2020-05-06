  
public class Driver
{
    public static void main(String[] args)
    {
        int nodesNum = 30000; //Can reach to 30,000 nodes, but causes memory leak since its a large matrix.
        Graph graph = new Graph(nodesNum);
        graph.initializeNodes(graph, nodesNum);

        for(int i = 0; i<5; i++)
        {
            System.out.print("Node " + i + "\'s ");
            graph.showVertex(i);
            System.out.print("Its routes are:\n");
            graph.showEdges(i);
        }

        int select = graph.search();
        graph.algorithmChoice(graph, select);
    }
}