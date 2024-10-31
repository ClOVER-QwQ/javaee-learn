import com.clover.config.SpringConfig;
import com.clover.dao.PoemDao;
import com.clover.pojo.Poem;
import com.clover.pojo.Poet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class PoemDaoTest {

    private AnnotationConfigApplicationContext applicationContext;
    private PoemDao poemDao;
    private Logger logger;

    @BeforeEach
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        poemDao = (PoemDao) applicationContext.getBean("poemDao");
        logger = LoggerFactory.getLogger(PoemDaoTest.class);
        logger.info("ApplicationContext and poemDao initialized successfully.");
    }

    @AfterEach
    public void after() {
        if (applicationContext != null) {
            applicationContext.close();
        }
    }

    // 测试批量插入诗歌
    @Test
    public void testBatchInsert() {
        List<Poem> poems = new ArrayList<>();
        poems.add(new Poem("Title1", "Content1", "Translation1", 1, 1));
        poems.add(new Poem("Title2", "Content2", "Translation2", 2, 2));
        int result = poemDao.batchInsert(poems);
        logger.info("批量插入结果：{}", result);
    }

    // 测试插入单首诗歌
    @Test
    public void testInsert() {
        Poem poem = new Poem("Title3", "Content3", "Translation3", 3, 3);
        int result = poemDao.insertByPoem(poem);
        logger.info("插入结果：{}", result);
    }

    // 测试根据id删除诗歌记录
    @Test
    public void testDeleteById() {
        int result = poemDao.deleteById(1);
        logger.info("根据id删除结果：{}", result);
    }

    // 测试根据标题删除诗歌记录
    @Test
    public void testDeleteByTitle() {
        int result = poemDao.deleteByTitle("Title to Delete");
        logger.info("根据标题删除结果：{}", result);
    }

    // 测试更新诗歌记录
    @Test
    public void testUpdateById() {
        Poem poem = new Poem("Updated Title", "Updated Content", "Updated Translation", 4, 4);
        int result = poemDao.updateById(4, poem.getTitle(), poem.getContent(), poem.getTranslation(), poem.getAuthorId(), poem.getPoemTypeId());
        logger.info("更新结果：{}", result);
    }

    // 测试更新诗歌标题
    @Test
    public void testUpdateTitleById() {
        int result = poemDao.updateTitleById(5, "New Title");
        logger.info("更新标题结果：{}", result);
    }

    // 测试根据id查询诗歌记录
    @Test
    public void testSelectByIdWithPoet() {
        logger.info("查询结果：{}", poemDao.selectByIdWithPoet(30));
    }

    // 测试查询所有诗歌，并进行分页
    @Test
    public void testFindAll() {
        // 设置分页参数：第1页，每页5条记录
        PageHelper.startPage(1,5);
        // 执行查询
        List<Poem> poemsByPage = poemDao.findAll();
        // 使用PageInfo包装查询结果
        PageInfo<Poem> pageInfo = new PageInfo<>(poemsByPage);
        // 打印分页信息
        logger.info("总条数：{}, 总页数：{}, 当前页：{}, 每页数量：{}",
                pageInfo.getTotal(), pageInfo.getPages(),
                pageInfo.getPageNum(), pageInfo.getSize());
        // 打印诗人信息
        poemsByPage.forEach(poem -> logger.info("诗人信息：{}", poem));
    }

    // 测试根据标题查询诗歌详情，并进行分页
    @Test
    public void testSelectByTitle() {
        // 设置分页参数：第1页，每页5条记录
        PageHelper.startPage(1, 5);
        Poem result = poemDao.selectByTitle("Title to Search");
        PageInfo<Poem> pageInfo = new PageInfo<>(new ArrayList<Poem>(){{ add(result); }});
        logger.info("查询结果：{}, 分页信息：{}", result, pageInfo);
    }

    // 测试查询作者，并进行分页
    @Test
    public void testSelectPoetByPoemId() {
        // 设置分页参数：第1页，每页5条记录
        Poet result = poemDao.selectPoetByPoemId(30);
        logger.info("查询结果：{}", result);
    }

    // 测试根据内容查询诗歌，并进行分页
    @Test
    public void testSelectByMulti() {
        // 设置分页参数：第1页，每页5条记录
        PageHelper.startPage(1, 5);
        Poem poem = new Poem();
        poem.setContent("Content to Search");
        List<Poem> poems = poemDao.selectByMulti(String.valueOf(poem));
        PageInfo<Poem> pageInfo = new PageInfo<>(poems);
        logger.info("查询结果：{}, 分页信息：{}", poems, pageInfo);
    }

    // 测试根据诗歌 id 查询收藏该诗歌的用户列表，并进行分页
    @Test
    public void testSelectUserByPoemId() {
        // 设置分页参数：第1页，每页5条记录
        PageHelper.startPage(1, 5);
        List<String> result = poemDao.selectUserByPoemId(1);
        PageInfo<String> pageInfo = new PageInfo<>(result);
        logger.info("查询结果：{}, 分页信息：{}", result, pageInfo);
    }

    // 测试通过诗文ID查询有多少人收藏
    @Test
    public void testSelectCollectorCountById() {
        int result = poemDao.selectCollectorCountById(1);
        logger.info("收藏人数：{}", result);
    }
}