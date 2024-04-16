cd docker
docker compose stop
docker compose rm -f
docker volume rm docker_datadb docker_configdb docker_wiremockvl
docker compose ps -a
docker volume ls
