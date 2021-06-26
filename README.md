# PlayWithgRPC
There is two code base for gRPC , one is with old HTTP1.1 and another one is with HTTP2 where I am using undertwo server which is a JBoss project that is providing the HTTP2 support.
In project first and Second I have also added the protoc compiler, so I can generate the code from .proto file
command to generate the code from .proto file is "protoc --java_out=../../java training.proto"
execute that command after you reach to resources/static dir in cmd or terminal
for ref I used https://www.baeldung.com/spring-rest-api-with-protocol-buffers site
