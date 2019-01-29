package seleniumBasic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;

    public static void main(String[] args){

        FirstTest firstTest = new FirstTest();
        firstTest.invokeBrowser();
        firstTest.getTitle();
    }

    public void invokeBrowser(){
        try{
            //the path to executable ChromeDriver file in local machine
            System.setProperty("webdriver.chrome.driver" ,
                    "C:\\Users\\happy\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");


            //instantiate the chrome driver
            driver = new ChromeDriver();
            //delete all the cookies in the web browser
            driver.manage().deleteAllCookies();
            //when the window first open it will open in the minimize form, we need to maximize the browser
            driver.manage().window().maximize();
            //page synchronization
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            //call the url
            driver.get("http://softwaretestingmaterial.com");

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void getTitle(){
        String expectedTitle = "Software Testing Material";
        String actualTitle;

        actualTitle = driver.getTitle();

        if(actualTitle.contentEquals(expectedTitle)){
            System.out.println("The expected title is " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
            System.out.println("The title does match!!!");
        }else{
            System.out.println("The expected title is " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
            System.out.println("The title does not match!!!");
        }

    }
}
