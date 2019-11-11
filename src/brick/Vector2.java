package brick;

public class Vector2 {

    public float x;
    public float y;

    /** Shorthand for new Vector2(0, 0) */
    public static final Vector2 zero = new Vector2(0, 0);

    /** Shorthand for new Vector2(1, 1) */
    public static final Vector2 one = new Vector2(1, 1);

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Round to intVector
     * @param a
     * @return
     */
    public static IntVector2 round(Vector2 a) {
        return new IntVector2(Math.round(a.x), Math.round(a.y));
    }
    /**
     * Truncate to intVector
     * @param a
     * @return
     */
    public static IntVector2 trunc(Vector2 a) {
        return new IntVector2((int)a.x, (int)a.y);
    }

        /**
     * Calculates new vector a + b
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the sum of a and b
     */
    public static Vector2 add(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    /**
     * Calculates new vector a - b
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the difference of a and b
     */
    public static Vector2 sub(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    /**
     * Calculates new vector a * b (component-wise)
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the component-wise product of a and b
     */
    public static Vector2 mult(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x * b.x, a.y * b.y);
    }

    /**
     * Calculates new vector a / b (component-wise)
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the component-wise quotient of a and b
     */
    public static Vector2 div(Vector2 a, Vector2 b)
    {
        return new Vector2(a.x / b.x, a.y / b.y);
    }

    /**
     * Calculates new vector where x component is flipped
     * @param a vector
     * @return flipped vector
     */
    public static Vector2 flipX(Vector2 a)
    {
        return new Vector2(-a.x, a.y);
    }

    /**
     * Calculates new vector where y component is flipped
     * @param a vector
     * @return flipped vector
     */
    public static Vector2 flipY(Vector2 a)
    {
        return new Vector2(a.x, -a.y);
    }

    /**
     * Adds a vector in place
     * @param b right-hand operand
     * @return this
     */
    public Vector2 add(Vector2 b)
    {
        this.x += b.x;
        this.y += b.y;
        return this;
    }

    /**
     * Subtracts a vector in place
     * @param b right-hand operand
     * @return this
     */
    public Vector2 sub(Vector2 b)
    {
        this.x -= b.x;
        this.y -= b.y;
        return this;
    }

    /**
     * Component-wise multiplication in placce
     * @param b right-hand operand
     * @return this
     */
    public Vector2 mult(Vector2 b)
    {
        this.x *= b.x;
        this.y *= b.y;
        return this;
    }

    /**
     * Component-wise division in place
     * @param b right-hand operand
     * @return this
     */
    public Vector2 div(Vector2 b)
    {
        this.x /= b.x;
        this.y /= b.y;
        return this;
    }

    /**
     * Flips the x component
     * @return this
     */
    public Vector2 flipX()
    {
        this.x *= -1;
        return this;
    }

    /**
     * Flips the y component
     * @return this
     */
    public Vector2 flipY()
    {
        this.y *= -1;
        return this;
    }

    /**
     * Sets the vector to (0, 0)
     * @return this
     */
    public Vector2 resetToZero()
    {
        this.x = 0;
        this.y = 0;
        return this;
    }
}