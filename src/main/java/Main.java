package com.mycompany.campustasks;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // تشغيل السيرفر على البورت 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // 1. الصفحة الرئيسية للمشروع
        server.createContext("/", exchange -> {
            String response = "Welcome to Campus Tasks API";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        // 2. مسار الحالة (Status)
        server.createContext("/status", exchange -> {
            String response = "{\"project\": \"CampusTasks\", \"status\": \"running\", \"student\": \"Tariq\"}";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        // 3. مسار إضافي بسيط
        server.createContext("/about", exchange -> {
            String response = "This is a simple java API for my university assignment";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.setExecutor(null); 
        server.start();
        System.out.println("API Server is up and running on port 8080");
    }
}