package info.querypro.querypro.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 질문 테이블.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@Entity
@Table(name = "question")
@Getter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_no")
    private Long questionNo;

    @JoinColumn(name = "member_no")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "job_no")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;

    @Column(name = "question_content")
    private String content;

    @Column(name = "question_displayed")
    private boolean displayed;
}
