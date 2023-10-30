FROM ubuntu:16.04
VOLUME /dam
RUN apt-get update -y && \
    apt-get install -y python-pip python-dev

FROM python:3.8.12
ENV "FLASK_APP" "app.py"
ENV "FLASK_DEBUG" "1"
ENV "DB_NAME" "act01.db"
ENV "TEMPLATE_PATH" "/app/api/templates",
ENV "STATIC_PATH" "/app/api/static",

# copy the requirements file into the image
WORKDIR /app
COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt
COPY . .

ENTRYPOINT [ "python" ]

EXPOSE 5000
CMD ["app.py" ]