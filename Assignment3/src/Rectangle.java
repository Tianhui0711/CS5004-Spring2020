import java.util.NoSuchElementException;

public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Construct a rectangle with its x, y coordinate, its width and its height.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width
     * @param height the height
     * @throws IllegalArgumentException if the width or height is non-positive
     */
    public Rectangle(int x, int y, int width, int height) throws IllegalArgumentException{
        if (width <=0 || height <= 0) {
            throw new IllegalArgumentException("The width and height should be positive.");
        } else {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    /**
     * Check if the two rectangles overlap with each other by comparing their coordination
     * @param other the other rectangle
     * @return true if this rectangle overlaps with other, false otherwise
     */
    public boolean overlap(Rectangle other) {
        if (Math.max(this.x, other.x) < Math.min(this.x + this.width, other.x + other.width)
                && Math.max(this.y, other.y) < Math.min(this.y + this.height, other.y + other.height)) {
            return true;
        }
        return false;
    }

    /**
     * Get a Rectangle object that represents the overlap of the two rectangles
     * @param other the other rectangle
     * @return a Rectangle object that represents the overlap of the two rectangles
     * @throws NoSuchElementException if no intersection exists
     */
    public Rectangle intersect(Rectangle other) throws NoSuchElementException {
        int x;
        int y;
        int width;
        int height;
        if (this.overlap(other)) {
            x = Math.max(this.x, other.x);
            y = Math.max(this.y, other.y);
            width = Math.min(this.x + this.width, other.x + other.width) - x;
            height = Math.min(this.y + this.height, other.y + other.height) - y;

            Rectangle intersection = new Rectangle(x, y, width, height);
            return intersection;
        } else {
            throw new NoSuchElementException("The two rectangles have no intersection.");
        }
    }

    /**
     * Get a Rectangle object that represents the union of this rectangle and the other rectangle
     * @param other the other rectangle
     * @return a Rectangle object that represents the union of this rectangle and the other rectangle
     */
    public Rectangle union(Rectangle other) {
        int x;
        int y;
        int width;
        int height;
        x = Math.min(this.x, other.x);
        y = Math.min(this.y, other.y);
        width = Math.max(this.x + this.width, other.x + other.width) - x;
        height = Math.max(this.y + this.height, other.y + other.height) - y;;

        Rectangle union = new Rectangle(x, y, width, height);
        return union;
    }

    /**
     * Get a string that describes the x, y coordinates of the rectangle, its width and its height
     * @return a string describing the rectangle
     *         if the Rectangle object is Rectangle(2,3,4,5), the output string should be "x:2, y:3, w:4, h:5"
     */
    public String toString() {
        String str = "";
        str += "x:" + x + ", ";
        str += "y:" + y + ", ";
        str += "w:" + width + ", ";
        str += "h:" + height;
        return str;
    }

    /**
     * Compare this rectangle to the other rectangle
     * @param o the other rectangle
     * @return true, if the two rectangle are the same, false otherwise
     */
    public boolean equals(Object o) {
        Rectangle other = (Rectangle)o;
        return x == other.x && y == other.y && width == other.width && height == other.height;
    }
}
