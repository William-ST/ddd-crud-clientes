docker build -t ddd-springboot-demoapp:latest .
docker tag ddd-springboot-demoapp:latest williamst/ddd-springboot-demoapp:latest
docker push williamst/ddd-springboot-demoapp:latest