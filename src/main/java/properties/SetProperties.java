package properties;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class SetProperties {
	
	private String url;
    private String username;
    private String password;
    private String api_key;
    private String browser;
    private String listName;
    private String listDescription;
    private String movie;


    public SetProperties(){
        Properties properties = new Properties();
		try {
			properties.load(new FileReader("src/test/resources/data.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        setApi_key(properties.getProperty("api_key"));
        setUrl(properties.getProperty("url"));
        setPassword(properties.getProperty("password"));
        setUsername(properties.getProperty("username"));
        setBrowser(properties.getProperty("browser"));
        setListName(properties.getProperty("list_title"));
        setListDescription(properties.getProperty("list_description"));
        setMovie(properties.getProperty("movie_title"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getBrowser() {
        return browser;
    }
    public String getMovie() {
        return movie;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
	

}
