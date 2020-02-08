package com.uuhnaut69.mall.repository;

import com.uuhnaut69.mall.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

    boolean existsByTagName(String tagName);

    Set<Tag> findByIdIn(Set<UUID> uuids);
}
