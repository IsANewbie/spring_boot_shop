package tk.lexno.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.lexno.shop.dao.NewsMapper;
import tk.lexno.shop.entity.News;
import tk.lexno.shop.entity.NewsExample;
import tk.lexno.shop.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public void addNews(News news) {
        newsMapper.insertSelective(news);
    }

    @Override
    public void deleteNews(Long id) {
        News news = new News();
        news.setId(id);
        news.setDeleted(Boolean.TRUE);
        newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public PageInfo<News> findNews(int pageSize, int page) {
        PageHelper.startPage(page, pageSize);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Boolean.FALSE);
        List<News> list = newsMapper.selectByExample(example);
        PageInfo<News> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public News findById(Long id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
