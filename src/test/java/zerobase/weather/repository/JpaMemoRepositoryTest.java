package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    private JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(10, "this is jpa memo");
        //when
        jpaMemoRepository.save(memo);
        List<Memo> memos = jpaMemoRepository.findAll();
        //then
        assertTrue(memos.size() > 0);
    }

    @Test
    void findByIdTest() {
        //given
        Memo memo = new Memo(11, "jpa");
        //when
        Memo savedMemo = jpaMemoRepository.save(memo);
        Optional<Memo> result = jpaMemoRepository.findById(savedMemo.getId());
        //then
        assertEquals("jpa", result.get().getText());
    }
}