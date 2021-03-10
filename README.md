# hearthstonecardreader
Hearthstone assignment to read cards

# Back-end
The backend it done with spring-boot-web. authentication happens by creating and oAuth2 cleint for the blizzard api.

# Front-end
the frontend is created as a react-app with fectch calls to the backend.

# Running it locally

--------- Make sure client-id and client-secret are set  (these would ussually be set in a secreate manager) -------------------

to run the application simply start the the backend with /gradlew .bootJar

then run the front end with yarn start in the src/main/ui directory.

--AUTOMATION-- I have included a HearthStart.sh script to start both services

# Build
the project can be build with gradlew clean build in the root dir
the front-end can be built with yarn build 

# Deploy
the jar file can be found in the build dir
the contents in src/main/ui/public can be servered to a server.

----- Enhancement -----
create a better connection to the backend that isnt hard set to localhost:8080
