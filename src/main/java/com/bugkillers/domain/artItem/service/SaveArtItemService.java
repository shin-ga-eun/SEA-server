package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.dto.SaveArtItemDto;
import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import com.bugkillers.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class SaveArtItemService {

    final ArtItemRepository artItemRepository;
    final JwtTokenProvider jwtTokenProvider;

    public void save (String token, SaveArtItemDto saveArtItemDto){
//        Member member = jwtTokenProvider.get(token);



        ArtItem artItem = new ArtItem();
        LocalDate localDate = LocalDate.now();

//        artItem.setMember();
        artItem.setTitle(saveArtItemDto.getTitle());
        artItem.setDescription(saveArtItemDto.getDescription());
        artItem.setPrice(saveArtItemDto.getPrice());
        artItem.setCreate_at(localDate);
        artItem.setModify_at(localDate);

        artItemRepository.save(artItem);
    }
}
