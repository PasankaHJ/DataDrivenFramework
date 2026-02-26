package testCases2;

import org.testng.annotations.Test;

import testBase.BaseTestClass;

public class TestClass2 extends BaseTestClass{
	@Test
	public void method3() {
		System.out.println("Method 3");

	}

	@Test
	public void method4() {
		System.out.println("Method 4");
		number = 2000;
		System.out.println(number);
	}

	@Test
	public void method5() {
		System.out.println("Method 5");

	}
}
