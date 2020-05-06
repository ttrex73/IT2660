import java.util.*;
import javax.swing.JOptionPane;

class Graph
{
    private Listing[] vertex;
    private final Set<Edge> edges = new HashSet<>();
    private int max;
    private int numberOfVertices;
    private int nodeCheck = 0;
    private int selectNum = 0;
    

    Graph(int g)
    {
        vertex = new Listing[g];
        //edge = new int[g][g];
        max = g;
        numberOfVertices = 0;
    }

    private void depthFirstSearch(int firstVertex)
    {
        int v;
        Stack<Integer> nodeStack = new Stack<>();

        for(int i = 0; i<numberOfVertices; i++)
        {
            if (vertex[i] != null) {
                vertex[i].setPushed(false);
            }
        }
        nodeStack.push(firstVertex);
        vertex[firstVertex].setPushed(true);

        while (!nodeStack.empty())
        {
            v = nodeStack.pop();
            vertex[v].visit();
            nodeCheck++;
            for (int column = 0; column < numberOfVertices; column++)
            {

                if( isEdgeBetween(v,column) && vertex[column].getPushed())
                {
                    nodeStack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }
    private void breathFirstSearch(int firstVertex)
    {
        int V;
        Queue<Integer> nodeQueue = new LinkedList<>();

        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
                vertex[i].setPushed(false);
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPushed(true);

        while(!nodeQueue.isEmpty())
        {
            V = nodeQueue.remove();
            vertex[V].visit();
            nodeCheck++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if( isEdgeBetween(V,column) && vertex[column].getPushed())
                {
                    nodeQueue.add(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }

    private boolean isEdgeBetween(int fromVertex, int toVertex)
    {
        for(Edge edge : edges){
            if(edge.connects(fromVertex, toVertex)) return true;
        }

        return false;
    }

    private void dijkstra(int firstVertex)
    {
        int v;
        LinkedList<Integer> nodeQueue = new LinkedList<>();

        int i = 0;
        while (i < numberOfVertices)
        {
            if(vertex[i] != null)
                vertex[i].setPushed(false);
            i++;
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPushed(true);

        while(!nodeQueue.isEmpty())
        {
            v = nodeQueue.remove();
            vertex[v].visit();
            nodeCheck++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if( isEdgeBetween(v,column) && vertex[column].getPushed())
                {
                    nodeQueue.add(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }

    private void insertEdge(int fromVertex, int toVertex)
    {
        if(vertex[fromVertex] == null || vertex[toVertex] == null)
            return;
        edges.add(new Edge(fromVertex, toVertex));
    }

    void showEdges(int vertexNumber)
    {
        for(int column = 0; column < numberOfVertices; column++)
        {
            if(isEdgeBetween(vertexNumber,column))
            {
                System.out.println(vertexNumber + "," + column);
            }
        }
        System.out.println();
    }


    private void insertVertex(int vertexNumber, Listing newListing)
    {
        if(vertexNumber >= max)
        {
            return;
        }
        vertex[vertexNumber] = newListing.deepCopy();
        numberOfVertices++;
    }

    void showVertex(int vertexNumber)
    {
        System.out.print(vertex[vertexNumber]);
    }

    static class Edge{

        private final int fromVertex, toVertex;

        Edge(int fromVertex, int toVertex){
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
        }

        //@Override
        public boolean equals(Object obj)
        {
            if( ! (obj instanceof Edge)) return false;
            Edge other = (Edge)obj;
            return connects(other.fromVertex, other.toVertex);
        }

        boolean connects(int fromVertex, int toVertex){
            return fromVertex == this.fromVertex && toVertex == this.toVertex ||
                    fromVertex == this.toVertex && toVertex == this.fromVertex;
        }
    }

    void initializeNodes(Graph G, int nodesNum)
    {
        Random random = new Random();
        for (int i = 0; i < nodesNum; i++ )
        {
            Listing v = new Listing(random.nextInt(300000) + 1);
            G.insertVertex(i, v);
        }

        int vertexListNumber = G.vertex.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nodesNum; i++ )
        {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < vertexListNumber; i++ )
        {
            int randnum = random.nextInt(5);
            for (int j = 0; j < randnum; j++ )
            {
                int rand = random.nextInt(5);
                G.insertEdge(i, list.get(rand));
            }
        }

    }

    int search()
    {
        String search = JOptionPane.showInputDialog("Enter Node to search:");
        try
        {
            if(search != null)
            {
                selectNum = Integer.parseInt(search);
            }
        }
        catch (NumberFormatException e)
        {
            selectNum = 0;
        }
        return selectNum;
    }

    private int selectPane()
    {
        String paneSelect = JOptionPane.showInputDialog("Choose a search method:" +
                "\n\t1: Use Depth-First Search" +
                "\n\t2: Use Breadth-First Search" +
                "\n\t3: Use Dijkstra's Search" +
                "\n\t4: Close  Program");
        int selectNum = 0;

        try{
            if(paneSelect != null)
            {
                selectNum = Integer.parseInt(paneSelect);
            }
        }
        catch (NumberFormatException ignored)
        {
        }
        return selectNum;
    }

    void algorithmChoice(Graph graph, int vertexStart)
    {
        int paneNum = 0;
        while (paneNum != 4)
        {
            paneNum = selectPane();
            switch (paneNum)
            {
                case 1:
                    graph.depthFirstSearch(vertexStart);
                    System.out.println("Nodes counted were: " + nodeCheck);
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    graph.breathFirstSearch(vertexStart);
                    System.out.println("Nodes counted were: " + nodeCheck);
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    graph.dijkstra(vertexStart);
                    System.out.println("Nodes counted were: " + nodeCheck);
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Enter 4 to quit.");
                    break;
            }
        }
    }


}