package com.FDdetail.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.FDdetail.base.TestBase;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount extends TestBase {
    public OpenAccount() {
        PageFactory.initElements(driver, this);
    }


	String filePath = System.getProperty("user.dir") + "/src/main/resources/testData";

	By openNewAc = By.xpath("/html/body/form/div[3]/div[4]/div[1]/div/div/ul/li[1]/a");

	@FindBy(xpath="/html/body/form/div[3]/div[4]/div[2]/table/tbody/tr[3]/td[3]/input")
		 WebElement btn;

	By fileUp = By.id("body_cph_MyAccount_fupUpload");

	public void validatingNewAccount(String acc, String stateType, String cityType) throws InterruptedException, IOException {
		System.out.println("in");
		WebElement openNewAcBtn=driver.findElement(openNewAc);
		openNewAcBtn.click();
		Thread.sleep(1000);

	

		 WebElement dropDown1 = driver.findElement(By.id("body_cph_MyAccount_ddlAccountType"));
		 Select acType = new Select(dropDown1);
		 acType.selectByVisibleText(acc);
		 Thread.sleep(1000);

		

		WebElement dropDown2 = driver.findElement(By.id("body_cph_MyAccount_ddlState"));
		Select state = new Select(dropDown2);
		state.selectByVisibleText(stateType);
		Thread.sleep(1000);

		

		WebElement dropDown3 = driver.findElement(By.id("body_cph_MyAccount_ddlCity"));
		Select city = new Select(dropDown3);
		city.selectByVisibleText(cityType);
		Thread.sleep(1000);

		WebElement uploadFile=driver.findElement(fileUp);
		uploadFile.sendKeys(filePath);
		Thread.sleep(1000);
		btn.submit();
		Thread.sleep(1000);
		String msg= driver.findElement(By.xpath("//*[text()='Branch is mandatory']")).getText();
		Thread.sleep(1000);
		System.out.println(msg);

		
		   writeToExcel(1, 3, msg);
	        wait(500);
	        }
	
	
	@SuppressWarnings("resource")
	public void writeToExcel(int r, int c, String msg) throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet("Sheet1");
	    Row rw = sheet.getRow(r);
	    rw.createCell(c).setCellValue(msg);
	    Thread.sleep(500);
	    FileOutputStream fileout = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
	    workbook.write(fileout);
	    fileout.close();
	    workbook.close();

	}}