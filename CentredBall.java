// CentredBall class:
//   Class attribute: quantity - number of balls created
//   Instance attributes: colour, radius, centre

import java.awt.*;

class CentredBall {

    /**
     * *********** Data members *********************
     */
    private static int quantity = 0;

    private String colour;
    private double radius;
    private Point centre;
    private int xCoordi, yCoordi;

    /**
     * *********** Constructors *********************
     */
    public CentredBall() {
        this("Yellow", 10.0, 0, 0);
    }

    public CentredBall(String colour, double radius, int xCoordi, int yCoordi) {
        setColour(colour);
        setRadius(radius);
        setXCoordi(xCoordi);
        setYCoordi(yCoordi);
        Point centre = new Point(xCoordi, yCoordi);
    }

    public CentredBall(String colour, double radius, Point centre) {
        setColour(colour);
        setRadius(radius);
        setCentre(centre);
    }

    /**
     * ************* Accessors **********************
     */
    public String getColour() {
        return colour;
    }

    public double getRadius() {
        return radius;
    }

    public int getXCoordi() {
        return xCoordi;
    }

    public int getyCoordi() {
        return yCoordi;
    }

    public Point getCentre() {
        return centre;
    }

    /**
     * ************* Mutators ***********************
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setXCoordi(int xCoordi) {
        this.xCoordi = xCoordi;
    }

    public void setYCoordi(int yCoordi) {
        this.yCoordi = yCoordi;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    /**
     * ************** Overriding methods *****************
     */
    // Overriding toString() method
    public String toString() {
        return "[" + "colour=" + getColour() + ", " + "radius=" + getRadius()
                + ", " + "centre=(" + getXCoordi() + "," + getyCoordi() + ")]";
    }

    // Overriding equals() method
    public boolean equals(Object obj) {
        if (obj instanceof CentredBall) {
            CentredBall ball = (CentredBall) obj;
            return this.getColour().equals(ball.getColour()) && this.getRadius() == ball.getRadius()
                    && this.getXCoordi() == ball.getXCoordi() && this.getyCoordi() == ball.getyCoordi();
        } else {
            return false;
        }
    }
}

