package tk.lexno.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.lexno.shop.common.Constants;
import tk.lexno.shop.dao.OrderItemMapper;
import tk.lexno.shop.dao.OrderMapper;
import tk.lexno.shop.dao.UserAddressMapper;
import tk.lexno.shop.entity.*;
import tk.lexno.shop.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private UserAddressMapper addressMapper;

    @Override
    public void addOrder(Order order, List<OrderItem> orderItems, UserAddress userAddress) {
        if (userAddress != null && userAddress.getId() != null) {
            addressMapper.updateByPrimaryKeySelective(userAddress);
        } else {
            addressMapper.insertSelective(userAddress);
        }
        orderMapper.insertSelective(order);
        for (OrderItem orderItem : orderItems) {
            orderItemMapper.insertSelective(orderItem);
        }
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Order> findAllOrders(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Boolean.FALSE);
        List<Order> orderList = orderMapper.selectByExample(example);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return pageInfo;
    }

    @Override
    public PageInfo<Order> findAllOrders(int pageNum, int pageSize, Long userId) {
        PageHelper.startPage(pageNum, pageSize);
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Boolean.FALSE);
        criteria.andUserIdEqualTo(userId);
        List<Order> orderList = orderMapper.selectByExample(example);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return pageInfo;
    }

    @Override
    public List<OrderItem> findAllOrderItems(Long orderId) {
        OrderItemExample example = new OrderItemExample();
        OrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
        return orderItems;
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setDeleted(Boolean.TRUE);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void updateOrderStatus(Long orderId, Integer status) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setStatus(status);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public boolean checkOwned(Long orderId, Long userId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        return order != null ? false : order.getUserId().equals(userId);
    }

    @Override
    public void payOrder(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setStatus(Constants.OrderStatus.PAYED);
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
