package ru.stqa.pft.addressbook.Task12.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.Task12.model.ContactData;
import ru.stqa.pft.addressbook.Task12.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("mobile"),contactData.getTelephoneMobile());
        type(By.name("work"),contactData.getTelephoneWork());
        type(By.name("email"),contactData.getEmail());
        type(By.name("homepage"),contactData.getHomepage());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact, false);
        submitUpdateContactModification();
        contactCash = null;
        returnToHomePage();
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        contactCash = null;
        new NavigationHelper(wd).contactPage();
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]"));
    }

    public void submitUpdateContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void returnToHomePage() {
        click (By.linkText("home page"));
    }

    public void create(ContactData contact) {
        fillContactForm(contact,true);
        submitContactCreation();
        contactCash = null;
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.getText().split(" ")[0];
            String middlename = element.getText().split(" ")[0];
            String lastname = element.getText().split(" ")[0];
            String address = element.getText().split(" ")[0];
            String telephoneMobile = element.getText().split(" ")[0];
            String email = element.getText().split(" ")[0];
            contacts.add (new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withMiddlename(middlename)
                    .withLastname(lastname)
                    .withAddress(address)
                    .withTelephoneMobile(telephoneMobile)
                    .withEmail(email));
        }
        return contacts;
    }

    private Contacts contactCash = null;

    public Contacts all() {
        if (contactCash !=null) {
            return new Contacts(contactCash);
        }
        contactCash = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.getText().split(" ")[0];
            //String middlename = element.getText().split(" ")[0];
            String lastname = element.getText().split(" ")[0];
            String address = element.getText().split(" ")[0];
            //String telephoneMobile = element.getText().split(" ")[0];
            String email = element.getText().split(" ")[0];
            contactCash.add (new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    //.withMiddlename(middlename)
                    .withLastname(lastname)
                    .withAddress(address)
                    //.withTelephoneMobile(telephoneMobile)
                    .withEmail(email));
        }
        return new Contacts(contactCash);
    }
}