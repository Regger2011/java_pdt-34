package ru.stqa.pft.addressbook.Task6.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.Task6.model.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("homepage"),contactData.getHomepage());
        type(By.name("email"),contactData.getEmail());
        type(By.name("work"),contactData.getTelephoneWork());
        type(By.name("mobile"),contactData.getTelephoneMobile());
        type(By.name("address"),contactData.getAddress());
        type(By.name("company"),contactData.getCompany());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("firstname"),contactData.getFirstname());
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }
}