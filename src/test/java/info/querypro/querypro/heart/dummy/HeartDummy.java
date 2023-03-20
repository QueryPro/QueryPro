package info.querypro.querypro.heart.dummy;

import info.querypro.querypro.heart.entity.Heart;
import info.querypro.querypro.member.entity.Member;
import info.querypro.querypro.question.entity.Question;

/**
 * Some description here.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public class HeartDummy {
    public static Heart dummy(Member member, Question question) {
        return new Heart(
                new Heart.Pk(question.getQuestionNo(), member.getMemberNo()),
                question,
                member
        );
    }
}
