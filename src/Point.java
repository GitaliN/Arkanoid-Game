
/**
 * @author Gitali Naim
 */
public class Point {

    private double x;
    private double y;

    /**
     * constructor of point.
     *
     * @param x - x value of point
     * @param y - y value of point
     */
   public Point(double x, double y) {
       this.x = x;
       this.y = y;
   }

   /**
    * constructor of point.
    *
    * @param point - a point
    */
  public Point(Point point) {
      this.x = point.getX();
      this.y = point.getY();
  }

   /**
    * This function calculates the distance between two points.
    *
    * @param other - the other point
    * @return the distance of this point to the other point
    */
   public double distance(Point other) {
       return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                      + ((this.y - other.getY()) * (this.y - other.getY())));
   }

   /**
    * This function checks if the points are equal.
    *
    * @param other - the other point
    * @return true if the points are equal, false otherwise
    */
   public boolean equals(Point other) {
       boolean isEqual = false;
       if (this.x == other.getX() && this.y == other.getY()) {
           isEqual = true;
       }
       return isEqual;
   }

   /**
    * This function gives access to x value.
    *
    * @return the x value of this point
    */
   public double getX() {
       return this.x;
   }

   /**
    * This function gives access to y value.
    *
    * @return the y value of this point
    */
   public double getY() {
       return this.y;
   }

   /**
    * This function changes the x according to the received value.
    *
    * @param newX - a new x value that will enter to a point instance
    */
   public void setX(double newX) {
       this.x = newX;
   }

   /**
    * This function changes the y according to the received value.
    *
    * @param newY - a new y value that will enter to a point instance
    */
   public void setY(double newY) {
       this.y = newY;
   }
}