package tk.lexno.shop.dao;

import java.util.List;
import tk.lexno.shop.entity.Product;
import tk.lexno.shop.entity.ProductExample;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}