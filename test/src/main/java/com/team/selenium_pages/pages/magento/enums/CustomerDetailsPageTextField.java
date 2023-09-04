package com.team.selenium_pages.pages.magento.enums;

public enum CustomerDetailsPageTextField {

    EmailAddress("username"),
    FirstName("firstname"),
    LastName("lastname"),
    Company("company"),
    City("city"),
    PhoneNumber("telephone"),
    ZipCode("postcode"),
    StreetFirstFirstLine("street[0]");

    private final String value;

    CustomerDetailsPageTextField(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
