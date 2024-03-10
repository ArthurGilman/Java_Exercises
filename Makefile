all: tomcat

tomcat:
	mvn install
	docker build --build-arg PORT=${PORT} -t vydii/myapp .
	docker run --name myapp -p 8080:${PORT} vydii/myapp

rm:
	docker rm myapp
	docker rmi vydii/myapp

rmNginx:
	docker rm testcontainer
	docker rmi test