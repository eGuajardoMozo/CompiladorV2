class Squiral extends TurtleGraphicsWindow
{

    void drawSquiral()
    {
        for ( int steps=5; steps <= 200; steps += 5 )    
        {
            forward( steps );
            right(90);
        }

    } // end drawSquiral()

    public static void main(String[] args)
    {
        Squiral me = new Squiral();
        me.clean();
        me.drawSquiral();
    }

} // end class Squiral

 

