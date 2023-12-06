InventoryService 库存微服务实现的功能主要是对库存的增删改查。

分别有如下接口：

1. **/add**: 增加一条库存记录

   POST请求，body以json格式，需要有**commodityid**, **configurationid**, **warehouse**, **num**字段

   添加结果会以Response结果返回给前端。

​    2.  **/update**： 更新一条库存记录

​	PUT请求，body以json格式，需要有**commodityid**, **configurationid**, **warehouse**, **num**字段

​	更新结果会以Response结果返回给前端。

3. **/query**： 请求所需要的库存记录

​	GET请求，参数有三个，分别是**commodityid, configurationid, warehouse**。*请求时只需要保证其中一个参数不为空即可。*

​	查询结果会以列表返回。

4. **/decrease**： 检验并减少库存

​	POST请求，body以json格式，需要有**commodityid**, **configurationid**, **warehouse**, **num**字段

​	结果会以Response结果返回给前端。