package tutorial

import context "context"

type Server struct {
	UnimplementedGreeterServer
}

func (s *Server) SayHello(_ context.Context, request *HelloRequest) (*HelloReply, error) {
	return &HelloReply{Message: "Hello, " + request.GetName()}, nil
}
