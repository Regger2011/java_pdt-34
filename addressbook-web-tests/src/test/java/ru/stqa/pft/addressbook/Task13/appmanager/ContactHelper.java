package ru.stqa.pft.addressbook.Task13.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.Task13.model.ContactData;
import ru.stqa.pft.addressbook.Task13.model.Contacts;

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
        type(By.name("home"),contactData.getTelephoneHome());
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
        initContactModificationById(contact.getId());
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

    public void initContactModificationById(int id) {
        //String xpath = "//a[contains(@href, 'edit')][contains(@href, '"+ id +"')]";
        //click(By.xpath(xpath));

        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s'", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
        //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
        //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
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

    public int count() {
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
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String[] phones = cells.get(5).getText().split("\n");
            contacts.add (new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withAddress(address)
                    .withTelephoneHome(phones[0])
                    .withTelephoneWork(phones[1])
                    .withTelephoneMobile(phones[2])
                    .withEmail(email));
        }
        return contacts;
    }

    public Contacts allCash() {
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

    public ContactData infoFromEditForm(ContactData contact) {
          initContactModificationById(contact.getId());
          String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
          String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
          String address = wd.findElement(By.name("address")).getAttribute("value");
          String telephoneHome = wd.findElement(By.name("home")).getAttribute("value");
          String telephoneWork = wd.findElement(By.name("work")).getAttribute("value");
          String telephoneMobile = wd.findElement(By.name("mobile")).getAttribute("value");
          String email = wd.findElement(By.name("email")).getAttribute("value");
          wd.navigate().back();
          return new ContactData()
                  .withId(contact.getId())
                  .withFirstname(firstname)
                  .withLastname(lastname)
                  .withAddress(address)
                  .withTelephoneHome(telephoneHome)
                  .withTelephoneWork(telephoneWork)
                  .withTelephoneMobile(telephoneMobile)
                  .withEmail(email);
    }
}