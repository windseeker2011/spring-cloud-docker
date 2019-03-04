# spring-cloud-docker
how to use docker in spring cloud!

# 第一步：spring cloud环境搭建

> 1.注册中心spring-cloud-eureka。

> 2.配置中心spring-cloud-config。

> 3.网关中心spring-cloud-zuul。

> 4.基础服务a、b，a服务通过feign调用b服务。

> 5.测试系统，不考虑一些超时配置，实现演示目的即可。

# 第二步：本机环境启动测试
## 1.启动spring-cloud-eureka。

## 2.启动spring-cloud-config。

## 3.启动spring-cloud-service-a、spring-cloud-service-b。

## 4.启动spring-cloud-zuul。

### 测试步骤：

> 1.http://localhost:8761/

> 2.http://localhost:8888/application/default

> 3.http://localhost:9999/service-a/hello、http://localhost:9999/service-b/hello

# 第三步：基于docker环境的集群启动测试

## 1.本地集群环境准备
### docker-machine -v

> 查看docker machine版本。`docker-machine.exe version 0.14.0, build 89b8332`

### docker-machine create -d virtualbox `test`

> 新建docker虚拟机test，用于集群测试。`docker-machine create -d virtualbox --help查看更多支持。`

### docker-machine ls

> 查看docker machine列表。

### docker-machine env `test`

> 可以通过 env 命令来让后续操作对象都是目标主机。

### docker-machine ssh `test`

> 通过 SSH 登录到主机test。

### 常见的一些指令：
+ `active` 查看活跃的 Docker 主机
+ `config` 输出连接的配置信息
+ `create` 创建一个 Docker 主机
+ `env` 显示连接到某个主机需要的环境变量
+ `inspect` 输出主机更多信息
+ `ip` 获取主机地址
+ `kill` 停止某个主机
+ `ls` 列出所有管理的主机
+ `provision` 重新设置一个已存在的主机
+ `regenerate-certs` 为某个主机重新生成 TLS 认证信
+ `restart` 重启主机rm 删除某台主机
+ `ssh` SSH 到主机上执行命令
+ `scp` 在主机之间复制文件
+ `mount` 挂载主机目录到本地
+ `start` 启动一个主机
+ `status` 查看主机状态
+ `stop` 停止一个主机
+ `upgrade` 更新主机 Docker 版本为最新
+ `url` 获取主机的 URL
+ `version` 输出 docker-machine 版本信息
+ `help` 输出帮助

## 2.本机网络环境准备
### docker network create --driver `overlay` --subnet=`192.168.10.0/24` `springcloud-overlay`

> 创建指定子网IP的overlay网络`springcloud-overlay`。

### docker network常见的一些指令：
+ `connect` 将某一个容器连接到网络中
+ `create` 创建一个网络
+ `disconnect` 将某一个容器从网络中断开
+ `inspect` 查看一个或多个网络的详细信息
+ `ls` 列出网络情况
+ `prune` 删除未使用的网络
+ `rm` 删除一个或多个网络

## 3.搭建docker swarm mode集群环境
### 3.1 将各docker机器加入到集群中

#### 3.1.1 初始化swarm集群

> docker swarm init --listen-addr `192.168.99.100:2377` --advertise-addr `192.168.99.100`

#### 3.1.2 获取manager或worker所需token

> docker swarm join-token manager

> docker swarm join-token worker

#### 3.1.3 已加入swarm的，可以离开重新加入

> docker swarm leave `--force`

> docker swarm join --token `SWMTKN-1-2c5hyu5cwwmnkun2g7m5td91rsx6qva94nbnriaiu6ghfb0z2p-9ainlftqscg4drxjcc15a5vqp` `192.168.99.101:2377`

#### 3.1.4 查看swarm集群node情况

> docker node ls

> docker node inspect `node-id`

### docker swarm常见的一些指令：
+ `ca` Display and rotate the root CA
+ `init` 初始化swarm集群环境
+ `join` 以manager或worker角色加入swarm集群中
+ `join-token` 管理加入swarm集群的token
+ `leave` 离开swarm集群
+ `unlock` 解锁swarm集群
+ `unlock-key` 管理解锁swarm集群的key
+ `update` 更新swarm

### 3.2 类似docker compose编排文件编写

#### 3.2.1 由于docker compose不保证编排启动的先后性，服务编排拆分成3步。

> 1.编排eureka注册中心。

> 2.编排config配置中心。

> 3.编排其它基础业务。

### 3.3 集群启动

#### 3.3.1 切换到compose文件目录

> `cd compose`

#### 3.3.2 高可用spring cloud eureka集群部署

> docker stack deploy -c `docker-eureka.yml` `cloud`

#### 3.3.3 spring cloud config部署

> docker stack deploy -c `docker-config.yml` `cloud`

#### 3.3.4 其它基础业务部署

> docker stack deploy -c `docker-compose.yml` `cloud`

### 3.4 启动情况查看：

#### 服务列表

> docker service ls

#### 服务详细分布情况

> docker service ps `cloud_config`

#### 服务扩容或减容

> docker service scale `cloud_config`=3

### 3.5 测试结果：

> http://192.168.99.100:9999/service-a/hello、http://192.168.99.100:9999/service-b/hello

> http://192.168.99.101:9999/service-a/hello、http://192.168.99.101:9999/service-b/hello

# Docker监控工具：Portainer

```html
docker service create \
--name portainer \
--publish 9000:9000 \
--constraint 'node.role == manager' \
--mount type=bind,src=//var/run/docker.sock,dst=/var/run/docker.sock \
portainer/portainer:latest \
-H unix:///var/run/docker.sock
```
