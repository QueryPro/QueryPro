package info.querypro.querypro.jobgroup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 직군 엔티티.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@Entity
@Table(name = "job_group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_group_no")
    private Integer jobGroupNo;

    @Column(name = "job_group_name")
    private String jobGroupName;
}
