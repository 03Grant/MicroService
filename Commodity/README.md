### 功能实现

CommodityService 商品信息微服务实现了如下功能。

第一是商品列表信息查看。



第二个是商品详细信息查看。



第三个是商品信息搜索。





### Commodity接口

1. **/commodity/list 接口**
   - 请求方式：GET
   
   - 返回：List<CommodityInfo>，包含所有商品信息的简要信息（名称、最低价格）列表
   
     用途：当用户想浏览所有商品时，点进”全部“页面，即可看到所有的商品信息。
   
     
   
2. **/commodity/search 接口**
   - 请求方式：GET
   
   - 请求参数：
      - `commodityName`：商品名称
      
   - 返回：ResponseEntity<List<CommodityInfo>>，包含根据名词进行匹配搜索得到的商品信息列表，如果没有匹配项则返回404状态码，表示无相应商品。
   
      

3. **/commodity/{commodityid} 接口**

- 请求方式：GET
- 路径参数：{commodityid} 表示商品的ID
- 返回：ResponseEntity，包含商品详细信息 `CommodityDetails`
- 用途：用户点进商品详情页时，前端自动进行该请求，根据给定的商品ID获取商品详细信息（所有配置及其对应的价格）。

此接口允许通过商品ID检索商品详细信息，如果找到对应商品，则返回详细信息，否则返回404状态码。





