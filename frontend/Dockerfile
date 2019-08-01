FROM node:8.11.3-alpine


COPY . ./

WORKDIR /app


RUN apk update && \
    npm install -g npm && \
    npm install -g npm @vue/cli &&\
    npm install

CMD ['npm',"run","serve"]
