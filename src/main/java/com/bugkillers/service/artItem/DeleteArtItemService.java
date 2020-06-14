package com.bugkillers.service.artItem;

import com.bugkillers.domain.entity.ArtItem;
import com.bugkillers.repository.artItem.ArtItemRepository;
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
