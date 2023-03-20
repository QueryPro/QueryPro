package info.querypro.querypro.job.repository;

import info.querypro.querypro.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 직무 레포.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public interface JobRepository extends JpaRepository<Job, Integer> {
}
