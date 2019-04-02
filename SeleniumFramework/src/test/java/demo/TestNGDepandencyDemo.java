package demo;

import org.testng.annotations.Test;

public class TestNGDepandencyDemo {
	//testng3.xml
	
	
	//@Test(dependsOnMethods={"test2","test3"}, priority=1)
	@Test(dependsOnGroups={"sanity1","sanity2"})
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
	
	
	@Test(groups={"sanity1"})
	public void test1A(){
		System.out.println("I ma inside Test 1A");
	}
	
	@Test(groups={"sanity2"})
	public void test1B(){
		System.out.println("I ma inside Test 1B");
	}

}
