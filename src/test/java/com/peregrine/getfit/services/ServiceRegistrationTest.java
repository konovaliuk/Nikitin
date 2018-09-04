package com.peregrine.getfit.services;

import com.peregrine.getfit.dao.DAOUser;
import com.peregrine.getfit.entities.User;
import junit.framework.TestCase;

public class ServiceRegistrationTest extends TestCase {

    DAOUser daoUser = new DAOUser();

    public void testRegisterUser() {
        User user = new User();

        user.setFirstName("bob");
        user.setLastName("buttons");
        user.setEmail("bob.buttons@gmail.com");
        user.setPassword("bobbuttons");
        user.setAge(54);
        user.setWeight(101.0);
        user.setHeight(170.0);
        user.setGender("male");
        user.setLifestyle("minimum");

        ServiceRegistration.registerUser(user);
        String email = user.getEmail();
        assertNotNull(email);

        User newUser = daoUser.findUserByEmail(email);
        assertEquals("bob",newUser.getFirstName());
        assertEquals("bob.buttons@gmail.com",newUser.getEmail());
        assertEquals("bob",newUser.getFirstName());
    }
}