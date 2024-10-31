import com.clover.service.PoemService;
import com.clover.config.SpringConfig;
import com.clover.pojo.Poem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

@SpringJUnitConfig(value ={SpringConfig.class} )
public class PoemServiceTest {
    @Autowired
    private PoemService poemService;

    private Poem poem1;
    private Poem poem2;
    private  List<Poem> poems;
    @BeforeEach
    public void before(){
        poems = new ArrayList<>();
        poem1 = new Poem("Title1", "Content1", "Translation1", 1, 1);
        poem2 = new Poem("Title1", "Content1", "Translation1", 1, 1);
        poems.add(poem1);
        poems.add(poem2);
    }

    @Test
    public void testInsertByPoem(){
        poemService.insertByPoem(poem1);
    }

    @Test
    public void testDeleteByTitle(){
        poemService.deleteByTitle("t");
    }

    @Test
    public void testUpdateTitleById(){
        poemService.updateTitleById(2,"t");
    }
}
