package info.querypro.querypro.job.dummy;

import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.jobgroup.entity.JobGroup;

/**
 * Some description here.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public class JobDummy {
    public static Job dummy(JobGroup jobGroup) {
        return new Job(
                null,
                jobGroup,
                "job"
        );
    }
}
