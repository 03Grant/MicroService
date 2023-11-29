### 功能实现

UserService 用户信息微服务实现了如下功能。

第一是用户个人信息管理。

![image-20231129223925330](C:\Users\grant\AppData\Roaming\Typora\typora-user-images\image-20231129223925330.png)

这个表可以管理用户的登录id以及密码。



第二个是用户收货地址管理。收货地址可能有很多，所有用一个专门的表进行管理。

![image-20231129224041725](C:\Users\grant\AppData\Roaming\Typora\typora-user-images\image-20231129224041725.png)



第三个是用户账户优惠券管理。此处可以管理优惠券的种类和数目。

![image-20231129224127025](C:\Users\grant\AppData\Roaming\Typora\typora-user-images\image-20231129224127025.png)



### 接口

1. **/login 接口：**

   接收POST请求，body以json格式，需要有**userid**与**password**项。

   返回一个Response，提示是否成功登录。

2. **/address/add接口**

​	接收POST请求，body以json格式，需要有**userid**和**address**项

​	返回一个Response，提示是否插入成功

3. **/address/user/{userId}接口**

​	接收GET请求，以userid来查询该id客户所有的address

​	返回一个ResponseEntity<List<Address>>，包含所有的地址。

4. **/usercoupon/user/{userId}接口**

​	接收GET请求，以userid来查询该id客户所有的coupon信息

​	返回coupon信息。  //***todo***    需要从coupon服务器来发送详细信息

​    5. **/usercoupon/add**

​	接收POST请求，body以json格式，需要有**userid**和**couponid**和**num**项（num代表增加的数量）

​	返回ResponseEntity.OK如果成功。

​    6. **/usercoupon/remove**

​	接收POST请求，body以json格式，需要有**userid**和**couponid**和**num**项（num代表减少的数量）

​	此接口有数量比对检验。

​	返回ResponseEntity.OK如果成功。