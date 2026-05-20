Here's a concise README.md file with just the essentials:

markdown
# Kafka Spring Boot Demo

## 🚀 Start Kafka

```bash
docker-compose up -d
🛑 Stop Kafka

bash
docker-compose down
🏃 Run Spring Boot App

bash
mvn spring-boot:run
🌐 URLs

Service	URL
REST API	http://localhost:8081
Kafka UI	http://localhost:8080
📨 Send Messages

Simple message

bash
curl -X POST http://localhost:8081/api/messages/send \
  -H "Content-Type: application/json" \
  -d '{"message":"Hello Kafka"}'
Message with key (same key = same partition)

bash
curl -X POST http://localhost:8081/api/messages/send-with-key \
  -H "Content-Type: application/json" \
  -d '{"key":"user123","message":"User login"}'
Batch messages

bash
curl -X POST http://localhost:8081/api/messages/send-batch \
  -H "Content-Type: application/json" \
  -d '["Msg 1", "Msg 2", "Msg 3"]'
👀 Watch Messages in Console

After sending, check Spring Boot console logs:

text
INFO  KafkaProducer - Sending message: Hello Kafka
INFO  KafkaConsumer - Received message: Hello Kafka
INFO  KafkaConsumer - Processing message: HELLO KAFKA
🔍 View Messages in Kafka UI

Open http://localhost:8080
Click on demo-topic
Browse messages by partition
📝 API Endpoints

Method	Endpoint	Description
POST	/api/messages/send	Send single message
POST	/api/messages/send-with-key	Send with partition key
POST	/api/messages/send-batch	Send multiple messages
GET	/api/messages/health	Health check
GET	/api/messages/topic-info	Topic details
🧹 Clean Everything

bash
# Stop Spring Boot (Ctrl+C)

# Stop and remove containers
docker-compose down -v
⚡ Quick Test

bash
# Send test message
curl -X POST http://localhost:8081/api/messages/send \
  -H "Content-Type: application/json" \
  -d '{"message":"Test"}'

# Check health
curl http://localhost:8081/api/messages/health
That's it! The app will automatically create the demo-topic with 3 partitions.