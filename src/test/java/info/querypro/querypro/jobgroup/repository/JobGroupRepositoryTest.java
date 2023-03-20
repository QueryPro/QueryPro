package info.querypro.querypro.jobgroup.repository;

import static org.assertj.core.api.Assertions.assertThat;

import info.querypro.querypro.jobgroup.dummy.JobGroupDummy;
import info.querypro.querypro.jobgroup.entity.JobGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

/**
 * 직군 레포 테스트.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class JobGroupRepositoryTest {
    @Autowired
    JobGroupRepository jobGroupRepository;

    @Autowired
    TestEntityManager entityManager;

    JobGroup jobGroup;

    @BeforeEach
    void setUp() {
        jobGroup = JobGroupDummy.dummy();
    }

    @Test
    void save() {
        JobGroup persist = jobGroupRepository.save(jobGroup);

        assertThat(persist.getJobGroupNo()).isEqualTo(jobGroup.getJobGroupNo());
        assertThat(persist.getJobGroupName()).isEqualTo(jobGroup.getJobGroupName());
    }

}