package info.querypro.querypro.question.dummy;

import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.member.entity.Member;
import info.querypro.querypro.question.entity.Question;

/**
 * Some description here.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public class QuestionDummy {
    public static Question dummy(Member member, Job job) {
        return new Question(
                null,
                member,
                job,
                "content",
                true
        );
    }
}
