package testing.automationExcercise;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenShot extends BaseDriver{
	private static Logger log=Logger.getLogger(CaptureScreenShot.class);
	public static void takeScreenShot(String testCaseName) throws IOException{
		String strPath="";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenShotFile=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile,new File(strPath+testCaseName+".png"));
		
	 }
	
	public static void takeAlertScreenShot(String testCaseName) throws IOException, AWTException{
		String strPath="";
		Robot robot=new Robot();
		Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(rect);
        ImageIO.write(image, "png", new File(strPath+testCaseName+".png"));
	}
	 
	public static String captureScreenShot(String testCaseName) {
		String strPath="";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenShotFile=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile,new File(strPath+testCaseName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block		
			log.error(e.getMessage());
			
		}
		return strPath+testCaseName+".png";
	 }
	

}