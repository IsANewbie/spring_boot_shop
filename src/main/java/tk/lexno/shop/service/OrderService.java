package tk.lexno.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import tk.lexno.shop.entity.Order;
import tk.lexno.shop.entity.OrderItem;
import tk.lexno.shop.entity.UserAddress;

import java.util.List;

public interface OrderService {
    /**
     * 新建订单
     *
     * @param order       新增的订单
     * @param orderItems  订单关联的商品及数量，可能为多个
     * @param userAddress 订单关联的收件地址
     */
    void addOrder(Order order, List<OrderItem> orderItems, UserAddress userAddress);

    /**
     * 根据id查询订单
     *
     * @param id 订单id
     * @return 要查询的订单
     */
    Order findById(Long id);

    /**
     * 订单分页-根据分页信息
     *
     * @param pageNum     多少页
     * @param pageSize 单页数量
     * @return 返回订单列表
     */
    PageInfo<Order> findAllOrders(int pageNum, int pageSize);

    /**
     * 根据用户id查询所属用户的订单
     *
     * @param pageNum     多少页
     * @param pageSize 单页数量
     * @param userId   用户id
     * @return 返回订单列表
     */
    PageInfo<Order> findAllOrders(int pageNum, int pageSize, Long userId);

    /**
     *  根据订单id查询出关联的订单项
     * @param orderId 订单id
     * @return 订单项
     */
    List<OrderItem> findAllOrderItems(Long orderId);

    /**
     * 根据id删除订单及订单关联信息
     *
     * @param id 订单id
     */
    void deleteOrder(Long id);

    /**
     * 根据订单id修改订单状态
     *
     * @param orderId 订单id
     * @param status  订单要修改的状态
     */
    void updateOrderStatus(Long orderId, Integer status);

    /**
     * 验证订单是否属于用户
     *
     * @param orderId 订单id
     * @param userId  用户id
     * @return
     */
    boolean checkOwned(Long orderId, Long userId);

    /**
     * 支付订单
     *
     * @param orderId 订单id
     */
    void payOrder(Long orderId);
}
