package com.bugkillers.repository.artItem;

import com.bugkillers.domain.entity.ArtItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtItemRepository extends JpaRepository<ArtItem, Long> {

}
