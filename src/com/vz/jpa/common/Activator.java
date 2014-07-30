package com.vz.jpa.common;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class Activator extends ResourceConfig {
    public Activator() {
        packages("com.jpa");
    }
    
}

