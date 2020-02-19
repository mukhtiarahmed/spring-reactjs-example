# base image
FROM node:12.2.0-alpine

# Create app directory
RUN mkdir -p /src/app
WORKDIR /src/app

# to make npm test run only once non-interactively
ENV CI=true

# Install app dependencies
COPY package.json .
RUN npm install --slient && \
    npm install -g serve --slient 

# Bundle app source
COPY src ./src
COPY public ./public

RUN touch .env
RUN echo "REACT_APP_API_URL=http://localhost:9292" >> .env 
RUN echo "REACT_APP_API_CLIENT=Y2ZmZTM5OTAtNmYwZS0xMWU4LWI3NTAtNGQ4NjE0Yzk0MGZmOnNlY3JldA==" >> .env 
# Build and optimize react app
RUN npm run build
EXPOSE 9000

# defined in package.json
ENTRYPOINT serve  -s build -l 9000