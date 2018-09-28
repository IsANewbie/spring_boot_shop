package tk.lexno.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tk.lexno.shop.entity.Order;
import tk.lexno.shop.entity.OrderExample;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}