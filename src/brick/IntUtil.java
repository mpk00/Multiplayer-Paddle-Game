package brick;

public class IntUtil
{
    public static int Clamp(int val, int minVal, int maxVal)
    {
        if(val < minVal)
        {
            return minVal;
        }
        else if(val > maxVal)
        {
            return maxVal;
        }
        else
        {
            return val;
        }
    }
}