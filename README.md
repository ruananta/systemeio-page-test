Step 1: Pull the Docker Image
To get a list of all the existing images on the system, run the following command in the command prompt:

`docker images`

If you do not already have the Selenium standalone-chrome Docker image, run the following command to download a copy of the image onto the system:

`docker pull selenium/standalone-chrome`

After rerunning the command docker images, the selenium/standalone-chrome image should appear in the list.

Step 2: Running the Selenium Webdriver Docker Container
Once you have pulled the selenium/standalone-chrome image onto the system, start the container by running the following command:

`docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome`

Step 3: Clone the Project and Build the Docker Container
Clone the project to your local system and run the following command to build and run the Docker container:

`docker-compose up --build`