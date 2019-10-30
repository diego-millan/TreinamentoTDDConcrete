package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class RouterManagerTest {

    @Test
    public void checkIfEndpointWithoutParametersIsValid() {
        String url = "/posts";

        RouterManager routerManager = new RouterManager();
        boolean isValidRoute = routerManager.isValid(url);

        Assertions.assertTrue(isValidRoute);
    }

    @Test
    public void checkIfEndpointWithoutParametersIsInvalid() {
        String url = "/posts1";

        RouterManager routerManager = new RouterManager();
        boolean isValidRoute = routerManager.isValid(url);

        Assertions.assertFalse(isValidRoute);
    }

    @Test
    public void checkIfNullableEndpointIsInvalid() {
        String url = null;

        RouterManager routerManager = new RouterManager();
        boolean isValidRoute = routerManager.isValid(url);

        Assertions.assertFalse(isValidRoute);
    }

    @Test
    public void checkIfEndpointWithParameterExists() {
        String url = "/users/1";

        RouterManager routerManager = new RouterManager();
        boolean isValidRoute = routerManager.isValid(url);

        Assertions.assertTrue(isValidRoute);
    }
}
