package tk.lexno.shop.common;

public class Constants {

    public static class OrderStatus {
        public static final Integer WAIT_PAY = 0; // 待付款
        public static final Integer PAYED = 1; // 已付款，待发货
        public static final Integer SHIPED = 2; // 已发货
        public static final Integer ENDED = 3; // 已完成
        public static final Integer DELETED = 4; // 已删除
    }
}
