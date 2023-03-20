package info.querypro.querypro.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import info.querypro.querypro.base.BaseCreateTime;
import info.querypro.querypro.job.entity.Job;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 멤버 엔티티.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter
public class Member extends BaseCreateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @JoinColumn(name = "job_no")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_nickname")
    private String nickname;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_age")
    private Integer age;

    @Column(name = "member_newcomered")
    private boolean newcomered;

    @Column(name = "member_deleted")
    private boolean deleted;
}
