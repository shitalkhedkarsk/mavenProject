package listener_study;

import java.io.IOException;

import org.testng.ITestListener;

import org.testng.ITestResult;

import maven2_Base_Folder.Maven2_Base_LaunchBrowser;

public class Listener_maven2 extends Maven2_Base_LaunchBrowser implements ITestListener
{		
		public void onTestFailure(ITestResult result)
		{
			String tcName1 = result.getName();
			System.out.println("failed test case result is "+result.getName());
			try {
				takeScreenshot(tcName1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
