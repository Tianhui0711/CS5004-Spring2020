/**
 * This class represents a 3D vector. The vector is represented as three components: x, y and z.
 */
public class Vector3D {
    private double x;
    private double y;
    private double z;

    /**
     * Constructs a vector3D object and initializes it.
     * to the x, y and z coordinate.
     * @param x the x coordinate of the vector
     * @param y the y coordinate of the vector
     * @param z the z coordinate of the vector
     */

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Get the x coordinate of the vector.
     * @return the x coordinate of the vector.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get the y coordinate of the vector.
     * @return the y coordinate of the vector.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Get the z coordinate of the vector.
     * @return the z coordinate of the vector.
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Get a string that describes the vector
     * @return a string that describes the vector
     */
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", this.x, this.y, this.z);
    }

    /**
     * Get the magnitude of the vector
     * @return the magnitude of the vector
     */
    public double getMagnitude() {
        double mag = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        return mag;
    }

    /**
     * Normalizing the vector.
     * It is obtained by dividing each component of the vector by its magnitude.
     * @return a normalized version of the vector
     * @throws IllegalStateException
     */
    public Vector3D normalize() throws IllegalStateException{
        if (this.getMagnitude() == 0) {
            throw new IllegalStateException("The magnitude of the vector is 0. It cannot be normalized.");
        } else {
            double newX = this.x / this.getMagnitude();
            double newY = this.y / this.getMagnitude();
            double newZ = this.z / this.getMagnitude();
            return new Vector3D(newX, newY, newZ);
        }
    }

    /**
     * Get a new vector by adding respective components of the two vectors
     * @param other
     * @return a new vector that is the result of adding this vector to another vector
     */
    public Vector3D add(Vector3D other) {
        double addX = this.x + other.x;
        double addY = this.y + other.y;
        double addZ = this.z + other.z;
        return new Vector3D(addX, addY, addZ);
    }

    /**
     * Get a new vector by multiplying each component of the current vector by the provided constant
     * @param constant
     * @return a new vector that is the result of multiplying this vector by a constant
     */
    public Vector3D multiply(double constant) {
        return new Vector3D(this.x * constant, this.y * constant, this.z * constant);
    }

    /**
     * Get the dot product of this vector and another vector
     * by multiplying each of their coordinate and add the summaries together
     * @param other
     * @return the dot product of this vector and another vector
     */
    public double dotProduct(Vector3D other) {
        double dotProd = this.x * other.x + this.y * other.y + this.z * other.z;
        return dotProd;
    }

    /**
     * Get the angle between two vectors.
     * Technically given two vectors, there are two angles between them.
     * This returns the shorter of the two angles.
     * @param other
     * @return the cos(θ) form of the angle between two vectors in degrees
     * @throws IllegalStateException
     */
    public double angleBetween(Vector3D other) throws IllegalStateException {
        if (this.getMagnitude() == 0 || other.getMagnitude() == 0) {
            throw new IllegalStateException("One of the two vectors is 0. The angle between them is not defined.");
        } else {
            double dotPro = dotProduct(other);
            double mul = this.getMagnitude() * other.getMagnitude();
            double angle = dotPro / mul;
            return angle;
        }
    }

    public static void main(String[] args) {
        Vector3D vector1 = new Vector3D(3, 4, 0);

        // Test1: get the x, y, z component of the vector
        System.out.println(vector1.getX());
        System.out.println(vector1.getY());
        System.out.println(vector1.getZ());

        // Test2: get the string description of the vector
        System.out.println(vector1.toString());

        // Test3: get the magnitude of the vector
        System.out.println(vector1.getMagnitude());

        // Test4: get the normalized version of the vector
        Vector3D vector2 = vector1.normalize();
        System.out.println(vector2.toString());

        // Zero vector which cannot be normalized
        Vector3D vector3 = new Vector3D(0,0,0);
        try {
            System.out.println(vector3.normalize().toString());
        } catch (IllegalStateException e) {
            System.out.println("Exception catch: " + e);
        }

        Vector3D vector4 = new Vector3D(0, 4, 3);

        // Test5: get the vector after adding one vector to another
        System.out.println(vector1.add(vector4).toString());

        // Test6: get the vector after multiply a constant to the vector
        System.out.println(vector1.multiply(2));

        // Test7: get the dot product of this vector and another vector
        System.out.println(vector1.dotProduct(vector4));

        // Test8: get the angle of this vector and another vector
        System.out.println(vector1.angleBetween(vector4));

        // Zero vector whose angle cannot be defined
        try {
            System.out.println(vector1.angleBetween(vector3));
        } catch (IllegalStateException e) {
            System.out.println("Exception catch: " + e);
        }
    }
}
