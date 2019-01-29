package seleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;

    public static void main(String[] args){

        FirstTest firstTest = new FirstTest();
        firstTest.invokeBrowser();
        firstTest.getTitle();
        firstTest.hoverMenu();
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

            //open the url
            String url = "http://softwaretestingmaterial.com";
            driver.get(url);

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

    public void hoverMenu(){
        try{
            WebElement mainMenu = driver.findElement(By.id("menu-item-4358"));
            WebElement subMenu = driver.findElement(By.id("menu-item-4733"));

            //create an object 'action' of Selenium Actions class
            Actions action = new Actions(driver);

            action.moveToElement(mainMenu).build().perform();
            Thread.sleep(2000);
            action.moveToElement(subMenu).click().build().perform();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


