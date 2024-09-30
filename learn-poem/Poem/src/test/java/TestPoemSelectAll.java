import com.clover.config.SpringConfig;
import com.clover.mapper.PoemMapper;
import com.clover.pojo.Poem;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestPoemSelectAll {
    @Test
    public void TestPoemSelectAll(){
        List<Poem> poems;
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        PoemMapper poemMapper = (PoemMapper) applicationContext.getBean("poemMapper");
        poemMapper.insert("成尊", "落魄谷中寒风吹","中文",3,3);
        poems = poemMapper.findAll();
        for (Poem poem : poems){
            System.out.println(poem);
        }
        poemMapper.deleteByTitle("成尊");
        poems = poemMapper.findAll();
        for (Poem poem : poems){
            System.out.println(poem);
        }
    }
}
