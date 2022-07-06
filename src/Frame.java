/**
 * @author Gitali Naim
 */
public class Frame {

    private int x;
    private int y;
    private int height;
    private int width;

    /**
     * constructor of frame.
     *
     * @param x - the first x of the point of the frame
     * @param y -  the first y of the point of the frame
     * @param height - the height of the frame
     * @param width - the width of the frame
     */
    public Frame(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * This function gives access to x value.
     *
     * @return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * This function changes the x according to the received value.
     *
     * @param newX - a new x value that will enter to a frame instance
     */
    public void setX(int newX) {
        this.x = newX;
    }

    /**
     * This function gives access to y value.
     *
     * @return the y value
     */
    public int getY() {
        return y;
    }

    /**
     * This function changes the y according to the received value.
     *
     * @param newY - a new y value that will enter to a frame instance
     */
    public void setY(int newY) {
        this.y = newY;
    }

    /**
     * This function gives access to height.
     *
     * @return the height of the frame
     */
    public int getHeight() {
        return height;
    }

    /**
     * This function changes the height according to the received value.
     *
     * @param newHeight - a new height that will enter to a frame instance
     */
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    /**
     * This function gives access to width.
     *
     * @return the width of the frame
     */
    public int getWidth() {
        return width;
    }

    /**
     * This function changes the width according to the received value.
     *
     * @param newWidth - a new width that will enter to a frame instance
     */
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
}
