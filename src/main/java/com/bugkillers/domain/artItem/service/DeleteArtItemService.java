package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteArtItemService {

    final ArtItemRepository artItemRepository;

    public DeleteArtItemService(ArtItemRepository artItemRepository) {
        this.artItemRepository = artItemRepository;
    }

    public void delete (Long ano){
        ArtItem artItem = artItemRepository.findByAno(ano);

        artItemRepository.delete(artItem);
    }
}
