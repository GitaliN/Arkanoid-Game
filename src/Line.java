import java.util.List;

/**
 * The type Line.
 *
 * @author Gitali Naim
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * Constructor of line.
     *
     * @param start - the start point of the line
     * @param end   - the end point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor of line.
     *
     * @param x1 - the x value of the start point of the line
     * @param y1 - the y value of the start point of the line
     * @param x2 - the x value of the end point of the line
     * @param y2 - the y value of the end point of the line
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * This function returns the length between the start point and the end point of the line.
     *
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * This function returns the x and y values of the middle point of the line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        Point middlePoint = new Point((this.start.getX() + this.end.getX()) / 2,
                (this.start.getY() + this.end.getY()) / 2);
        return middlePoint;
    }

    /**
     * This function returns the x and y values of the start point of the line.
     *
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * This function returns the x and y values of the end point of the line.
     *
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * This function calculates the incline of the line by using the x and y values of the start and end point.
     *
     * @return the incline of the line
     */
    public double getIncline() {
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    /**
     * This function calculates the point of intersection of the line with y axis.
     *
     * @return value of y in the intersection point of the line with y axis
     */
    public double getIntersectPointWithYAxis() {
        return this.start.getY() - this.getIncline() * this.start.getX();
    }

    /**
     * This function checks if the lines are intersect.
     *
     * @param other - the other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        return (this.intersectionWith(other) != null);
    }

    /**
     * This function calculates the intersection point between two straight equations.
     *
     * @param other - the other line
     * @return the intersection point
     */
    public Point getIntersectionPoint(Line other) {
        double x;
        double y;
        if (other.start.getX() == other.end.getX() && this.start.getX() == this.end.getX()) {
            return null;
        } else if (other.start.getX() == other.end.getX() && this.start.getX() != this.end.getX()) {
            x = other.start.getX();
            y = this.getIncline() * x + this.getIntersectPointWithYAxis();
        } else if (other.start.getX() != other.end.getX() && this.start.getX() == this.end.getX()) {
            x = this.start.getX();
            y = other.getIncline() * x + other.getIntersectPointWithYAxis();
        } else {
            x = (this.getIntersectPointWithYAxis() - other.getIntersectPointWithYAxis())
                    / (other.getIncline() - this.getIncline());
            y = this.getIncline() * x + this.getIntersectPointWithYAxis();
        }
        return new Point(x, y);
    }

    /**
     * This function checks if the intersection point is between the two lines.
     *
     * @param other - the other line
     * @return the intersection point if the lines intersect, and null otherwise
     */
    public Point intersectionWith(Line other) {
        try {
            Point point = getIntersectionPoint(other);
            if (((point.getX() <= this.start.getX() && point.getX() >= this.end.getX())
                    || (point.getX() >= this.start.getX() && point.getX() <= this.end.getX()))
                    && ((point.getY() <= this.start.getY() && point.getY() >= this.end.getY())
                    || (point.getY() >= this.start.getY() && point.getY() <= this.end.getY()))
                    && ((point.getX() >= other.start.getX() && point.getX() <= other.end.getX())
                    || (point.getX() <= other.start.getX() && point.getX() >= other.end.getX()))
                    && ((point.getY() >= other.start.getY() && point.getY() <= other.end.getY())
                    || (point.getY() <= other.start.getY() && point.getY() >= other.end.getY()))) {
                return point;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * This function checks if the lines are equal.
     *
     * @param other - the other line
     * @return return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end));
    }

    /**
     * Find the the closest intersection point to the start point of the line.
     *
     * @param rect - the rectangle
     * @return the closest intersection point.
     * If this line does not intersect with the rectangle, return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = rect.intersectionPoints(this);
        if (points.size() == 0) {
            return null;
        } else {
            Point closestPointToStart = points.get(0);
            double distance = 0;
            for (int i = 0; i < points.size(); i++) {
                double currentDistance = this.start.distance(points.get(i));
                if (currentDistance < distance) {
                    distance = currentDistance;
                    closestPointToStart = points.get(i);
                }
            }
            return closestPointToStart;
        }
    }

    /**
     * Check if the point is in the line.
     *
     * @param point - a point
     * @return true if the point is in the line, false otherwise.
     */
    public boolean isPointInLine(Point point) {
        if (this.start.getX() == this.end.getX()) {
            return (point.getX() == this.start.getX()
                    && ((point.getY() >= this.start.getY() && point.getY() <= this.end.getY())
                    || (point.getY() <= this.start.getY() && point.getY() >= this.end.getY())));
        }
        return (point.getY() == this.getIncline() * point.getX() + this.getIntersectPointWithYAxis());
    }
}