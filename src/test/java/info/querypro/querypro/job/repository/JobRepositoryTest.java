package info.querypro.querypro.job.repository;

import static org.assertj.core.api.Assertions.assertThat;

import info.querypro.querypro.job.dummy.JobDummy;
import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.jobgroup.dummy.JobGroupDummy;
import info.querypro.querypro.jobgroup.entity.JobGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

/**
 * 직무 레포 테스트.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class JobRepositoryTest {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    TestEntityManager entityManager;

    JobGroup jobGroup;
    Job job;

    @BeforeEach
    void setUp() {
        jobGroup = JobGroupDummy.dummy();
        job = JobDummy.dummy(jobGroup);

        entityManager.persist(jobGroup);
    }

    @Test
    void save() {
        Job save = jobRepository.save(job);

        assertThat(save.getJobNo()).isEqualTo(job.getJobNo());
        assertThat(save.getJobGroup()).isEqualTo(job.getJobGroup());
        assertThat(save.getJobName()).isEqualTo(job.getJobName());
    }
}