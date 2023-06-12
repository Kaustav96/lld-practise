package interview.practise.lld.covidTracker.model;


public class Person {
    private Address address;
    private String phone;
    private boolean isAdmin;

    public Person( Address address,String phone,boolean isAdmin) {

        this.address = address;

        this.phone = phone;
        this.isAdmin = isAdmin;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
