package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.dto.SaveArtItemDto;
import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaveArtItemService {

    final ArtItemRepository artItemRepository;

    public SaveArtItemService(ArtItemRepository artItemRepository) {
        this.artItemRepository = artItemRepository;
    }

    public void save (SaveArtItemDto saveArtItemDto){
        ArtItem artItem = new ArtItem();
        LocalDate localDate = LocalDate.now();

        artItem.setArtist(saveArtItemDto.getArtist());
        artItem.setTitle(saveArtItemDto.getTitle());
        artItem.setDescription(saveArtItemDto.getDescription());
        artItem.setPrice(saveArtItemDto.getPrice());
        artItem.setCreate_at(localDate);
        artItem.setModify_at(localDate);

        artItemRepository.save(artItem);
    }
}
