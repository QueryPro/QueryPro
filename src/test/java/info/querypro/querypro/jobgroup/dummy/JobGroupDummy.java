package info.querypro.querypro.jobgroup.dummy;

import info.querypro.querypro.jobgroup.entity.JobGroup;

/**
 * Some description here.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public class JobGroupDummy {
    public static JobGroup dummy() {
        return new JobGroup(null, "jobgroup");
    }
}
