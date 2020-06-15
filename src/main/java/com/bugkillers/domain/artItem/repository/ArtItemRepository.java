package com.bugkillers.domain.artItem.repository;

import com.bugkillers.domain.artItem.entity.ArtItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtItemRepository extends JpaRepository<ArtItem, Long> {
    ArtItem findByAno (Long ano);

}
