# hearthstonecardreader
Hearthstone assessment to read cards

# Back-end
The backend is done with spring-boot-web. authentication happens by creating and oAuth2 client for the blizzard api.

# Front-end
The frontend is created as a react-app with fetch calls to the backend.

# Running it locally

--------- Make sure client-id and client-secret are set  (these would usually be set in a secret manager) -------------------

To run the application simply start the the backend with /gradlew .bootJar

then run the front end start with yarn start in the src/main/ui directory.

--AUTOMATION-- I have included a HearthStart.sh script to start both services

# Build
the project can be built with gradlew clean build in the root dir
the front-end can be built with yarn build 

# Deploy
the jar file can be found in the build dir
the contents in src/main/ui/public can be served to a server.

----- Enhancement -----
Create a better connection to the backend that isn't hard set to localhost:8080
