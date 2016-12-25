package ru.stqa.pft.addressbook.Task13.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    public NavigationHelper navigationHelper;
    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        sessionHelper = new SessionHelper(wd);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }
}