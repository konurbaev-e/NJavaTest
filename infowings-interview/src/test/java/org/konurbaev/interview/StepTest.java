package org.konurbaev.interview;

import org.junit.Assert;
import org.junit.Test;

import static org.konurbaev.interview.Step.countSteps;

public class StepTest {
    @Test
    public void testWithBase2AndPercentage50(){
        Assert.assertEquals(countSteps(2, 59, 0.5), 58, 0);
    }

    @Test
    public void testWithBase2AndPercentage12dot5(){
        Assert.assertEquals(countSteps(2, 59, 0.125), 56, 0);
    }

    @Test
    public void testWithBase3AndPercentage30(){
        Assert.assertEquals(countSteps(3, 4, 0.3), 3, 0);
    }

    @Test
    public void testWithBase3AndPercentage35(){
        Assert.assertEquals(countSteps(3, 4, 0.35), 4, 0);
    }

    @Test
    public void testWithBase5AndPercentage50(){
        Assert.assertEquals(countSteps(5, 5, 0.5), 5, 0);
    }

    @Test
    public void testWithBase5AndPercentage30(){
        Assert.assertEquals(countSteps(5, 5, 0.3), 5, 0);
    }

    @Test
    public void testWithBase5AndPercentage20(){
        Assert.assertEquals(countSteps(5, 5, 0.20), 4, 0);
    }

}
