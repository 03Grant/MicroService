### 功能实现

CommodityService 商品信息微服务实现了如下功能。

第一是商品列表信息查看。



第二个是商品详细信息查看。



第三个是商品信息搜索。





### 接口

1. **/commodity/list 接口**
   - 请求方式：GET
   - 返回：List<CommodityInfo>，包含所有商品信息的列表

2. **/commodity/search 接口**
   - 请求方式：GET
   - 请求参数：
      - `commodityName`（可选）：商品名称
      - `brand`（可选）：商品品牌
      - `price`（可选）：商品价格
      - `CPU`（可选）：商品CPU信息
      - `GPU`（可选）：商品GPU信息
      - `disk`（可选）：商品磁盘信息
      - `memory`（可选）：商品内存信息
   - 返回：ResponseEntity<List<CommodityInfo>>，包含根据给定条件搜索得到的商品信息列表，如果没有匹配项则返回404状态码。

这段代码定义了一个 Spring Boot 控制器类 `CommodityInfoController`，其中包含一个用于获取商品详细信息的 API 接口。以下是该接口的说明：

3. **/commodity/{commodityid} 接口**

- 请求方式：GET
- 路径参数：{commodityid} 表示商品的ID
- 返回：ResponseEntity，包含商品详细信息 `CommodityDetails`
- 功能：根据给定的商品ID获取商品详细信息。

此接口允许通过商品ID检索商品详细信息，如果找到对应商品，则返回详细信息，否则返回404状态码。