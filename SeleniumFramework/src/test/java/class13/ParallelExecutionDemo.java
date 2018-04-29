package class13;

import org.testng.annotations.Test;

public class ParallelExecutionDemo 
{

	@Test
	public void test1() {
		System.out.println("Test1 Started");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	
	
	
}
