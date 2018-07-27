package com.andyatkinson;

import io.javalin.Javalin;

public class HelloWorld {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
                             .port(getHerokuAssignedPort())
                             .start()
                             .get("/", ctx -> ctx.result("Hello World"));
    }

    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7000;
    }
}
