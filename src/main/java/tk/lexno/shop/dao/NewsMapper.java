package tk.lexno.shop.dao;

import java.util.List;
import tk.lexno.shop.entity.News;
import tk.lexno.shop.entity.NewsExample;

public interface NewsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
}