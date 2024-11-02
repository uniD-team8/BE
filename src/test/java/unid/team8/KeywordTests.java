package unid.team8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unid.team8.service.KeywordService;

public class KeywordTests {
  KeywordService service = new KeywordService();

  @Test
  @DisplayName("")
  public void getTop2KeywordsTest() {
    //given

    //when
    var actual = service.getTop2Keywords(0L);

    //then
  }

}
