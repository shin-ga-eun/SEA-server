package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.dto.UpdateArtItemDto;
import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UpdateArtItemService {

    final ArtItemRepository artItemRepository;

    public UpdateArtItemService(ArtItemRepository artItemRepository) {
        this.artItemRepository = artItemRepository;
    }

    public void update (Long ano, UpdateArtItemDto updateArtItemDto){
        ArtItem artItem = artItemRepository.findByAno(ano);

        artItem.setTitle(updateArtItemDto.getTitle());
        artItem.setDescription(updateArtItemDto.getDescription());
        artItem.setPrice(updateArtItemDto.getPrice());
        artItem.setModify_at(LocalDate.now());

        artItemRepository.save(artItem);
    }


}
