FROM nginx

COPY nginx.conf /etc/nginx/nginx.conf

COPY start.sh /

RUN chmod +x /start.sh

ENTRYPOINT ["./start.sh"]
