package com.glancebar.webfluxtutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


/**
 * Create a router, expose <em>/hello</em>
 */
@Configuration
public class GreetingRouter {


    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(RequestPredicates
                        .GET("/hello")
                        .and(RequestPredicates
                                .accept(MediaType.TEXT_PLAIN)),
                        greetingHandler::hello);
    }

}
