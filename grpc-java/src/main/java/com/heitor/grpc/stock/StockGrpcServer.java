package com.heitor.grpc.stock;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class StockGrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int PORT = 8080;
        Server server = ServerBuilder.forPort(PORT).addService(new StockImpl()).build();
        server.start();
        System.out.println("SERVER LISTENING ON PORT " + PORT);
        server.awaitTermination();
    }
}
