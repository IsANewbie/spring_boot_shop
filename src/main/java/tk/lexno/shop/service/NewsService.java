package tk.lexno.shop.service;

import com.github.pagehelper.PageInfo;
import tk.lexno.shop.entity.News;

public interface NewsService {
    /**
     * 添加新闻
     *
     * @param news 新增的新闻
     */
    void addNews(News news);

    /**
     * 删除新闻
     *
     * @param id 要删除的新闻id
     */
    void deleteNews(Long id);

    /**
     * 查询新闻-分页
     *
     * @param pageNum  多少页
     * @param pageSize 单页数量
     * @return 返回新闻列表
     */
    PageInfo<News> findNews(int pageNum, int pageSize);

    /**
     * 根据id查询新闻
     *
     * @param id 新闻id
     * @return 返回要查的新闻
     */
    News findById(Long id);
}
