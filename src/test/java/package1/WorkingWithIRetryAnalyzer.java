package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithIRetryAnalyzer {
	
	@Test(retryAnalyzer = genericutility.IRetryAnalyzerImplementation.class)
	
	public void test()
	{
		Assert.assertEquals("hdfc", "hfdc");
	}

}
