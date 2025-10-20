package dataProviderSet;

import org.testng.annotations.DataProvider;

public class LoginDataProvider
{
    @DataProvider(name = "DataforLogin")
    public Object[][] getLoginData(){
        return new Object[][]{
                {"Admin", "admin123"},
                {"Shashika", "shashi123"}
        };
    }

}
