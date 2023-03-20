package info.querypro.querypro.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import info.querypro.querypro.jobgroup.entity.JobGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 직무 엔티티.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@Entity
@Table(name = "job")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job")
    private Integer jobNo;

    @JoinColumn(name = "job_group_no")
    @ManyToOne(fetch = FetchType.LAZY)
    private JobGroup jobGroup;

    @Column(name = "job_name")
    private String jobName;
}
