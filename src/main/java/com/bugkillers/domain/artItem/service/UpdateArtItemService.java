package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.dto.UpdateArtItemDto;
import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class UpdateArtItemService {

    final ArtItemRepository artItemRepository;
    final JwtTokenProvider jwtTokenProvider;

    public void update (String token, Long ano, UpdateArtItemDto updateArtItemDto){
        Member member = jwtTokenProvider.getUserByToken(token);
        ArtItem artItem = artItemRepository.findByMemberAndAno(member, ano);

        artItem.setTitle(updateArtItemDto.getTitle());
        artItem.setDescription(updateArtItemDto.getDescription());
        artItem.setPrice(updateArtItemDto.getPrice());
        artItem.setModify_at(LocalDate.now());

        artItemRepository.save(artItem);
    }


}
