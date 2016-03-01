package tests;

import masterpages.PageHead;
import masterpages.PageUrls;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by beetlezhuk on 11/22/15.
 */
public class SelectCourseTest extends PageHead
{
//    @Parameters({"username", "password"})
    @Test
    public void select_course(String username, String password)
    {
            factory.login_page().
                    open().
                    EnterUsername(username).
                    EnterPassword(password).
                    ClickOnLoginBtn();

            factory.my_learning_page().
                    SelectCourse("AZ RC 1").
                    ClickOnOpenButton().
                    CourseDetailsAreShown();


    }
}
