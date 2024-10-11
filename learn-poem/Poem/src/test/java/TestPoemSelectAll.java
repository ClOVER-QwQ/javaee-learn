import com.clover.config.SpringConfig;
import com.clover.mapper.PoemMapper;
import com.clover.pojo.Poem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestPoemSelectAll {
        @Test
        public void testPoemSelectAll() {
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
            PoemMapper poemMapper = applicationContext.getBean(PoemMapper.class);

            int pageSize = 5;
            int currentOffset = 0;

            while (true) {
                List<Poem> poems = poemMapper.findAll(currentOffset, pageSize);
                if (poems.isEmpty()) {
                    break;
                }
                for (Poem poem : poems) {
                    System.out.println(poem);
                }

                System.out.println("Going to next page.");
                currentOffset += pageSize;
            }
//            List<Integer> ids = new ArrayList<>();
//            ids.add(26);
//            poemMapper.batchDeleteByIds(ids);
            List<Poem> poemsToInsert = new ArrayList<>();
            Poem poem1 = new Poem();
            poem1.setTitle("Title 1");
            poem1.setContent("Content 1");
            poem1.setTranslation("Translation 1");
            poem1.setAuthorId(10);
            poem1.setPoemTypeId(1);
            poemsToInsert.add(poem1);
//            poemMapper.insertByPoem(poem1);
            Poem poem2 = new Poem();
            poem2.setTitle("Title 2");
            poem2.setContent("Content 2");
            poem2.setTranslation("Translation 2");
            poem2.setAuthorId(10);
            poem2.setPoemTypeId(1);
            poemsToInsert.add(poem2);

            poemMapper.batchInsert(poemsToInsert);

            // 测试根据 ID 查询作者
            System.out.println(poemMapper.selectPoetById(1,0,5));

            // 测试根据 ID 查询收藏数量
            System.out.println(poemMapper.selectCollectionById(1, 0, pageSize));

            // 测试根据 ID 查询收藏用户
            System.out.println(poemMapper.selectUserById(1, 0, pageSize));
        }
}
