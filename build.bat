set "JAVA_HOME=%USERPROFILE%\.jdks\temurin-20.0.2"
cd category-dishType && call mvn clean verify && cd ..
cd element-menuItem && call mvn clean verify && cd ..
cd gateway && call mvn clean verify && cd ..
cd angular && call npm i && call npm run build && cd ..