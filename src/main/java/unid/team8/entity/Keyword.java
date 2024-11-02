package unid.team8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Keyword {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="user_id")
  Long id;

  @Column(name="기쁨")
  Long happy;

  @Column(name="만족")
  Long satisfied;

  @Column(name="긍정적인 느낌")
  Long positive;

  @Column(name="평화")
  Long peaceful;

  @Column(name="안정감")
  Long stable;

  @Column(name="마음의 평화")
  Long mindful;

  @Column(name="우울")
  Long depressed;

  @Column(name="상실감")
  Long lost;

  @Column(name="좌절")
  Long overwhelmed;

  @Column(name="화남")
  Long angry;

  @Column(name="짜증")
  Long annoyed;

  @Column(name="불만")
  Long dissatisfied;

  @Column(name="걱정")
  Long worried;

  @Column(name="긴장")
  Long tense;

  @Column(name="스트레스")
  Long stress;
}
