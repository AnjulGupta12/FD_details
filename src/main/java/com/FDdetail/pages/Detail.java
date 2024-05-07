package com.FDdetail.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.FDdetail.base.TestBase;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Detail extends TestBase {

	By tab = By.id("body_cph_MyAccount_gvAccountDetails");
	By next = By.xpath("//*[@id=\"body_cph_MyAccount_gvAccountDetails\"]/tbody/tr[12]/td/table/tbody/tr/td[2]/a");

	public void AccountDetailsPrint() 
 	{
 		WebElement table = driver.findElement(tab);
 		List<WebElement> rows = table.findElements(By.tagName("tr"));
 		for(WebElement row:rows) 
 		{
 			List<WebElement> heads = row.findElements(By.tagName("td"));
 			for(WebElement head:heads)
 			{
 						if((head.getText().equalsIgnoreCase("FD")))
 						{
 								System.out.println("            "+row.getText());
 						}
 			}
 		}
 	}

	public void NavigateNextPage() throws InterruptedException {

		WebElement nextPage = driver.findElement(next);
		nextPage.click();
		Thread.sleep(300);
	}
}
