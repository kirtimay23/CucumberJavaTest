package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TodoPage {

	WebDriver driver;
	By txt_toDoEntry= By.className("new-todo");
	By btn_AllTab=By.linkText("All");
	By btn_ActiveTab=By.linkText("Active");
	By btn_CompletedTab=By.linkText("Completed");
	By btn_Clear=By.className("clear-completed");
	By txt_itemCount=By.className("todo-count");
	By list_Item=By.className("view");
	By checkbox=By.className("toggle");
	By btn_clearCompleted=By.className("clear-completed");
	By todoCount=By.className("todo-count");
	By toggleAll=By.id("toggle-all");

	public TodoPage(WebDriver driver)
	{
		this.driver=driver;
	}
	// This Method is to Add a new task and check if the Task is added in the list
	public void addTask(String task)
	{
		driver.findElement(txt_toDoEntry).sendKeys(task);
		driver.findElement(txt_toDoEntry).sendKeys(Keys.ENTER);	
	}
	public void checkTaskList(String task)
	{
		List<WebElement> listOfTask = driver.findElements(list_Item);
		int count=0; // To Store the occurence of Newly Created Task Item
		for (WebElement listTask:listOfTask)
		{
			if(listTask.getText().equals(task))
				count=1;	
		}
		Assert.assertTrue(count!=0);	
	}
	// This Method is to verify if the existing task is Updated and the same is reflected in the List
	public void editTask(String task, String updatedTask)
	{
		List<WebElement> listOfTask = driver.findElements(list_Item);
		Actions action= new Actions(driver);
		//Edit Existing Task
		for (WebElement listTask:listOfTask)
		{
			if(listTask.getText().equals(task))
			{
				action.doubleClick(listTask).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(updatedTask).sendKeys(Keys.ENTER).perform();

			}	
		}
	}
	public void checkDeletedTodo(String task)
	{
		
		List<WebElement> listOfTask = driver.findElements(list_Item);
		int count=0; // To Store the occurence of Newly Created Task Item
		for (WebElement listTask:listOfTask)
		{
			if(listTask.getText().equals(task))
				count=1;	
		}
		Assert.assertTrue(count==0);	
			
		}
			
	
	public void openAllTab()
	{
		driver.findElement(btn_AllTab).click();
	}
	public void openActiveTab()
	{
		driver.findElement(btn_ActiveTab).click();
	}
	public void openCompletedTab()
	{
		driver.findElement(btn_CompletedTab).click();
	}
	public void clickOnCheckbox()
	{
		driver.findElement(checkbox).click();
	}
	public void clickOnClearCompleted()
	{
		driver.findElement(btn_clearCompleted).click();
	}
	public void clickOnToggleAll()
	{
		driver.findElement(toggleAll).click();
	}
}
