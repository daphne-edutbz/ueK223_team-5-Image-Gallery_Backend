set -e
cd ~/image-gallery

cat > docker-compose.prod.yml <<"EOF"
services:
  db:
    image: postgres:16
    restart: unless-stopped
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: postgres
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U postgres"]
      interval: 10s
      timeout: 5s
      retries: 5

  backend:
    build: ./ueK223_team-5-Image-Gallery_Backend
    restart: unless-stopped
    environment:
      DB_HOST: db
      DB_PORT: 5432
      DB_NAME: postgres
      DB_USER: postgres
      DB_PASSWORD: postgres
    ports:
      - "8911:8080"
    depends_on:
      db:
        condition: service_healthy

  frontend:
    build: ./ueK223_team-5-Image-Gallery_Frontend
    restart: unless-stopped
    ports:
      - "8910:80"
    depends_on:
      - backend

volumes:
  postgres_data:
EOF

if docker compose version >/dev/null 2>&1; then
  docker compose -p gino -f docker-compose.prod.yml up -d --build
  docker compose -p gino -f docker-compose.prod.yml ps
else
  docker-compose -p gino -f docker-compose.prod.yml up -d --build
  docker-compose -p gino -f docker-compose.prod.yml ps
fi
