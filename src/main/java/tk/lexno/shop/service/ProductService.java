package tk.lexno.shop.service;

import com.github.pagehelper.PageInfo;
import tk.lexno.shop.entity.Product;
import tk.lexno.shop.entity.ProductType;

import java.util.List;

public interface ProductService {
    /**
     * 添加商品类型
     *
     * @param productType 商品类型
     */
    void saveType(ProductType productType);

    /**
     * 查询所有的商品类型
     *
     * @return 返回所有的商品类型
     */
    List<ProductType> findAllType();

    /**
     * 根据商品id，获得商品详情
     *
     * @param id 商品id
     * @return 商品详情
     */
    Product findProductById(Long id);

    /**
     * 分页查询所有商品
     *
     * @param pageNum     多少页
     * @param pageSize 当前页面数量
     * @return 商品列表
     */
    PageInfo<Product> findAllProducts(int pageNum, int pageSize);

}
