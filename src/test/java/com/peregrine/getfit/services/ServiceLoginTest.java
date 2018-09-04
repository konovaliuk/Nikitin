package com.peregrine.getfit.services;

import com.peregrine.getfit.entities.User;
import junit.framework.TestCase;

public class ServiceLoginTest extends TestCase {


    public void testGetRegisteredUser() {
        User user = new User();
        user.setEmail("ilya.ninja@gmail.com");
        user.setPassword("wanderboy");

        String email = user.getEmail();
        String password = user.getPassword();
        assertNotNull(email);
        assertNotNull(password);

        User newUser = ServiceLogin.getRegisteredUser(email,password);
        assertEquals("Ilya",newUser.getFirstName());
        assertEquals("Nikitin", newUser.getLastName());
        assertEquals("ilya.ninja@gmail.com", newUser.getEmail());
    }

    public void testGetRegisteredUser_Fail() {
        User user = new User();

        user.setEmail("nikola.tesla@yahoo.com");
        user.setPassword("wardencliff");

        String email = user.getEmail();
        String password = user.getPassword();
        assertNotNull(email);
        assertNotNull(password);

        User newUser = ServiceLogin.getRegisteredUser(email,password);
        assertNull(newUser);
    }

    public void testGetRegisteredUser_WrongPassword() {
        User user = new User();
        user.setEmail("ilya.ninja@gmail.com");
        user.setPassword("wanderboy1");

        String email = user.getEmail();
        String password = user.getPassword();
        assertNotNull(email);
        assertNotNull(password);

        User newUser = ServiceLogin.getRegisteredUser(email,password);
        assertNull(newUser);
    }

}