import com.clover.service.PoemService;
import com.clover.pojo.Poem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class PoemServiceTest2 {
    ApplicationContext applicationContext;
    private PoemService poemService;

    private Poem poem1;
    private Poem poem2;
    private List<Poem> poems;
    @BeforeEach
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
        poemService = (PoemService) applicationContext.getBean("poemService");
        poems = new ArrayList<>();
        poem1 = new Poem("Title1", "Content1", "Translation1", 1, 1);
        poem2 = new Poem("Title1", "Content1", "Translation1", 1, 1);
        poems.add(poem1);
        poems.add(poem2);
    }

    @Test
    public void test(){
        poemService.insertByPoem(poem1);
        poemService.deleteByTitle("t");
        poemService.updateTitleById(2,"t");
    }
}
