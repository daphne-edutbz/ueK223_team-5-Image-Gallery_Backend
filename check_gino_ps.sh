cd ~/image-gallery
if docker compose version >/dev/null 2>&1; then
  docker compose -p gino -f docker-compose.prod.yml ps
else
  docker-compose -p gino -f docker-compose.prod.yml ps
fi
