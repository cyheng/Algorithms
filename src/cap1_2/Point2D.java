package cap1_2;

import edu.princeton.cs.algs4.*;

public class Point2D {
    private final double xpoint;
    private final double ypoint;
    public Point2D(double x,double y)
    {
        xpoint =x;ypoint=y;
    }
    public void draw()
    {
        StdDraw.point(xpoint, ypoint);
    }
    public double distance() 
    {
        return Math.sqrt(xpoint*xpoint+ypoint*ypoint);
    }
    public double compare(Point2D obj)
    {
        return this.distance()-obj.distance();
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        int N=Integer.parseInt(args[0]);
        StdDraw.setXscale();
        StdDraw.setYscale();
        StdDraw.setPenRadius();
        Point2D [] points = new Point2D[N];
        
        for(int i=0;i<N;i++)
        {
            points[i]=new Point2D(StdRandom.uniform(),StdRandom.uniform());
            points[i].draw();
        }
        
    }
    
}
