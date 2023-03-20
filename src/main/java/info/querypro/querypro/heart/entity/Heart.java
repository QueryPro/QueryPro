package info.querypro.querypro.heart.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import info.querypro.querypro.member.entity.Member;
import info.querypro.querypro.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 좋아요 엔티티.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@Entity
@Table(name = "heart")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Heart {
    @EmbeddedId
    private Pk pk;

    @MapsId("questionNo")
    @JoinColumn(name = "question_no")
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @MapsId("memberNo")
    @JoinColumn(name = "member_no")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "question_no")
        private Long questionNo;

        @Column(name = "member_no")
        private Long memberNo;
    }
}
