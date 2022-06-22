package utililies;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReport;
	public static ExtentReports getExtentReports() {
		String extentReportPath = System.getProperty("user.dir")+"\\repots\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Tutorialninja Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OS", "windows 10");
		extentReport.setSystemInfo("Tested By", "NCP");
		
		return 	extentReport;
		
		
	}
	
	

}
