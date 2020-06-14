package com.bugkillers.service.artItem;

import com.bugkillers.domain.dto.artItem.GetArtItemDto;
import com.bugkillers.domain.entity.ArtItem;
import com.bugkillers.repository.artItem.ArtItemRepository;
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
