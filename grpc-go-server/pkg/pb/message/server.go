package message

import (
	context "context"
	"fmt"
)

type Server struct {
	UnimplementedMessageServiceServer
}

func (s *Server) SendMessage(ctx context.Context, request *MessageRequest) (*MessageResponse, error) {
	fmt.Println(request)
	return &MessageResponse{Text: "Hello, " + request.GetText()}, nil
}
