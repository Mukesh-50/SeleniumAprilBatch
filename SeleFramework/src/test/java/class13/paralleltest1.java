package class13;

import org.testng.annotations.Test;

public class paralleltest1 {

	@Test
	public void paralleltestdemo()
	{
		System.out.println("This is parallel test demo");
		System.out.println(Thread.currentThread().getId());
	}
}
