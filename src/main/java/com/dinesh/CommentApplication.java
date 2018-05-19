package com.dinesh;

import com.dinesh.resources.ProductComment;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CommentApplication extends Application<CommentConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CommentApplication().run(args);
    }

    @Override
    public String getName() {
        return "Comment";
    }

    @Override
    public void initialize(final Bootstrap<CommentConfiguration> bootstrap) {
    }

    @Override
    public void run(final CommentConfiguration configuration,
                    final Environment environment) {
        final ProductComment resource = new ProductComment();
        environment.jersey().register(resource);
    }

}
