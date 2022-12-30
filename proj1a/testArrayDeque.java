import org.junit.Test;
import org.junit.Assert;

public class testArrayDeque {
    @Test
    public void resizetest()
    {
        Integer[] nums = new Integer[] {1,2,3,4,5,6,7,8,9};
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>(nums);
        queue.resize(12);
    }


}