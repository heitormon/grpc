const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require('path')
const protoObject = protoLoader.loadSync(path.resolve(__dirname+'/protos/Message.proto'));
const package = grpc.loadPackageDefinition(protoObject);
const client = new package.com.heitor.grpc.MessageService('localhost:8080', grpc.credentials.createInsecure())
setInterval(() => {
  client.sendMessage({ "text": "HI FROM NODE" }, (err, message) => {
      if(err) throw err
      console.log(message)
  })
}, 5000)