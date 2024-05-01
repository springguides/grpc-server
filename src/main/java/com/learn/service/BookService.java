package com.learn.service;

import com.learn.grpc.BookRequest;
import com.learn.grpc.BookResponse;
import com.learn.grpc.BookServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookService extends BookServiceGrpc.BookServiceImplBase{

    public void getBook(BookRequest bookRequest, StreamObserver<BookResponse> responseStreamObserver){
        BookResponse bookResponse = BookResponse.newBuilder().setBookId(bookRequest.getBookId()).setName("JAVA GRPC MICROSERVICE").build();
        responseStreamObserver.onNext(bookResponse);
        responseStreamObserver.onCompleted();
    }
}
