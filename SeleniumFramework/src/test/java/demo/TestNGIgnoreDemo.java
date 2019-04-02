package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore								ignore all the class
public class TestNGIgnoreDemo {

		
		@Test
		@Ignore							// ignore the methode
		public void test1(){
			System.out.println("I ma inside Test 1");
		}
		
		@Test()
		public void test2(){
			System.out.println("I ma inside Test 2");
		}

		@Test
		public void test3(){
			System.out.println("I ma inside Test 3");

		}
}