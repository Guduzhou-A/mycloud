# My-Cloud  

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

alibaba-cloud 脚手架
*  参考文档  [![Alibaba-ReadMe](https://img.shields.io/badge/alibaba--cloud-README-brightgreen)](https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md)

*  [WIKI](#) (待施工。。。)

## 主要功能

 (待施工。。。)

## 组件

* 服务注册中心，配置中心：Nacos
* RPC 框架 ：Dubbo


## 如何构建

 (待施工。。。)

## 如何使用

(待施工。。。)

## 项目结构

```
├─mycloud-master----------------------------父项目，公共依赖
│  │
│  ├─mycloud-auth--------------------------服务认证中心
│  │
│  ├─mycloud-gateway-------------------------网关中心
│  │
│  ├─mycloud-service-api
│  │  │
│  │  ├─mycloud-service-api-s1------------------对外API服务 s1  port:8090
│  │  │
│  │  ├─mycloud-service-api-s2------------------对外API服务 s2  port:8091
│  │
│  ├─mycloud-service-provider-api
│  │  │
│  │  ├─mycloud-service-provider-api-s1------------------s1服务公共接口
│  │  │
│  │  ├─mycloud-service-provider-api-s2------------------s2服务公共接口
│  │
│  ├─mycloud-service-provider
│  │  │
│  │  ├─mycloud-service-provider-s1------------------s1 服务提供者 port:9090
│  │  │
│  │  ├─mycloud-service-provider-s2------------------s2 服务提供者 port:9091
│  │
│  ├─mycloud-common
│  │  │
│  │  ├─mycloud-common-base------------------基础包
│  │  │
│  │  ├─mycloud-common-config------------------配置包
│  │  │
│  │  ├─mycloud-common-core------------------核心包
│  │  │
│  │  ├─mycloud-common-security------------------安全包
│  │  │
│  │  ├─mycloud-common-nacos------------------nacos服务发现与配置包



```



### 邮件列表

guduzhou@outlook.com，欢迎通过此邮件列表讨论。

### 传送门
