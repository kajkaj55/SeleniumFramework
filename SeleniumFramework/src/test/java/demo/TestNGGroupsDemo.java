package demo;

import org.testng.annotations.Test;


@Test(groups={"AllClassTests"})     					// die ganzen Test im glasse grupieren und ausführen
public class TestNGGroupsDemo {
	
	@Test(groups={"sanity"})
	public void test1(){
		System.out.println("this is Test 1");
	}
	
	@Test(groups={"sanity","smoke"})
	public void test2(){
		System.out.println("this is Test 2");
	}
	
	@Test(groups={"sanity","smoke"})
	public void test3(){
		System.out.println("this is Test 3");
	}
	
	@Test(groups={"sanity","smoke",})
	public void test4(){
		System.out.println("this is Test 4");
	}
	
	@Test(groups={"smoke","windows.regression"})
	public void test5(){
		System.out.println("this is Test 5");
	}

	@Test(groups={"linux.regression"})
	public void test6(){
		System.out.println("this is Test 6");
	}
	@Test
	public void test7(){
		System.out.println("this is Test 7");
	}
}
