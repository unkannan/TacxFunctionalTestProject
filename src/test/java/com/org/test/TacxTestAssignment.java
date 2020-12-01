package com.org.test;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

import com.org.pages.CreateWorkoutCreatePage;
import com.org.pages.CreateWorkoutPage;
import com.org.pages.Dashboardpage;
import com.org.pages.SaveDialogBox;
import com.org.pages.TacxSignUpPage;
import com.org.pages.WorkoutsPage;
import com.org.utility.Dataprovider;
import com.org.utility.StartApplication;

public class TacxTestAssignment extends StartApplication {
	public static Logger logger = Logger.getLogger(TacxTestAssignment.class.getName());
	TacxSignUpPage signupPage;
	Dashboardpage dashboard;
	CreateWorkoutPage createworkout;
	CreateWorkoutCreatePage createworkoutcreate;
	SaveDialogBox savedialog;
	WorkoutsPage workouts;

	@BeforeMethod
	public void OpenTacxApplication() {
		signupPage = new TacxSignUpPage(driver);
		dashboard = new Dashboardpage(driver);
		createworkout = new CreateWorkoutPage(driver);
		createworkoutcreate = new CreateWorkoutCreatePage(driver);
		savedialog = new SaveDialogBox(driver);
		workouts = new WorkoutsPage(driver);

	}
	 @Test
	public void tc_05_clickSignUp_withdetails() {
		 logger.info("******************Functional Testing for Tacx application started****************** ");
		signupPage.clickCreateAccount();
		signupPage.EnterSignUpDetails();
		signupPage.clickSignUp();
		assertEquals(dashboard.getCurrentURL(), Dataprovider.dashboardURL);
		dashboard.clickCreateWorkOut();
		createworkout.clickPower();
		createworkout.clickDistance();
		createworkout.clickContinue();
		
		createworkoutcreate.kmsworkedOutTotal(Dataprovider.kmsWorkedOut);
		assertEquals(createworkoutcreate.getKms(), Dataprovider.kmsWorkedOut);
		createworkoutcreate.clicksave();
		savedialog.entertitle(Dataprovider.workedOutTitleSaved);
		savedialog.clickSave();

		workouts.clickWorkouts();
		assertEquals(workouts.getworkoutTitleNewlyCreated(), Dataprovider.workedOutTitleSaved);
		dashboard.clickSignOut();
		logger.info("******************Functional Testing for Tacx application COMPLETED ****************** ");
	}
}