import java.util.ArrayList;
import java.util.List;

/**
 * @author Gitali Naim
 */

public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor of Rectangle.
     *
     * @param upperLeft - the upper left point of the rectangle
     * @param width - the width of the rectangle
     * @param height - the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line - a line
     * @return List of intersection points with the specified line
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<Point>();
        List<Line> ribs = this.getRibs();
        for (int i = 0; i < ribs.size(); i++) {
            Point intersection = ribs.get(i).intersectionWith(line);
            if (intersection != null) {
                points.add(intersection);
            }
        }
        return points;
    }

    /**
     * This function gives access to width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * This function gives access to height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * This function gives access to upper left point of the rectangle.
     *
     * @return the upper left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * This function gives access to upper right point of the rectangle.
     *
     * @return the upper right point of the rectangle
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * This function gives access to downer left point of the rectangle.
     *
     * @return the downer left point of the rectangle
     */
    public Point getDownerLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * This function gives access to downer right point of the rectangle.
     *
     * @return the downer right point of the rectangle
     */
    public Point getDownerRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * This function creates the lines of the rectangle and return them in list.
     *
     * @return list of ribs of the rectangle
     */
    public java.util.List<Line> getRibs() {
        List<Line> ribs = new ArrayList<Line>();
        ribs.add(new Line(this.upperLeft, this.getUpperRight()));
        ribs.add(new Line(this.upperLeft, this.getDownerLeft()));
        ribs.add(new Line(this.getDownerLeft(), this.getDownerRight()));
        ribs.add(new Line(this.getUpperRight(), this.getDownerRight()));
        return ribs;
    }
}
