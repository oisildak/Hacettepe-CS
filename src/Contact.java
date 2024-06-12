public class Contact implements  Comparable<Contact> {
    private String phoneNumber;
    private String firtName;
    private String surName;
    private String socialSecurityNumber;

    public Contact(String phoneNumber, String firtName, String surName, String socialSecurityNumber) {
        this.phoneNumber = phoneNumber;
        this.firtName = firtName;
        this.surName = surName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if (!(obj instanceof Contact)) return false;
        Contact contact=(Contact)obj;
        return this.hashCode()==obj.hashCode();
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


    @Override
    public int compareTo(Contact o) {
        return this.phoneNumber.compareTo(o.phoneNumber);
    }
}
