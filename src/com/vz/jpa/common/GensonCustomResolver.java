package com.vz.jpa.common;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.owlike.genson.Genson;

@Provider
public class GensonCustomResolver implements ContextResolver<Genson> {
    // configure the Genson instance
    private final Genson genson = new Genson.Builder().create();

    @Override
    public Genson getContext(Class<?> type) {
        return genson;
    }
}
