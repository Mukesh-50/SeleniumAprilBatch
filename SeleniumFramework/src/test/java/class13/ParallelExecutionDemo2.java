package class13;

import org.testng.annotations.Test;

public class ParallelExecutionDemo2 
{

	@Test
	public void test2() {
		System.out.println("Test2 Started");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	
	
	
}
