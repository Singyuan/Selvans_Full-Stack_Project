# Selvans_Full-Stack_Project
## Database
[MySQL](https://drive.google.com/drive/folders/14V7Ttgtn_Nv2sFsqTXTV3tL6EYeU1MB_?usp=sharing)

## Quick Start
[Note](https://hackmd.io/@singyuan/rJRMC9iFp/edit)

## Docker
### 1. Build Spring-Boot Application
- Check `mvn`
```sh
# setup mvn runtime path
export PATH="/Applications/IntelliJ IDEA.app/Contents/plugins/maven/lib/maven3/bin":$PATH

# check mvn executable
mvn --version
```
- Compile
```sh
# change directory into root directory of source code
cd demoTest

# build spring boot application
mvn clean package
```
- Test java app
```sh
cd target

# run the app
java -jar SelvansBackendApp.jar
```

### 2. docker-compose
Using docker-compose to start the app and db services
```sh
cd demoTest

# docker-compose
docker-compose up
```
Now we can test the web on local.