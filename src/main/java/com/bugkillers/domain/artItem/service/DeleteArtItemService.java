package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteArtItemService {

    final ArtItemRepository artItemRepository;
    final JwtTokenProvider jwtTokenProvider;

    public void delete (String token, Long ano){
        Member member = jwtTokenProvider.getUserByToken(token);
        ArtItem artItem = artItemRepository.findByMemberAndAno(member, ano);

        artItemRepository.delete(artItem);
    }
}
