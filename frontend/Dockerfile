FROM node:22 AS build

WORKDIR /app

# Copy package.json and yarn.lock
COPY package.json yarn.lock ./

# Install yarn and dependencies
RUN yarn install --frozen-lockfile

# Copy the rest of the application source code
COPY . .

# Build the production-ready app
RUN yarn build

FROM nginx:alpine AS serve

RUN addgroup -g 1001 -S appgroup && adduser -u 1001 -S appuser -G appgroup

COPY --from=build /app/dist /usr/share/nginx/html

USER appuser:appgroup

COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 9000

CMD ["nginx", "-g", "daemon off;"]
