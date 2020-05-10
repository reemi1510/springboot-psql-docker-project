package com.project.userprofile.util;

import org.testcontainers.containers.PostgreSQLContainer;

//Singleton design pattern used here.
public class FunctionalTestsContainer extends PostgreSQLContainer<FunctionalTestsContainer> {

    private static final String IMAGE_VERSION = "postgres:9.6";

    //Private static instance
    private static FunctionalTestsContainer container;

    //Private constructor
    private FunctionalTestsContainer() {
        super(IMAGE_VERSION);
    }

    //Static factory method checks static instance is null before creating instance.
    public static FunctionalTestsContainer getInstance() {
        if (container == null) {
            container = new FunctionalTestsContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //JVM will handle container shut down.
    }

}
