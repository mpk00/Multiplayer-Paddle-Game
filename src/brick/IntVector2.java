package brick;

/** A vector that holds two integers */
public class IntVector2 {
    public int x;
    public int y;

    /** Shorthand for new IntVector2(0, 0) */
    public static final IntVector2 zero = new IntVector2(0, 0);

    /** Shorthand for new IntVector2(1, 1) */
    public static final IntVector2 one = new IntVector2(1, 1);

    public IntVector2(int _x, int _y) {
        x = _x;
        y = _y;
    }

    /**
     * Copy constructor
     * @param copy vector to copy
     */
    public IntVector2(IntVector2 copy) {
        this(copy.x, copy.y);
    }

    /**
     * Creates a new copy
     * @return a copy
     */
    public IntVector2 copy() {
        return new IntVector2(this);
    }

    /**
     * Calculates new vector a + b
     * 
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the sum of a and b
     */
    public static IntVector2 add(IntVector2 a, IntVector2 b) {
        return new IntVector2(a.x + b.x, a.y + b.y);
    }

    /**
     * Calculates new vector a - b
     * 
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the difference of a and b
     */
    public static IntVector2 sub(IntVector2 a, IntVector2 b) {
        return new IntVector2(a.x - b.x, a.y - b.y);
    }

    /**
     * Calculates new vector a * b (component-wise)
     * 
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the component-wise product of a and b
     */
    public static IntVector2 mult(IntVector2 a, IntVector2 b) {
        return new IntVector2(a.x * b.x, a.y * b.y);
    }

    /**
     * Calculates new vector a / b (component-wise)
     * 
     * @param a left-hand operand
     * @param b right-hand operand
     * @return the component-wise quotient of a and b
     */
    public static IntVector2 div(IntVector2 a, IntVector2 b) {
        return new IntVector2(a.x / b.x, a.y / b.y);
    }

    /**
     * Calculates new vector where x component is flipped
     * 
     * @param a vector
     * @return flipped vector
     */
    public static IntVector2 flipX(IntVector2 a) {
        return new IntVector2(-a.x, a.y);
    }

    /**
     * Calculates new vector where y component is flipped
     * 
     * @param a vector
     * @return flipped vector
     */
    public static IntVector2 flipY(IntVector2 a) {
        return new IntVector2(a.x, -a.y);
    }

    /**
     * Adds a vector in place
     * 
     * @param b right-hand operand
     * @return this
     */
    public IntVector2 add(IntVector2 b) {
        this.x += b.x;
        this.y += b.y;
        return this;
    }

    /**
     * Subtracts a vector in place
     * 
     * @param b right-hand operand
     * @return this
     */
    public IntVector2 sub(IntVector2 b) {
        this.x -= b.x;
        this.y -= b.y;
        return this;
    }

    /**
     * Component-wise multiplication in placce
     * 
     * @param b right-hand operand
     * @return this
     */
    public IntVector2 mult(IntVector2 b) {
        this.x *= b.x;
        this.y *= b.y;
        return this;
    }

    /**
     * Component-wise division in place
     * 
     * @param b right-hand operand
     * @return this
     */
    public IntVector2 div(IntVector2 b) {
        this.x /= b.x;
        this.y /= b.y;
        return this;
    }

    /**
     * Flips the x component
     * 
     * @return this
     */
    public IntVector2 flipX() {
        this.x *= -1;
        return this;
    }

    /**
     * Flips the y component
     * 
     * @return this
     */
    public IntVector2 flipY() {
        this.y *= -1;
        return this;
    }

    /**
     * Sets the vector to (0, 0)
     * 
     * @return this
     */
    public IntVector2 resetToZero() {
        this.x = 0;
        this.y = 0;
        return this;
    }

}