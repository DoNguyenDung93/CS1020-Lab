/**
 * Created by Do Nguyen Dung on 4/2/2015.
 */
class MyBall {
    private static int quantity = 0;
    private String colour;
    private double radius;

    public MyBall() {
        this("Yellow", 10.0);
    }

    public MyBall(String colour, double radius) {
        setColour(colour);
        setRadius(radius);
        quantity++;
    }

    public String getColour() {
        return colour;
    }

    public double getRadius() {
        return radius;
    }

    public static int getQuantity() {
        return quantity;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "[" + getColour() + ", " + getRadius() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof MyBall) {
            MyBall ball = (MyBall) obj;
            return this.getColour().equals(ball.getColour()) &&
                    this.getRadius() == ball.getRadius();
        } else {
            return false;
        }
    }
}
