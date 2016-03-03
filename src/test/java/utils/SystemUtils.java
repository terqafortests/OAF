package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class SystemUtils
{
    private String file_name;
    private String user;

//    public Properties read_config()
//    {
//        Properties properties = new Properties();
//        InputStream istream = getClass().getClassLoader().getResourceAsStream("config.properties");
//
//        try
//        {
//            if(istream != null)
//            {
//                properties.load(istream);
//            }
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        return properties;
//    }

    //Return application root
    public String get_app_root()
    {
        String root = "";

        try
        {
            root = System.getProperty("user.dir");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return root;
    }

    public void set_user(String file_name, String user)
    {
        this.file_name = file_name;
        this.user = user;
    }

    //Returns object of JSON file
//    private JSONObject read_from_JSON(String file_name)
//    {
//        JSONParser parser = new JSONParser();
//        JSONObject json_object = new JSONObject();
//
//        try
//        {
//            json_object = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(this.get_app_root() +
//                    File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator +
//                    "external" + File.separator + file_name + ".json")));
//        }
//        catch(ParseException e)
//        {
//            e.printStackTrace();
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        return json_object;
//    }

//    public String get_user_data(String element)
//    {
//        JSONObject json = this.read_from_JSON(this.file_name);
//        JSONObject line = (JSONObject) json.get(this.user);
//        String data = line.get(element).toString();
//
//        return data;
//    }

    private String get_os()
    {
        return System.getProperty("os.name");
    }

    private String get_computer_user()
    {
        return System.getProperty("user.name");
    }

    public String default_locations()
    {
        String path = "";

        if(this.get_os().contains("Linux"))
        {
            path = "/home" + File.separator + this.get_computer_user() + File.separator +
                    "Documents" + File.separator;
        }
        else if(this.get_os().contains("Mac"))
        {
            path = "/users" + File.separator + this.get_computer_user() + File.separator +
                    "Downloads" + File.separator;
        }
        else if(this.get_os().contains("Windows"))
        {
            path = "C:" + File.separator + "Users" + File.separator + this.get_computer_user() +
                    File.separator + "Downloads" + File.separator;
        }

        return path;
    }

    public String get_chrome_path()
    {
        String path = "";

        if(this.get_os().contains("Linux"))
        {
            path = get_app_root() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" +
                    File.separator + "chromedrivers" + File.separator + "chromedriver";
        }
        else if(this.get_os().contains("Mac"))
        {
            path = get_app_root() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" +
                    File.separator + "chromedrivers" + File.separator + "macdriver";
        }
        else if(this.get_os().contains("Windows"))
        {
            path = get_app_root() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" +
                    File.separator + "chromedrivers" + File.separator +  "windriver.exe";
        }

        return path;
    }

    public String get_opera_path()
    {
        String path = "";

        if(this.get_os().contains("Linux"))
        {
            path = get_app_root() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" +
                    File.separator + "operadrivers" + File.separator + "operalinuxdriver";
        }
        else if(this.get_os().contains("Mac"))
        {
            path = get_app_root() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" +
                    File.separator + "operadrivers" + File.separator + "operamacdriver";
        }
        else if(this.get_os().contains("Windows"))
        {
            path = get_app_root() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "webdrivers" +
                    File.separator + "operadrivers" + File.separator +  "operawindriver64.exe";
        }

        return path;
    }

    public String get_date()
    {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
        Date date = new Date();

        return formatter.format(date);
    }
}
