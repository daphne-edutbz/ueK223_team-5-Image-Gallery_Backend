cd ~/image-gallery
nohup bash -lc "docker compose -p gino -f docker-compose.prod.yml up -d --build" > ~/image-gallery/gino-build.log 2>&1 &
