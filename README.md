# Campus Tasks API

This is a simple Java API created for Assignment #2.
The goal is to show that the project can run perfectly inside Docker.
It has a main page, a status page, and an about page.

## How to build and run

1. Build the image: docker build -t campus-api .
2. Run the container: docker run -d -p 8080:8080 --name my-java-app campus-api

## How to test

Open your browser and check:

- http://localhost:8080/ (Main page)
- http://localhost:8080/status (JSON status)
- http://localhost:8080/about (Info page)
