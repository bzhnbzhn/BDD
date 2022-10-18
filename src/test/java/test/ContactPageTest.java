package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ContactPageTest {

    private static final String STREET_NUMBER_PATTERN = "^\\d{1,3}";
    private static final String STREET_NAME_PATTERN = "^\\d{1,3}.\\w{3,20}.\\w{3,20}";
    private static final String APARTMENT_NAME_PATTERN = "[A-Za-z]{3,10} \\d{3}";
    private static final String CITY_NAME_PATTERN = "(?<=\\n)[^,\\n]+(?=,)";
    private static final String POST_CODE_PATTERN = "[A-Z]{2}[ ]?\\d{5}?";
    private static final String COUNTRY_PATTERN = "[A-Za-z0-9_-]{2,19}$";

    private static final String ADDRESS_EPAM = "41 University Drive • Suite 202,\n" + "Newtown, PA 18940 • USA";

    public boolean isAddressByRegExValid(String numberPattern) {
        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(ADDRESS_EPAM);
        return matcher.find();
    }

    public String getAddressByRegEx(String addressPattern) {
        Pattern pattern = Pattern.compile(addressPattern);
        Matcher matcher = pattern.matcher(ADDRESS_EPAM);
        matcher.find();
        return matcher.group();
    }

    @Test
    void isStreetNumberValid() {
        Assertions.assertTrue(isAddressByRegExValid(STREET_NUMBER_PATTERN));
    }

    @Test
    void isStreetNumber41() {
        Assertions.assertEquals(getAddressByRegEx(STREET_NUMBER_PATTERN), ("41"));
    }

    @Test
    void isCountyNameValid() {
        Assertions.assertTrue(isAddressByRegExValid(COUNTRY_PATTERN), "Country name was not found ");
    }

    @Test
    void isCountyNameUSA() {
        Assertions.assertEquals(getAddressByRegEx(COUNTRY_PATTERN), ("USA"), "The Country is not USA");
    }

    @Test
    void isPostCodeValid() {
        Assertions.assertTrue(isAddressByRegExValid(POST_CODE_PATTERN), "The Post Code was not found ");
    }

    @Test
    void isPostCodePA18940() {
        Assertions.assertEquals(getAddressByRegEx(POST_CODE_PATTERN), ("PA 18940"), "The Post Code is not PA 18940");
    }

    @Test
    void isApartmentValid() {
        Assertions.assertTrue(isAddressByRegExValid(APARTMENT_NAME_PATTERN), "The apartment was not found");
    }

    @Test
    void isApartmentSuite_202() {
        Assertions.assertEquals(getAddressByRegEx(APARTMENT_NAME_PATTERN), ("Suite 202"), "The apartment is not Suite 202");
    }

    @Test
    void isStreetNameValid() {
        Assertions.assertTrue(isAddressByRegExValid(STREET_NAME_PATTERN), "The street name was not found");
    }

    @Test
    void isStreetName41UniDrv() {
        Assertions.assertEquals(getAddressByRegEx(STREET_NAME_PATTERN), ("41 University Drive"), "The street name is not 41 University Drive");
    }

    @Test
    void isCityNameValid() {
        Assertions.assertTrue(isAddressByRegExValid(CITY_NAME_PATTERN), "The city name was not found");
    }

    @Test
    void isCityNameNewtown() {
        Assertions.assertEquals(getAddressByRegEx(CITY_NAME_PATTERN), ("Newtown"), "The city name is not Newtown");
    }


    @Test
    void isEmailValid() {
        Pattern pattern = Pattern.compile("\\w{3,20}@.+\\.com");
        Matcher matcher = pattern.matcher("bazhan@live.com");
        Assertions.assertTrue(matcher.find(), "Email is not correct");
    }

    @Test
    void isEmailInvalid() {
        Pattern pattern = Pattern.compile("\\w{3,20}@.+\\.com");
        Matcher matcher = pattern.matcher("bazhanlive.com");
        Assertions.assertFalse(matcher.find(), "Email is not correct");
    }

    @Test
    void isIPAddressValid() {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        Matcher matcher = pattern.matcher("93.75.3.165");
        Assertions.assertTrue(matcher.find(), "IP address is not correct");
    }

    @Test
    void isCreditCartValid() {
        Pattern pattern = Pattern.compile("\\d{4}( )*\\d{4}( )*\\d{4}( )*\\d{4}+");
        Matcher matcher = pattern.matcher("1111111111111111");
        Assertions.assertTrue(matcher.find(), "Credit cart is not valid");
    }


}
