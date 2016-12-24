package ru.stqa.pft.addressbook.Task10.model;

public class ContactData {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String company;
    private final String address;
    private final String telephoneMobile;
    private final String telephoneWork;
    private final String email;
    private final String homepage;
    private String group;

    public ContactData(int id, String firstname, String middlename, String lastname, String company, String address, String telephoneMobile, String telephoneWork, String email, String homepage, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.telephoneMobile = telephoneMobile;
        this.telephoneWork = telephoneWork;
        this.email = email;
        this.homepage = homepage;
        this.group = group;
    }

    public ContactData(String firstname, String middlename, String lastname, String company, String address, String telephoneMobile, String telephoneWork, String email, String homepage, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.telephoneMobile = telephoneMobile;
        this.telephoneWork = telephoneWork;
        this.email = email;
        this.homepage = homepage;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public String getTelephoneWork() {
        return telephoneWork;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}