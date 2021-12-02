package com.heitor.grpc.stock;

import com.google.protobuf.Empty;
import com.heitor.grpc.Stock;
import com.heitor.grpc.StockServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StockImpl extends StockServiceGrpc.StockServiceImplBase {
    private static List<Stock> stocks = new ArrayList<>(Arrays.asList(
            Stock.newBuilder()
                    .setDate(LocalDate.now().toString())
                    .setPrice(20.5)
                    .setDescription("Amazon")
                    .setCode("97e8dfc4-53a3-11ec-bf63-0242ac130002")
                    .build(),
            Stock.newBuilder()
                    .setDate(LocalDate.now().toString())
                    .setPrice(12.5)
                    .setDescription("Netflix")
                    .setCode("a167e950-53a3-11ec-bf63-0242ac130002")
                    .build()));
    private static Random random = new Random();

    @Override
    public void stockStatics(Empty request, StreamObserver<Stock> responseObserver) {
        while (true) {
            try {
                Thread.sleep(3000);
                responseObserver.onNext(stocks.get(random.nextInt(stocks.size())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
