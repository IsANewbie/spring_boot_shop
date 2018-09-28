package tk.lexno.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.lexno.shop.dao.ProductMapper;
import tk.lexno.shop.dao.ProductTypeMapper;
import tk.lexno.shop.entity.Product;
import tk.lexno.shop.entity.ProductExample;
import tk.lexno.shop.entity.ProductType;
import tk.lexno.shop.entity.ProductTypeExample;
import tk.lexno.shop.service.ProductService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductTypeMapper typeMapper;

    @Override
    public void saveType(ProductType productType) {
        typeMapper.insertSelective(productType);
    }

    @Override
    public List<ProductType> findAllType() {
        ProductTypeExample example = new ProductTypeExample();
        ProductTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Boolean.FALSE);
        List<ProductType> types = typeMapper.selectByExample(example);
        return types;
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Product> findAllProducts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Boolean.FALSE);
        List<Product> productList = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return pageInfo;
    }
}
