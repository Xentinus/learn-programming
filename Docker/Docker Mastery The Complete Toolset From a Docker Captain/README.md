# Docker Mastery The Complete Toolset From a Docker Captain

## Docker Container

### Container: Létrehozás

> Dokumentáció: [Container Létrehozás](https://docs.docker.com/engine/reference/commandline/run/))

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

### Container: Adatok megtekintése

> Dokumentáció: [Container](https://docs.docker.com/engine/reference/commandline/container/)

Process lista megjelenítése egy containerben

```bash
$ docker container top NAME
```

Container configjának megjelenítése `JSON`-ben

```bash
$ docker container inspect NAME
```

Teljesítmény adatok minden containerhez

```bash
$ docker container stats
```

### Container: Shell megjelenítése

Új Container esetén, csak addig megy a container míg be nem írjuk az `exit`-et

```bash
$ docker cotnainer run -it mysql bash
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

### Network: Vízsgálás

> Dokumentáció: [Network megvízsgálása](https://docs.docker.com/engine/reference/commandline/network_inspect/)

```bash
$ docker network inspect
```

### Network: Lista megjelenítése

> Dokumentáció: [Network Lista megjelenítése](https://docs.docker.com/engine/reference/commandline/network_ls/)

```bash
$ docker network ls
```
