package unid.team8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import unid.team8.service.KeywordService;

@SpringBootTest
public class KeywordTests {
  @Autowired
  KeywordService service;

  @Test
  @DisplayName("최다 카운트 키워드 2개 성공적으로 조회")
  public void getTop2KeywordsTest() {
    //given
    Long keywordId = 1L; // Make sure this is a Long, not an Integer

    //when
    var actual = service.getTop2Keywords(keywordId);
    var expect = List.of("positive_feeling", "mindful");

    //then
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expect);
  }
}
