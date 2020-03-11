package com.kim.security.ctrl.async;

import org.springframework.stereotype.Component;

/**
 * @auther: kim
 * @create: 2019-09-24 12:10
 * @description:
 */
@Component
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        System.out.println("接到下单请求：" + placeOrder);
        Thread.sleep(1000);
        this.placeOrder = placeOrder;
        System.out.println("下单请求处理完成：" + placeOrder);
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
