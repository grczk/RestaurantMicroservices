FROM nginx:1.23.3

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV API_URL http://localhost:8083/api

EXPOSE 80

ADD dist/restaurant-angular/   /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
