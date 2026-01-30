set -e
which git
mkdir -p ~/image-gallery
cd ~/image-gallery
rm -rf test_clone
if git ls-remote https://github.com/daphne-edutbz/ueK223_team-5-Image-Gallery_Backend.git >/dev/null 2>&1; then
  echo "backend-public"
else
  echo "backend-private"
fi
if git ls-remote https://github.com/daphne-edutbz/ueK223_team-5-Image-Gallery_Frontend.git >/dev/null 2>&1; then
  echo "frontend-public"
else
  echo "frontend-private"
fi
