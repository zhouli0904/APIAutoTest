package com.course.testng.factory;

import org.testng.annotations.Test;


public class SimpleTest2 {
        private int para;
        public SimpleTest2(int para) {
            this.para = para;
        }

        @Test
        public void testMethodOne(){
            int value = para + 1;
            System.out.println("Test method one output: " + value);
        }
        @Test
        public void testMethodTwo(){
            int value = para + 2;
            System.out.println("Test method two output: " + value);
        }
}

