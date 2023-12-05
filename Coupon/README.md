CouponService

CouponService只有一张表，代表优惠券模块

![image-20231204191809774](C:\Users\grant\AppData\Roaming\Typora\typora-user-images\image-20231204191809774.png)

#### **优惠券的属性有**

1. 优惠券ID
2. 优惠券发行数目
3. 优惠券展示名
4. 适用的商品
5. 判断是 满减券 还是 折扣券
6. 折扣券：折扣值
7. 使用门槛
8. 满减券：优惠值
9. 是否可以叠加使用
10. 开始时间
11. 结束时间



#### **优惠券微服务提供的接口如下：**

1. ##### **/allocate**

   用户申领优惠券

   该接口接受POST请求，body以json格式，需要包含userid, couponid, num=1 

   表示userid顾客想要申领一张couponid的优惠券，默认一次都为一张。

   该接口会调用UserService的**/usercoupon/add**接口，来将申领之后的优惠卷记录在用户的表中。

2. **/add**

3. **/update**

   2接受POST请求，增加一条新的优惠券；3接受PUT请求，更新已有的优惠券记录，如果没有该记录，则会新建。

   body都以json格式，需要包含上述**相应的11个属性**，具体格式需要查看数据库设计表。

   该接口会返回一个boolean来表示是否成功操作。

4. **/delete/{couponid}**

   接受DELETE请求，参数为想要删除的couponid。

   该接口会返回一个boolean来表示是否成功删除

5. **/active**
6. **/expired**
7. **/notyetactive**

​	这三个接口接收GET请求，无需参数。返回**5.目前可使用的 6.过期的 7.尚未生效的** 优惠券List<coupon>列表

8. **/{couponid}**

​	接收GET请求，参数为想要查询的优惠券ID。

​	返回Coupon的信息。











