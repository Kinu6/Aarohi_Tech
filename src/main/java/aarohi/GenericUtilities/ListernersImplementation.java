package aarohi.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for iTestListenr Interface of TestNG
 * @author kravi
 *
 */
public class ListernersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//System.out.println("Execution Started for TS" +methodName);
		test = report.createTest(methodName);
		test.log(Status.INFO, "-Test script execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//System.out.println("Execution Started for TS" +methodName);
	    test.log(Status.PASS,methodName+ "-----PASS-----");
	}

	public void onTestFailure(ITestResult result) {
		String method= result.getMethod().getMethodName();
		test.log(Status.FAIL,method+"------FAIL-----");
		test.log(Status.INFO, result.getThrowable());
		
		String screeShotName= method+"-"+ new JavaUtility().getSystemDateInFormat();
		
		try {
			String path = new WebDriverUtility().takesScreenShot(BaseClass.sDriver,screeShotName);
			test.addScreenCaptureFromPath(path);    //go the screenshot location and it will attach the report;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Exception "+result.getThrowable());
		//System.out.println("Execution Failed for TS" +method);	
	}

	public void onTestSkipped(ITestResult result) {
		String method= result.getMethod().getMethodName();
		//System.out.println("Exception "+result.getThrowable());
		
		test.log(Status.SKIP,method+"------FAIL-----");
		test.log(Status.INFO, result.getThrowable());
		
		//System.out.println("Execution Skipped for TS" +result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) { 
		System.out.println("Execution Started for Suite");
		// Extent Report configuration steps
		ExtentSparkReporter htmlreprter =new ExtentSparkReporter(".\\Aarohi_Tech\\ExtentReports"+new JavaUtility().getSystemDateInFormat()+".html");
	     htmlreprter.config().setDocumentTitle("vTigerExecution Reporter");
	     htmlreprter.config().setTheme(Theme.DARK);
	     htmlreprter.config().setReportName("Automation Execution Report");
	     
	     report= new ExtentReports();
	     report.attachReporter(htmlreprter);
	     report.setSystemInfo("Base URL", "http://localhost:8888");
	     report.setSystemInfo("Base Browser", "Firefox");
	     report.setSystemInfo("Reporter Name", "Ravish Keshri");
	     report.setSystemInfo("Base Platform", "Windows");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished for suite");
		report.flush(); // Consolidate and generate the report like assertAll
	}

	
	
}
