package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	
	
	@Test
	@Parameters({"MyName1"})
	public void test1(String name1){
		
		System.out.println("Nmae is : " + name1);
		
	}
	
	@Test
	@Parameters({"MyName2"})
	public void test2(@Optional("Mohamed") String name2){
		
		System.out.println("Nmae is : " + name2);
		
	}

}
