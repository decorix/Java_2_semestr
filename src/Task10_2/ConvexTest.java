package Task10_2;

public class ConvexTest {
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        ConvexFrame cf = new ConvexFrame(convex);

        while(true){
            convex.add(new R2Point());

            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());
            cf.repaint();
        }
    }
}
