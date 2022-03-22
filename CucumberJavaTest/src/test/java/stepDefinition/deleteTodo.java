package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.TodoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class deleteTodo {
	WebDriver driver;
	TodoPage itemList;
	@Given("User is on HomePage to Delete Todo")
	public void user_is_on_home_page_to_delete_todo() {
		String projectPath= System.getProperty("user.dir");
		System.out.println("System Path"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://todomvc.com/examples/vue/#/all");
	}

	@When("^User Enter (.*) in the Box and Press Enter to Add Todo$")
	public void user_enter_todo_in_the_box_and_press_enter_to_add_todo(String Todo) {
		itemList=new TodoPage(driver);
		itemList.addTask(Todo);
	}

	@And("Click on Checkbox to Mark Todo as Complete")
	public void click_on_checkbox_to_mark_todo_as_complete() {
		itemList.clickOnCheckbox();
	}
	@And("Click on Clear Completed")
	public void click_on_clear_completed()
	{
		itemList.clickOnClearCompleted();
	}
	@Then("^Verify (.*) is removed from All List$")
	public void verify_todo_is_not_present_in_all_list(String Todo) {
		itemList.checkDeletedTodo(Todo);
	}

	@And("^Verify (.*) is removed from Completed List$")
	public void verify_todo_is_not_present_in_completed_list(String Todo) {
		itemList.checkDeletedTodo(Todo);
	}

	@And("^Verify (.*) is removed from Active List$")
	public void verify_todo_is_not_present_in_active_list(String Todo) {
		itemList.checkDeletedTodo(Todo);
		driver.close();
		driver.quit();
	}
}
