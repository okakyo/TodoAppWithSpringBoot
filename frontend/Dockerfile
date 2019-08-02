FROM node:8.11.3-alpine




WORKDIR /app

COPY . ./

RUN apk update && \
    npm install -g npm && \
    npm install -g npm @vue/cli &&\
    npm install



CMD ["/bin/sh/","-c","npm","run","serve"]
