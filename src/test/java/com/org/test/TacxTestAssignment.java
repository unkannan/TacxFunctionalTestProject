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
	/*
	 * @Test public void tc_01_createAccount_tacx_MainPageVerification() {
	 * 
	 * //Tacx image is shown //push your limits is shown //Login button is shown
	 * //Create Account is shown }
	 * 
	 * @Test public void tc_02_clickCreateAccountFunctionalCheck() { //Click
	 * CreateAccount }
	 * 
	 * @Test public void tc_03__SignUpPageVerification() { //Verify SignUp //Verify
	 * Push your limits //Verify First name text box }
	 * 
	 * @Test public void tc_04_click_Returntologinpage_FunctionalCheck() {
	 * //clickReturntoLoginPage //Verify SignUp //Verify Push your limits }
	 */

	// @Test
	public void tc_05_clickSignUp_withdetails() {
		signupPage.clickCreateAccount();
		signupPage.EnterSignUpDetails();
		signupPage.clickSignUp();
		assertEquals(dashboard.getCurrentURL(), "https://cloud.tacx.com/#/signup");
		dashboard.clickCreateWorkOut();
		createworkout.clickPower();
		createworkout.clickDistance();
		createworkout.clickContinue();

		while (true) {
			String kms = createworkoutcreate.getKms();
			if (kms.equals("12.0 km"))
				break;
			createworkoutcreate.clickdistanceincreaseindicator();
		}
		assertEquals(createworkoutcreate.getKms(), "12.0 km");
		createworkoutcreate.clicksave();
		savedialog.entertitle("title");
		savedialog.clickSave();

		workouts.clickWorkouts();
		assertEquals(workouts.getworkoutTitleNewlyCreated(), "title");
	}
}