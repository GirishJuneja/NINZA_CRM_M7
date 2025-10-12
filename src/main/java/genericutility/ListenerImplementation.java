package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		
		System.out.println("Report Configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("Report Back up");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testcaseName = result.getMethod().getMethodName();
		System.out.println(testcaseName+"Execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testcaseName = result.getMethod().getMethodName();
		System.out.println(testcaseName+"Execution success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testcaseName = result.getMethod().getMethodName();
		String date = new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(testcaseName+"Execution failed");
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+testcaseName+"_"+date+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();
		System.out.println(testcaseName+"Execution skipped");
		
	}
	
	
	
	

}
