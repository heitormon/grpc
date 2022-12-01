package main

import (
	"flag"
	"fmt"
	"grpc-go-server/pkg/pb/message"
	"log"
	"net"

	"google.golang.org/grpc"
)

var (
	port = flag.Int("port", 50051, "The server port")
)

func main() {
	flag.Parse()
	listener, err := net.Listen("tcp", fmt.Sprintf(":%d", *port))
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	server := grpc.NewServer()
	log.Printf("Running Server on port %d", *port)
	message.RegisterMessageServiceServer(server, &message.Server{})
	if err := server.Serve(listener); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
