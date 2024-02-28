package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JdbcMemoRepositoryTest {

    @Autowired
    private JdbcMemoRepository jdbcMemoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(1, "this is new memo~");
        //when
        jdbcMemoRepository.save(memo);
        //then
        Optional<Memo> result = jdbcMemoRepository.findById(1);
        assertEquals("this is new memo~", result.get().getText());
    }

    @Test
    void findAllMemoTest() {
        //given
        jdbcMemoRepository.save(new Memo(1, "this is new memo~"));
        //when
        List<Memo> memos = jdbcMemoRepository.findAll();
        System.out.println(memos);
        //then
        assertNotNull(memos);
    }
}