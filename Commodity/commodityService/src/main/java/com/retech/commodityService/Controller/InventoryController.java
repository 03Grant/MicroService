package com.retech.commodityService.Controller;

import com.retech.commodityService.DTO.CommodityDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commodity/inventory")
public class InventoryController {

    @PostMapping("/notify")
    public ResponseEntity<?> updateInventory(@RequestBody InventoryRequest request) {
        // 根据请求体更新商品库存信息
        // 请根据实际情况完成相应的业务逻辑

        // 假设这里调用了更新库存的服务，并返回更新结果
        boolean updateSuccess = updateInventoryService(request.getCommodityid(), request.getQuantity());

        if (updateSuccess) {
            return ResponseEntity.ok(new SuccessResponse(true));
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponse("Failed to update inventory"));
        }
    }

    // 假设这是一个用于更新库存的服务
    private boolean updateInventoryService(String commodityId, int quantity) {
        // 实际业务逻辑，更新商品库存信息
        // 返回更新结果，这里只是示例，具体根据实际需求实现
        return true;
    }

    // 请求体类，用于接收请求的JSON数据
    static class InventoryRequest {
        private String commodityid;
        private int quantity;

        // 构造函数、getter 和 setter 方法

        public InventoryRequest() {
            // 默认构造函数
        }

        public InventoryRequest(String commodityid, int quantity) {
            this.commodityid = commodityid;
            this.quantity = quantity;
        }

        public String getCommodityid() {
            return commodityid;
        }

        public void setCommodityid(String commodityid) {
            this.commodityid = commodityid;
        }

        public int getQuantity() {

            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // 响应体类，用于返回JSON数据
    static class SuccessResponse {
        private boolean success;

        // 构造函数、getter 和 setter 方法

        public SuccessResponse() {
            // 默认构造函数
        }

        public SuccessResponse(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    // 响应体类，用于返回错误信息的JSON数据
    static class ErrorResponse {
        private String errorMessage;

        // 构造函数、getter 和 setter 方法

        public ErrorResponse() {
            // 默认构造函数
        }

        public ErrorResponse(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
