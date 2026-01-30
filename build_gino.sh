set -e
cd ~/image-gallery
if docker compose version >/dev/null 2>&1; then
  docker compose -p gino -f docker-compose.prod.yml build
else
  docker-compose -p gino -f docker-compose.prod.yml build
fi
