package org.example;

//package ru.skillfactory.qajava;

/*import testNG.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class PersonTest
        /*extends TestCase*/
{


    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
        currentTime();
    }
    @AfterClass
    void afterClass() {
        System.out.println("After class");
        currentTime();
    }
    @DataProvider(name="boolTeenager")
    Object [][] dataProvider(){
        return new Object[][] {
                {12, false},
                {13, true},
                {14, true},
                {18, true},
                {19, true},
                {20, false}
        };
    }


    @Test(dataProvider = "boolTeenager")
    void testSum (int x1, boolean b){
        boolean res = Person.isTeenager(x1);
        assertEquals(res, b);
    }


}

