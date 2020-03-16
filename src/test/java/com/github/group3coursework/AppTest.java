package com.github.group3coursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AppTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void packageSelectorEmpty()
    {
        app.packageSelector("");
    }

    @Test
    void packageSelectorReport()
    {
        app.packageSelector("Report");
    }

    @Test
    void packageSelectorPopulation()
    {
        app.packageSelector("Population");
    }

    @Test
    void packageSelectorPUrbanPopulation()
    {
        app.packageSelector("Urban Population");
    }
}
