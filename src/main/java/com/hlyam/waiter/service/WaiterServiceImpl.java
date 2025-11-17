package com.hlyam.waiter.service;

import com.hlyam.waiter.grpc.CreateOrderRequest;
import com.hlyam.waiter.grpc.OrderResponse;
import com.hlyam.waiter.grpc.WaiterServiceGrpc;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class WaiterServiceImpl extends WaiterServiceGrpc.WaiterServiceImplBase {

    @Override
    public void createOrder(CreateOrderRequest request,
                            StreamObserver<OrderResponse> responseObserver) {
        OrderResponse response = OrderResponse.newBuilder()
                .setMessage("Order received: " + request.getOrder())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}