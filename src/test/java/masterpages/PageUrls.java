package masterpages;

/**
 * Created by beetlezhuk on 11/21/15.
 */
public enum PageUrls
{
    SALESFORCE_LOGIN_PAGE("http://test.salesforce.com"),
    SALESFORCE_HOME_PAGE("https://cs11.salesforce.com/home/home.jsp");

    private String url;

    PageUrls(String url)
    {
        this.url = url;
    }

    public String GetEnumPageUrl()
    {
        return this.url;
    }
}
