package fon.ai.maventrapsortappcommon.domain;

import org.junit.jupiter.api.Test;

import fon.ai.maventransportappcommon.domain.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testSetUserIDInvalid() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setUserID(0), "Očekuje se IllegalArgumentException kada je userID 0.");
    }

    @Test
    public void testSetUsernameNull() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null), "Očekuje se IllegalArgumentException kada je username null.");
    }

    @Test
    public void testSetUsernameEmpty() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(""), "Očekuje se IllegalArgumentException kada je username prazan string.");
    }

    @Test
    public void testSetPasswordNull() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null), "Očekuje se IllegalArgumentException kada je password null.");
    }

    @Test
    public void testSetPasswordEmpty() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(""), "Očekuje se IllegalArgumentException kada je password prazan string.");
    }

    @Test
    public void testSetNameNull() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setName(null), "Očekuje se IllegalArgumentException kada je name null.");
    }

    @Test
    public void testSetNameEmpty() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setName(""), "Očekuje se IllegalArgumentException kada je name prazan string.");
    }

    @Test
    public void testSetNameInvalid() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setName("A1"), "Očekuje se IllegalArgumentException kada name sadrži nedozvoljene karaktere.");
        assertThrows(IllegalArgumentException.class, () -> user.setName("A"), "Očekuje se IllegalArgumentException kada name ima manje od 2 karaktera.");
    }

    @Test
    public void testSetSurnameNull() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setSurname(null), "Očekuje se IllegalArgumentException kada je surname null.");
    }

    @Test
    public void testSetSurnameEmpty() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setSurname(""), "Očekuje se IllegalArgumentException kada je surname prazan string.");
    }

    @Test
    public void testSetSurnameInvalid() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setSurname("B1"), "Očekuje se IllegalArgumentException kada surname sadrži nedozvoljene karaktere.");
        assertThrows(IllegalArgumentException.class, () -> user.setSurname("B"), "Očekuje se IllegalArgumentException kada surname ima manje od 2 karaktera.");
    }

    @Test
    public void testSetEmailInvalid() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setEmail("invalidEmail"), "Očekuje se IllegalArgumentException kada email nije validan.");
        assertThrows(IllegalArgumentException.class, () -> user.setEmail(""), "Očekuje se IllegalArgumentException kada je email prazan string.");
        assertThrows(IllegalArgumentException.class, () -> user.setEmail(null), "Očekuje se IllegalArgumentException kada je email null.");
    }
}
