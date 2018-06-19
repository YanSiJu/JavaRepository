package com.alibaba.string;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Main Tester.
 *
 * @author <Authors name>
 * @since <pre>08/25/2017</pre>
 * @version 1.0
 */
public class MainTest extends TestCase {
    public void testMain() throws Exception {
    }

    public MainTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    @org.junit.Test
    public void tear() throws Exception {
        System.out.println("Test");
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(MainTest.class);
    }
}
