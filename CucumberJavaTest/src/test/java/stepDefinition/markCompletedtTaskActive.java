package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.TodoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class markCompletedtTaskActive {
	 WebDriver driver;
		TodoPage itemList;
	@Given("User is on HomePage to Mark Todo As Active")
	public void user_is_on_home_page_to_mark_todo_as_complete() {
		String projectPath= System.getProperty("user.dir");
		System.out.println("System Path"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://todomvc.com/examples/vue/#/all");
	}

	@When("^Enter (.*) in the Box and Press Enter$")
	public void user_enter_todo_in_the_box_and_press_enter(String Todo) {
		itemList=new TodoPage(driver);
		itemList.addTask(Todo);
	}

	@And("User Click on Checkbox to Mark Active Todo as Complete")
	public void user_click_on_checkbox_to_mark_todo_as_complete() {
	    itemList.clickOnCheckbox();
	}
	@And("User Click on Checkbox to Mark Completed Todo as Active")
	public void user_click_on_checkbox_to_mark_todo_as_Active() {
	    itemList.clickOnCheckbox();
	}

	@Then("^Verify (.*)  is now present in All tab$")
	public void verify_todo_is_is_present_in_all_list(String Todo) {
		itemList.openAllTab();
		itemList.checkTaskList(Todo);
	}

	@And("^Verify (.*)  is now present in Active tab$")
	public void verify_todo_is_is_present_in_completed_list(String Todo) {
		itemList.openActiveTab();
		itemList.checkTaskList(Todo);
		driver.close();
		driver.quit();
	}

}
