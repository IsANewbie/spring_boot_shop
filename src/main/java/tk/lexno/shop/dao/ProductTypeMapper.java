package tk.lexno.shop.dao;

import java.util.List;
import tk.lexno.shop.entity.ProductType;
import tk.lexno.shop.entity.ProductTypeExample;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}