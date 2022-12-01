build-proto:
	protoc --proto_path=/Users/heitor.nozu/dev/sandbox/study/grpc/grpc-go-server/proto/message \
	--go_out=/Users/heitor.nozu/dev/sandbox/study/grpc/grpc-go-server/pkg/pb \
	--go-grpc_out=/Users/heitor.nozu/dev/sandbox/study/grpc/grpc-go-server/pkg/pb \
	--go_opt=paths=source_relative \
	--go-grpc_opt=paths=source_relative \
	/Users/heitor.nozu/dev/sandbox/study/grpc/grpc-go-server/proto/message/*.proto
build-go-server:
	cd grpc-go-server;go build