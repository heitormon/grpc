package com.heitor.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int PORT = 8080;
        Server server = ServerBuilder.forPort(PORT).addService(new MessageImpl()).build();
        server.start();
        System.out.println("SERVER LISTENING ON PORT " + PORT);
        server.awaitTermination();

    }
}
