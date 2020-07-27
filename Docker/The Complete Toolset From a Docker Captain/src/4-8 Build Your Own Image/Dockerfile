# you should use the node official image, with the alpine 6.x branch
FROM node:6-alpine

# this app listenes on port 3000, but the container should launch on port 80
# so it will respond to http://localhost:80 on your computer
EXPOSE 3000

# then it should use alpine package manager to install tini: 'apk add --update tini'
RUN apk add --update tini

# then it should create direactory /usr/src/app for app files with 'mkdir -p /usr/src/app'
RUN mkdir -p /usr/src/app

# Node uses a "package manager", so it need to copy in package.json file
WORKDIR /usr/src/app
COPY package.json package.json

# then it needs to run 'npm install' to install dependencies from that file
# to keep it clean and small, run 'npm chache clean' after above
RUN npm install && npm cache clean

# then it needs to copy in ALL FILES from current directory
COPY . .

# then it needs to start container with command 'tini --node ./bin/www'
CMD [ "tini", "--", "node", "./bin/www" ]

# in the end you should be using FROM, RUN, WORKDIR, COPY, EXPOSE, and CMD commands
# docker container run --rm -p 80:3000 testnode
