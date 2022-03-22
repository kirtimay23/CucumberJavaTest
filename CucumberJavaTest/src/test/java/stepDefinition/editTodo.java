
  package stepDefinition;
  
  import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.chrome.ChromeDriver;
  
  import Pages.TodoPage; import io.cucumber.java.en.And; import
  io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
  io.cucumber.java.en.When;
  
  public class editTodo {
  
	  WebDriver driver;
		TodoPage itemList;
		@Given("User is on HomePage of TodoMVC for Edit")
		public void user_is_on_home_page_of_todo_mvc() {
			String projectPath= System.getProperty("user.dir");
			System.out.println("System Path"+projectPath);
			System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://todomvc.com/examples/vue/#/all");	
		}

		@When("^User Enter (.*) in the Text Box and Press Enter for Edit$")
		public void user_enter_todo_in_the_text_box_and_press_enter(String Todo) {
			itemList=new TodoPage(driver);
			itemList.addTask(Todo);
		}
		@And("^Double-click (.*) to edit and Update it with (.*)$")
		public void update_todo(String Todo, String updatedTodo) {
			itemList=new TodoPage(driver);
			itemList.editTask(Todo,updatedTodo);
		}
		@Then("^Verify (.*) is Displayed in All List after Edit$")
		public void verify_updateTodo_is_added_to_all_list(String Todo) {
			itemList.openAllTab();
			itemList.checkTaskList(Todo);
		}

		@And("^Verify (.*) is Displayed in Active List after Edit$")
		public void verify_updateTodo_is_added_to_active_list(String Todo) {
			itemList.openActiveTab();
			itemList.checkTaskList(Todo);
			driver.close();
			driver.quit();
		}
	}

