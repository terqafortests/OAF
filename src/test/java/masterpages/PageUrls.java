package masterpages;

/**
 * Created by beetlezhuk on 11/21/15.
 */
public enum PageUrls
{
    LOGIN_PAGE ("http://test.salesforce.com"),
    HOME_PAGE ("https://bpp-13fd3e55182--noahqa.cs17.my.salesforce.com/home/home.jsp"),
    SEARCH_PAGE("https://bpp-13fd3e55182--noahqa.cs17.my.salesforce.com/search/AdvancedSearch");

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
