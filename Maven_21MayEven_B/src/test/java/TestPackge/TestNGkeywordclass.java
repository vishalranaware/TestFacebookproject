package TestPackge;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGkeywordclass 
{
		@BeforeClass
		public void beforeclass()
		{
			System.out.println("before class");
		}
		@BeforeMethod
		public void beforemethod()
		{
			System.out.println("before method");
		}
		
		//@Test(dependsOnMethods={"test4","test2"})
		
		@Test(dependsOnMethods="test4")
		//@Test
		//@Test(invocationCount= -2)
		public void test1()
		{
			System.out.println("test1");
		}
		
		@Test(priority =4,invocationCount=3)
		public void test2()
		{
			System.out.println("test2");
		}
		
		//@Test(enabled= false) //to stop the  method execution
		@Test
		public void test3()
		{
			System.out.println("test3");
		}
		
		//@Test(timeOut=3000)  // maximum time to excute the test
		@Test
		public void test4() throws InterruptedException
		{
			System.out.println("test4");
			//Thread.sleep(4000);
			//System.out.println("hello");
			Assert.fail();
		}
		
		
		
		@AfterMethod
		public void aftermethod()
		{
			System.out.println("logout");
		}
		@AfterClass
		public void afterclass()
		{
			System.out.println("close");
		}
}
