public class Listing
{
    private int value;
    private boolean pushed;

    Listing(int v)
    {
        value = v;
    }
    public String toString()
    {
        return ("Vertex: " + value + "\n" );
    }

    Listing deepCopy()
    {
        return new Listing(value);
    }
    boolean getPushed()
    {
        return !pushed;
    }
    void setPushed(boolean value)
    {
        pushed = value;
    }
    void visit()
    {
        System.out.println(this);
    }
}