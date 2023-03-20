package info.querypro.querypro.jobgroup.repository;

import info.querypro.querypro.jobgroup.entity.JobGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 직군 레포지토리.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public interface JobGroupRepository extends JpaRepository<JobGroup, Integer> {
}
