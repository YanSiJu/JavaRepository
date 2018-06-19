package com.alibaba;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;

/**
 * ImportJUnit Tester.
 *
 * @author <Authors name>
 * @since <pre>08/26/2017</pre>
 * @version 1.0
 */
public class ImportJUnitTest extends TestCase {
    public ImportJUnitTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    @org.junit.Test
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @NotNull
    public static Test suite() {
        return new TestSuite(ImportJUnitTest.class);
    }
}
