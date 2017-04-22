class PointsCircle extends TurtleGraphicsWindow
{

    void pointOut100()
    {
        setpensize( 30 );
        penup();
        forward( 85 );
        pendown();
        forward( 30 );
        penup();
        back( 115 );

    } // end pointOut100()

    void drawCircle()
    {
        for ( int i=18; i > 0; i-- )
        {
            pointOut100();
            right(20);
        }

    } // end drawCircle()

    public static void main(String[] args)
    {
        PointsCircle me = new PointsCircle();
        me.clean();
        me.drawCircle();
    }

} // end class PointsCircle
