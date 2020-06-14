package com.bugkillers.service.artItem;

import com.bugkillers.domain.dto.artItem.UpdateArtItemDto;
import com.bugkillers.domain.entity.ArtItem;
import com.bugkillers.repository.artItem.ArtItemRepository;
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
