package com.demo;

import com.demo.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;


public class Main {
    public static void main(String[] args) throws LifecycleException {
        // Boiler plate
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, baseDoc);

        // IOC Container app
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        springContext.register(WebConfig.class);

        // Dispatcher Servlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);

        Tomcat.addServlet(
                context, "dispatcherServlet", dispatcherServlet);

        context.addServletMappingDecoded(
                "/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        // keep server running
        tomcat.getServer().await();
    }
}