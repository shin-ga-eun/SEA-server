package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.dto.GetArtItemDto;
import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import org.springframework.stereotype.Service;

@Service
public class GetArtItemService {

    final ArtItemRepository artItemRepository;

    public GetArtItemService(ArtItemRepository artItemRepository) {
        this.artItemRepository = artItemRepository;
    }

    public GetArtItemDto findByAno (Long ano){
        ArtItem artItem = artItemRepository.findByAno(ano);
        GetArtItemDto getArtItemDto = new GetArtItemDto();

        getArtItemDto.setArtist(artItem.getArtist());
        getArtItemDto.setTitle(artItem.getTitle());
        getArtItemDto.setDescription(artItem.getDescription());
        getArtItemDto.setPrice(artItem.getPrice());
        getArtItemDto.setCreate_at(artItem.getCreate_at());
        getArtItemDto.setModify_at(artItem.getModify_at());

        return getArtItemDto;
    }
}
