此部分目的：增加Eureka可用性，有两台服务器来作为注册中心。

需要修改一些内容：

1. 找到电脑里的这个文件**C:\Windows\System32\drivers\etc\hosts**

   但是这个文件目前是无法被修改的，需要你给自己读写权限。在设置-安全性中，找到权限最少的那个用户，然后把所有权限都给他，就可以修改了。

   修改内容为在最底下增加两行文字：

   127.0.0.1 eureka1
   127.0.0.1 eureka2

   保存即可。

2. 客户端需要一点小修改。

   以前的defaultZone: http:......  只有一个Eureka服务器，现在有两个。

   将这一行改为：

   defaultZone: http://eureka1:8761/eureka,http://eureka2:8762/eureka