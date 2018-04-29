package class13;

import org.testng.annotations.Test;

public class ParallelExecutionDemo3 
{

	@Test
	public void test3() {
		System.out.println("Test3 Started");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	
	
	
}
