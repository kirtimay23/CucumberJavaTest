package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.TodoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class markTodoComplete {
	 WebDriver driver;
		TodoPage itemList;
	@Given("User is on HomePage to Mark Todo As Complete")
	public void user_is_on_home_page_to_mark_todo_as_complete() {
		String projectPath= System.getProperty("user.dir");
		System.out.println("System Path"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://todomvc.com/examples/vue/#/all");
	}

	@When("^User Enter (.*) in the Box and Press Enter$")
	public void user_enter_todo_in_the_box_and_press_enter(String Todo) {
		itemList=new TodoPage(driver);
		itemList.addTask(Todo);
	}

	@And("User Click on Checkbox to Mark Todo as Complete")
	public void user_click_on_checkbox_to_mark_todo_as_complete() {
	    itemList.clickOnCheckbox();
	}

	@Then("^Verify (.*)  is present in All List$")
	public void verify_todo_is_is_present_in_all_list(String Todo) {
		itemList.openAllTab();
		itemList.checkTaskList(Todo);
	}

	@And("^Verify (.*)  is present in Completed List$")
	public void verify_todo_is_is_present_in_completed_list(String Todo) {
		itemList.openCompletedTab();
		itemList.checkTaskList(Todo);
		driver.close();
		driver.quit();
	}

}
