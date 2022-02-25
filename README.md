# Financially

## Setup
Clone this repository using Git Bash in the directory of your workspace:

```bash
git clone https://github.com/casperwilds/financially.git
```

# Spring Boot

Execute project: mvn spring-boot:run

## Swagger - API Viewing and Testing
Run project
Goto http://localhost:8080/swagger-ui.index.html

## Launch H2 Manager
Run project
Goto http://localhost:8080/h2-console/


# ReactJS

## Prerequisites

Install [Build Tools for Visual Studio 2019](https://visualstudio.microsoft.com/downloads)
Install [CMake](https://cmake.org/download/)
Install [Node.js](https://nodejs.org/en/download/) and [npm](http://npmjs.com)) (Comes with Node installation)
Install [Git](https://git-scm.com)
Install create-react-app via cmd: npx install -g create-react-app

##
Creating react app (cmds):
cd src/main
npx create-react-app financially
mv financially ui

### To Start UI
cd src/main/ui
yarn run start


# Packaging and Running Application
## Packaging application
mvn package
## Running application
java -jar target/<app-name>-VERSION.jar


# Archive Instructions
Install the app

```bash
# navigate to app directory
cd financially
# install app dependencies
npm install
# run dev to create dist/ build files
npm run dev
# launch the app
npm start
```

## Packaging app as a distributable

[@nodegui/packer](https://github.com/nodegui/packer) - App packaging

### Step 1: (_**Perform this step only ONCE**_)

Run this command to build the deploy directory.
```sh
npx nodegui-packer --init MyAppName
```

### Step 2: (_**Perform this step to build a new distributable**_)

```sh
npm run build
npx nodegui-packer --pack ./dist
```

## Documentation and Resources

- [React NodeGui](https://react.nodegui.org) - Documentation
- [NodeGui](https://nodegui.org) - Documentation
- [nodegui-packer](https://github.com/nodegui/packer) - Documentation

## License

MIT
