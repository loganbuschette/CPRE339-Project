package com.example.matt.a339project;

/**
 * Created by Matt on 11/15/2016.
 */

import java.io.IOException;
import java.lang.reflect.Method;

public class Controller {
    private static Controller controller;
    public String userId;

    public static Controller factory() {
        if (controller == null) controller = new Controller();
        return controller;
    }

    private Controller() {}
}
