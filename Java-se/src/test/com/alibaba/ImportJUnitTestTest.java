package com.alibaba;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * ImportJUnitTest Tester.
 *
 * @author <Authors name>
 * @since <pre>08/26/2017</pre>
 * @version 1.0
 */
public class ImportJUnitTestTest extends TestCase {
    public ImportJUnitTestTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSetUp() throws Exception {
        //TODO: Test goes here...
    }

    public static Test suite() {
        return new TestSuite(ImportJUnitTestTest.class);
    }
}
