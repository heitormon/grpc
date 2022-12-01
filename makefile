build-proto-go:
	protoc --proto_path=./proto \
	--go_out=./grpc-go-server/pkg/pb \
	--go-grpc_out=./grpc-go-server/pkg/pb \
	--go_opt=paths=source_relative \
	--go-grpc_opt=paths=source_relative \
	./proto/*.proto
build-proto-node:
	protoc --js_out=import_style=commonjs,binary:. Message.proto
build-go-server:
	cd grpc-go-server;go build