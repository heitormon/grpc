package com.heitor.grpc;

import io.grpc.stub.StreamObserver;

public class MessageImpl extends MessageServiceGrpc.MessageServiceImplBase {
    @Override
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        System.out.println(request);
        String message = request.getText();
        responseObserver.onNext(MessageResponse.newBuilder().setText(message + " .Hello from server").build());
        responseObserver.onCompleted();
    }
}
