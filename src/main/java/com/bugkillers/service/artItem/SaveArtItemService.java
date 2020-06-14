package com.bugkillers.service.artItem;

import com.bugkillers.domain.dto.artItem.SaveArtItemDto;
import com.bugkillers.domain.entity.ArtItem;
import com.bugkillers.repository.artItem.ArtItemRepository;
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
