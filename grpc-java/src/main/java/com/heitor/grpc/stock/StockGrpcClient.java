package com.heitor.grpc.stock;

import com.google.protobuf.Empty;
import com.heitor.grpc.Stock;
import com.heitor.grpc.StockServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class StockGrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);
        Iterator<Stock> stockStatics = stub.stockStatics(Empty.newBuilder().build());
        for (int i = 0; stockStatics.hasNext(); i++) {
            System.out.println(stockStatics.next());
        }
    }
}
