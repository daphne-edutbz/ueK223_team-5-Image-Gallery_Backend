set -e
cd ~/image-gallery
ls -la
if docker compose version >/dev/null 2>&1; then
  docker compose -f docker-compose.prod.yml ps
else
  docker-compose -f docker-compose.prod.yml ps
fi
