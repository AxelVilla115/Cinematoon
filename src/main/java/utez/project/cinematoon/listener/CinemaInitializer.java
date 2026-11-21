package utez.project.cinematoon.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import utez.project.cinematoon.storage.CinemaStorage;

@WebListener
public class CinemaInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        CinemaStorage.initialize();
    }
}