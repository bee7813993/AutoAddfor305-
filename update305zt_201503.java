package update305zt;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Wait;


public class update305zt_201503 {

	  private static WebDriver driver;
	  private static String baseUrl;
	  private boolean acceptNextAlert = true;
	  private static StringBuffer verificationErrors = new StringBuffer();
	  private static String myid = "setLoginID";
	  private static String mypass = "setLoginID";
	  private static String webdriverpass = "chromedriver.exe";

	  public static void main(String[] args) {
		  
		  if( args.length >= 1 ){
			  myid = args[0];
			  if (myid == "-h" || myid == "-help"){
				  System.out.println("USAGE : <command> [loginID] [loginPassword] [webdriverpath]");
				  System.out.println(" loginID : Login ID for My Ymobile. If omitted, use HardCoding value");
				  System.out.println(" loginPassword : Login Password for My Ymobile. If omitted, use HardCoding value");
				  System.out.println(" webdriverpath : filename to chromedriver.exe");
				  System.exit(0);
			  }
			  if (args.length >= 2){
				  mypass = args[1];
			  }
			  if (args.length >= 3){
				  webdriverpass = args[2];
			  }
		  }

			while(true){
				System.out.println(new Date());
			  try {
				update305zt_201503.setUp();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sleep(5000);
				driver.quit();
				continue;
			}
			  
			  try {
				update305zt_201503.testYmobile305zt1();
			  }catch (NoSuchElementException e){
				  sleep(240000);
				  driver.quit();
				  continue;
			  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			  }
			  	driver.quit();
			  	sleep(240000); // 4 minutes
			  }
			  

	  }

	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", webdriverpass);
	    driver = new ChromeDriver();
	    baseUrl = "https://webmy.ymobile.jp/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().setSize(new Dimension(400,650));
	  }	
	
	
	  public static boolean testYmobile305zt1() throws Exception {
		  String elementwords = "";
		 try {
			 
	    driver.get(baseUrl + "/portal/loginMsn/");
	    driver.get(baseUrl + "/portal/loginMsn/");
	    driver.findElement(By.id("msisdn")).clear();
	    driver.findElement(By.id("msisdn")).sendKeys(myid);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(mypass);
	    driver.findElement(By.id("loginBtn")).click();
	    Wait wait = new Wait() {
	    	@Override
	    	public boolean until() {
	    		try{
	    		driver.findElement(By.cssSelector("img[alt=\"契約内容照会/変更\"]"));
	    		return true;
	    		} catch (NoSuchElementException ignore) {}
	    		return false;
	    	}
	    };
	    driver.findElement(By.cssSelector("#btnOnlineSupport_0 > span")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | myemobile | 30000]]
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=myemobile | ]]
	    sleep(1000);
	    String  currentWindowHandle = driver.getWindowHandle();
	    Set<String>  windowHandles  = driver.getWindowHandles();
	    windowHandles.remove(currentWindowHandle);
	    
	    driver.switchTo().window(windowHandles.iterator().next());
	    wait.wait("Cannot find element!", 60000);
	    sleep(1000);
	    elementwords = "img[alt=\"契約内容照会/変更\"]";
	    driver.findElement(By.cssSelector(elementwords)).click();
	    //sleep(1000);
	    elementwords = "img[alt=\"通常速度に戻すお申し込み・ご利用データ通信量の確認\"]";
	    driver.findElement(By.cssSelector(elementwords)).click();
	    //sleep(1000);
	    elementwords = "img[alt=\"次へ\"]";
	    driver.findElement(By.cssSelector(elementwords)).click();
		 } catch (ElementNotVisibleException e){
			 System.out.println("画面遷移が間に合わないエラー  word = " + elementwords);
			 sleep(1000);
			 try{
			 driver.findElement(By.cssSelector("#btnLogout > img")).click();
			 } catch (Exception ex){
				 System.out.println("ログアウトボタン無効  word = " + elementwords);
			 }
			 driver.get(baseUrl + "/portal/loginMsn/");
			 driver.close();
			 return false;
		 } catch (NoSuchElementException e){
			 System.out.println("画面遷移が間に合わないエラー  word = " + elementwords);
			 sleep(1000);
			 try{
			 driver.findElement(By.cssSelector("#btnLogout > img")).click();
			 } catch (Exception ex){
				 System.out.println("ログアウトボタン無効  word = " + elementwords);
			 }
			 driver.get(baseUrl + "/portal/loginMsn/");
			 driver.close();
			 return false;
		 } catch(Exception ex) {
			 System.out.println("予期せぬエラーが発生しました。1 word = " + elementwords);
			 ex.printStackTrace();
			 sleep(1000);
			 try{
			 driver.findElement(By.cssSelector("#btnLogout > img")).click();
			 } catch (Exception e){
				 System.out.println("ログアウトボタン無効  word = " + elementwords);
			 }
			 driver.get(baseUrl + "/portal/loginMsn/");
			 driver.close();
			 return false;
		 }finally{
		    	
		 }	
	    // Warning: verifyTextPresent may require manual changes
		 sleep(1000);
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*予約なし[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
			 try{
			 driver.findElement(By.cssSelector("#btnLogout > img")).click();
			 } catch (Exception ex){
				 System.out.println("ログアウトボタン無効  word = " + elementwords);
			 }
			 driver.close();
	      return false;
	    }
	    // label=通常速度に戻すお申し込み(１回分予約)
	    // label=通常速度に戻すお申し込み（1回分即時）
	    try{
	    new Select(driver.findElement(By.id("selectedRequestStatus"))).selectByVisibleText("通常速度に戻すお申し込み(１回分予約)");
	    } catch (NoSuchElementException e) {
	    	new Select(driver.findElement(By.id("selectedRequestStatus"))).selectByVisibleText("通常速度に戻すお申し込み（1回分即時）");
	    } catch(Exception ex) {
	    	System.out.println("予期せぬエラーが発生しました。2");
	    	ex.printStackTrace();
	    	sleep(1000);
			 try{
			 driver.findElement(By.cssSelector("#btnLogout > img")).click();
			 } catch (Exception e){
				 System.out.println("ログアウトボタン無効  word = " + elementwords);
			 }
			 driver.get(baseUrl + "/portal/loginMsn/");
			 driver.close();
	    	return false;
	    }
	    sleep(1000);
	    try{
	    driver.findElement(By.cssSelector("img[alt=\"確認\"]")).click();
	    driver.findElement(By.cssSelector("img[alt=\"登録\"]")).click();
	    System.out.println(new Date() + ": Success add 500MB");
	    driver.findElement(By.cssSelector("img[alt=\"戻る\"]")).click();
	    driver.findElement(By.cssSelector("img[alt=\"次へ\"]")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=myemobile | ]]
	    driver.findElement(By.cssSelector("#btnLogout > img")).click();
	    } catch (NoSuchElementException e) {
	    	System.out.println("予期せぬ画面遷移が発生しました。3");
	    	e.printStackTrace();
	    	sleep(1000);
	    	driver.findElement(By.cssSelector("#btnLogout > img")).click();
	    	driver.get(baseUrl + "/portal/loginMsn/");
	    	return false;
	    } catch(Exception ex) {
	    	System.out.println("予期せぬエラーが発生しました。");
	    	ex.printStackTrace();
	    	sleep(1000);
	    	driver.findElement(By.cssSelector("#btnLogout > img")).click();
	    	driver.get(baseUrl + "/portal/loginMsn/");
	    	return false;
	    }finally{
	    	driver.close();
	    }
	    return true;
	    }

	    

	  
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }	

	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
		  
		    private static  void sleep(int microtime) {
		        try {
		            Thread.sleep(microtime);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
}

/***
Copyright (c) 2015, Yusuke Higashi. (bee@mail.pcgame-r18.jp)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
* Redistributions of source code must retain the above copyright notice, 
  this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright notice, 
  this list of conditions and the following disclaimer in the documentation 
  and/or other materials provided with the distribution.
* Neither the name of the copyright holder nor the names of its contributors 
  may be used to endorse or promote products derived from this software 
  without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
**/




