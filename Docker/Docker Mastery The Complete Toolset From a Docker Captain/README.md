# Docker Mastery The Complete Toolset From a Docker Captain

## Docker

### Docker: Segítség

```bash
--help
```

### Docker: Bejelentkezés és kijelentkezés

```bash
$ docker login
$ docker logout
```

### Docker: Docker CONF file

```bash
$ cat .docker/config.json
```

## Docker Container

### Container: Létrehozás

> Dokumentáció: [Container Létrehozás](https://docs.docker.com/engine/reference/commandline/run/)

* local:távoli port nyítása: `-p 3306:3306`
* env variables: `-e MYSQL_RANDOM_ROOT_PASSWORD=yes`
* konténer elnevezés: `--name db`
* network-höz adás: `--net myapp_net`
* network alias: `--net-alias search`
* törlés utánna: `--rm`
* TTY kapcsolat: `-it bash`
* detach: `-d`, és a legvégére pedig az `image` neve

```bash
$ docker container run --rm -d -p 3306:3306 --name db -e MYSQL_RANDOM_ROOT_PASSWORD=yes --network myapp_net -it bash mysql
```

> A `run` **mindig új** containert csinál!

### Container: Törlés

> Dokumentáció: [Container Törlés](https://docs.docker.com/engine/reference/commandline/rm/)

`CONTAINER_ID`-ba elég ha csak az első pár számot írjuk ami unique

```bash
$ docker container rm CONTAINER_ID
```

> Futó containereket **nem lehet törölni**! Ahhoz használni kell: `-f`

### Container: Containerek megjelenítése

> Dokumentáció: [Container Lista](https://docs.docker.com/engine/reference/commandline/ps/)

A `docker ps` régi típusú parancs de még müködik!

```bash
$ docker container ls
$ docker ps
```

> A `-a` -val megjeleníthető az **összes container** (aktiv és nem aktív)

### Container: Elindítás és leállítás

> Dokumentáció: [Container Elindítása](https://docs.docker.com/engine/reference/commandline/start/) és [Container Leállítása](https://docs.docker.com/engine/reference/commandline/stop/)

```bash
$ docker container start NAME
$ dokcer container stop NAME
```

### Container: Logok megjelenítése

> Dokumentáció: [Container Logok](https://docs.docker.com/engine/reference/commandline/logs/)

```bash
$ docker container logs NAME
$ docker logs
```

A folyamatos nézéshez `-f` et kell használni

```bash
$ docker container logs -f psql
```

### Container: Process lista megjelenítése egy containerben

> Dokumentáció: [Container](https://docs.docker.com/engine/reference/commandline/container/)

```bash
$ docker container top NAME
```

### Container: METADATA JSON

```bash
$ docker container inspect NAME
```

### Container: Teljesítmény adatok megtekíntése

```bash
$ docker container stats
```

### Container: Shell megjelenítése

Új Container esetén, csak addig megy a container míg be nem írjuk az `exit`-et

```bash
$ docker container run -it mysql bash
```

Jelenleg futó container esetén az `image` alapján csinál még egy containert az adott időre csak

```bash
$ docker container exec -it mysql bash
```

> `bash`-t pl csak akkor lehet használni ha benne is van az adott containerben!

## Docker Network

> Dokumenticáió: [Docker Network](https://docs.docker.com/engine/reference/commandline/network/)

Portnyítás nélkül is tudnak kommunikálni egymással a dolgok! Csak úgyan azon a virtuális network-ön kell lenniük.

> Érdemes mindig a custom network-öt használni!

### Container: Portok megtekintése

```bash
$ docker container port NAME
```

### Network: Létrehozás

> Dokumentáció: [Network Létrehozás](https://docs.docker.com/engine/reference/commandline/network_create/)

Default driver: **bridge**

```bash
$ docker network create NAME
```

### Network: Törlés

> Dokumentáció: [Network Törlés](https://docs.docker.com/engine/reference/commandline/network_rm/)

```bash
$ docker network rm NAME
```

### Network: Hozzáadás egy containerhez

> Dokumentáció: [Network-höz csatlakoztatás](https://docs.docker.com/engine/reference/commandline/network_connect/)

```bash
$ docker network connect NETWORK CONTAINER
$ docker cotnainer run --net NETWORK
```

### Network: Eltávolítása egy containerből

> Dokumentáció: [Network-ből eltávolítás](https://docs.docker.com/engine/reference/commandline/network_disconnect/)

```bash
$ docker network disconnect NETWORK CONTAINER
```

### Network: METADATA JSON

> Dokumentáció: [Network megvízsgálása](https://docs.docker.com/engine/reference/commandline/network_inspect/)

```bash
$ docker network inspect
```

### Network: Lista megjelenítése

> Dokumentáció: [Network Lista megjelenítése](https://docs.docker.com/engine/reference/commandline/network_ls/)

```bash
$ docker network ls
```

## Docker Image

[Docker Hub](https://hub.docker.com/)

### Image: Letöltés

```bash
$ docker pull NAME:TAG
```

### Image: Image-k listázása

```bash
$ docker image ls
```

### Image: Image változások megtekíntése

```bash
$ docker history NAME:TAG
```

### Image: METADATA JSON

```bash
$ docker image inspect NAME
```

### Image: TAG készítés

> Az alap tag a `latest`

```bash
$ docker image tag IMAGE:tag TARGET-IMAGE:TAG
```

### Image: Feltöltés

> Be kell jelentkezni elötte a `docker login`-al
>> Ha privát repot kell, akkor elöbb online el kell készíteni a Hub-on

```bash
$ docker image push IMAGE:tag
```

### Image: Minden Image törlése

```bash
$ docker image prune -a
```

## Docker File

Docker fájl legelején kell lennie a legkevésbé változó dolgoknak és csak a legvégén szabad lennie a nagy fájl változásoknak. Igy a Built idő gyorsabb a cachek használata miatt.

> Miután valami vátlozott onnantól kezdve **nem használ cachet**!

### Docker File: Build

```bash
$ docker image built -t NAME .
```

### Docker File: FROM

Az alapja az egésznek. Általában linux distrot szoktak használni!

```docker
$ FROM nginx:latest
```

### Docker File: WORKDIR

Olyan mint ha be cd-znéd az útvonalat oda ahol a programnak dolgoznia kell

```docker
$ WORKDIR /usr/share/nginx/html
```

### Docker File: COPY

```docker
$ COPY index.html index.html
```

### Docker File: EXPOSE

Port nyítás

```docker
$ EXPOSE 3000
```

## Docker Volumes

### Volumes: Tárhelyek megtekíntése

```bash
$ docker volume ls
```

### Volumes: Elnevezett tárhelyek

Készítéskor `-v mysql-db:/var/lib/mysql`

```bash
$ docker container run -d --name mysql -v mysql-db:/var/lib/mysql mysql
```

### Volumes: Jelenlegi tárhelyhez mappolás

Úgyan az mintha elneveznénk csak `-v` után az útvonalat kell megadni

> Ha az adott mappába szeretnénk bindolni akkor `$(pwd):/usr/share/nginx/html` is megfelelő

```bash
$ docker container run -d --name mysql -v /Users/bret/stuff:/path/container
$ docker container run -d --name mysql -v //c/Users/bret/stuff:/path/container
```

> Nem lehet Bindolni Dockerfile-ban!

## Docker Compose

`docker-compose.yml` be mentjük a beállításokat

```YML
version: '3.1' # if no version is specified then v1 is assumed. Recommended v2

services: # containers. same as docker run
  servicename: # a friendly name. this is also DNS name inside network
    image: # Optional if you use build:
    command: # Optional, replace the default CMD specified by the image
    environment: # Optional, same as -e in docker run
    voluems: # Optional, same as -v in docker run
  servicename2:

volumes: # Optional, same as docker volume create

networks: # Optional, same as docker network create
```

### Compose: Elindítás

Beállít mindent ahogy a `docker-compose.yml-ben található

```bash
$ docker-compose up
```

### Compose: Leállítás

Kitöröl mindent ami használva volt

```bash
$ docker-compose down
```

> Ha volume-t is el kell távolítani akkor `-v` -t kell használni
