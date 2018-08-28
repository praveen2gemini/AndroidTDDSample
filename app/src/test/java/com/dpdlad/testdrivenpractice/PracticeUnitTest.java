package com.dpdlad.testdrivenpractice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PracticeUnitTest {

    @BeforeClass
    public static void initTestStart() {
        System.out.println("Very Very first initTestStart() called!");
    }

    @Before
    public void initTest() {
        System.out.println("initTest() called!");
    }

    @After
    public void callEventually() {
        System.out.println("callEventually() called!");
    }

    @Test
    public void testCaseA() {
        System.out.println("testCaseA() called!");
        String name = "test";
        String testName = "test";
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);
        assertSame(name, testName);
    }

    @Test
    public void testCaseC() {
        System.out.println("testCaseC() called!");
        String name = "test";
        String testName = "test";
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);
        assertSame(name, testName);
    }

    @Test
    public void testCaseB() {
        System.out.println("testCaseB() called!");
        String name = "test";
        String testName = "test";
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);
        assertSame(name, testName);
    }

    @AfterClass
    public static void callEventuallyEnd() {
        System.out.println("Very Very last callEventuallyEnd() called!");
    }

}