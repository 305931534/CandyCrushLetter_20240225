package com.hsbc.candycrushletter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;


import static com.hsbc.candycrushletter.common.generateMixString;

public class SolutionFactoryTest {
    @Test
    public void testCase1() {
        String output = SolutionFactory.solution("aabccccbbad", "Stage1");
        //Assert.assertEquals("d", output);
        Assertions.assertEquals("d", output);
    }

    @Test
    public void testCase2() {
        String output = SolutionFactory.solution("aabcccbba", "Stage1");
        //Assert.assertTrue();
        Assertions.assertTrue(StringUtils.isBlank(output));
    }
    //boundary testing input is empty
    @Test
    public void testCase3() {
        String output = SolutionFactory.solution("", "Stage1");
        Assertions.assertTrue(StringUtils.isBlank(output));
    }

    //boundary testing input max length
    //i had used to make the max input string as long as Integer.MAX_VALUE-1 ,however, the heap will be OOM
    //need optimize
    @Test
    public void testCase4() {
        String output = SolutionFactory.solution(generateMixString(Integer.MAX_VALUE/20-26), "Stage1");
        Assertions.assertTrue(output.length()>0);
    }

    @Test
    public void testCase5() {
        String outStr = SolutionFactory.solution("abcccbad", "Stage2");
        Assertions.assertEquals("d", outStr);
    }

    @Test
    public void testCase6() {
        String outStr = SolutionFactory.solution("abcccba", "Stage2");
        Assertions.assertTrue(StringUtils.isBlank(outStr));
    }

    //boundary testing input is empty
    @Test
    public void testCase7() {
        String output = SolutionFactory.solution("", "Stage2");
        Assertions.assertTrue(StringUtils.isBlank(output));
    }

    //boundary testing input max length
    @Test
    public void testCase8() {
        String output = SolutionFactory.solution(generateMixString(Integer.MAX_VALUE/20-26), "Stage2");
        Assertions.assertTrue(output.length()>0);
    }
}
