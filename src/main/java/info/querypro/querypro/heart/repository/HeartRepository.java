package info.querypro.querypro.heart.repository;

import info.querypro.querypro.heart.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 좋아요 레포지토리.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public interface HeartRepository extends JpaRepository<Heart, Heart.Pk> {
}
