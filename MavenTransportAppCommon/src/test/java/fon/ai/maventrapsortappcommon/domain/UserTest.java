package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import fon.ai.maventransportappcommon.domain.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testSetUserIDInvalid() {
        assertThrows(IllegalArgumentException.class, () -> user.setUserID(0), "Očekuje se IllegalArgumentException kada je userID 0.");
    }

    @Test
    public void testSetUsernameNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null), "Očekuje se IllegalArgumentException kada je username null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    public void testSetUsernameInvalid(String invalidUsername) {
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(invalidUsername), "Očekuje se IllegalArgumentException za nevalidan username: " + invalidUsername);
    }

    @Test
    public void testSetPasswordNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null), "Očekuje se IllegalArgumentException kada je password null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    public void testSetPasswordInvalid(String invalidPassword) {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(invalidPassword), "Očekuje se IllegalArgumentException za nevalidan password: " + invalidPassword);
    }

    @Test
    public void testSetNameNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setName(null), "Očekuje se IllegalArgumentException kada je name null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "A1", "A"})
    public void testSetNameInvalid(String invalidName) {
        assertThrows(IllegalArgumentException.class, () -> user.setName(invalidName), "Očekuje se IllegalArgumentException za nevalidno ime: " + invalidName);
    }

    @Test
    public void testSetSurnameNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setSurname(null), "Očekuje se IllegalArgumentException kada je surname null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "B1", "B"})
    public void testSetSurnameInvalid(String invalidSurname) {
        assertThrows(IllegalArgumentException.class, () -> user.setSurname(invalidSurname), "Očekuje se IllegalArgumentException za nevalidno prezime: " + invalidSurname);
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalidEmail", ""})
    public void testSetEmailInvalid(String invalidEmail) {
        assertThrows(IllegalArgumentException.class, () -> user.setEmail(invalidEmail), "Očekuje se IllegalArgumentException za nevalidan email: " + invalidEmail);
    }
}
