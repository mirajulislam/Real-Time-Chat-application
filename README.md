##  Chat Application

# Start Zookeeper
zookeeper-server-start.bat C:\kafka_2.12-2.6.0\config\zookeeper.properties
# Start Kafka
kafka-server-start.bat C:\kafka_2.12-2.6.0\config\server.properties
# Create a Topic
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
# Start Backend
mvn spring-boot:run
# Start Frontend
npm start

# react
npm install --g create-react-app
npm create-react-app chat-ui
cd chat-ui

# Install dependencies

axios
socketjs
react-stomp
material-ui
