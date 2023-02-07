package  com.example.automart.creator;

import  com.example.automart.entity.User;

import java.math.BigDecimal;

public class UserCreator {
    public static final String USERNAME = "Test";
    public static final String PASSWORD = "longpassword123";
    public static final String FULL_NAME = "Test";
    public static final String EMAIL = "randomemail@gmail.test";
    public static final BigDecimal BALANCE = new BigDecimal(1000);
    public static final String CITY = "Warsaw";

    public static User createTestUser() {
        User testObject = new User();

        testObject.setUsername(USERNAME);
        testObject.setPassword(PASSWORD);
        testObject.setPasswordConfirm(PASSWORD);
        testObject.setFullName(FULL_NAME);
        testObject.setEmail(EMAIL);
        testObject.setBalance(BALANCE);
        testObject.setCity(CITY);

        return testObject;
    }
}
