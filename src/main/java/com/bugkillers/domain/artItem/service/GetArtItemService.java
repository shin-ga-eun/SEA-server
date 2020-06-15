package com.bugkillers.domain.artItem.service;

import com.bugkillers.domain.artItem.dto.GetAnoAndTitleDto;
import com.bugkillers.domain.artItem.dto.GetArtItemDto;
import com.bugkillers.domain.artItem.entity.ArtItem;
import com.bugkillers.domain.artItem.repository.ArtItemRepository;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.domain.member.repository.MemberRepository;
import com.bugkillers.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GetArtItemService {

    final ArtItemRepository artItemRepository;
    final JwtTokenProvider jwtTokenProvider;

    public GetArtItemDto getArtItemByTokenAndAno (String token, Long ano){
        Member member = jwtTokenProvider.getUserByToken(token);
        ArtItem artItem = artItemRepository.findByMemberAndAno(member, ano);

        GetArtItemDto getArtItemDto = new GetArtItemDto();

        getArtItemDto.setAno(ano);
        getArtItemDto.setArtist(artItem.getMember().getName());
        getArtItemDto.setTitle(artItem.getTitle());
        getArtItemDto.setDescription(artItem.getDescription());
        getArtItemDto.setPrice(artItem.getPrice());
        getArtItemDto.setCreate_at(artItem.getCreate_at().toString());
        getArtItemDto.setModify_at(artItem.getModify_at().toString());

        return getArtItemDto;
    }

    public List<GetAnoAndTitleDto> getListByToken (String token){
        Member member  = jwtTokenProvider.getUserByToken(token);
        List<ArtItem> listArtItem = artItemRepository.findByMember(member);
        List<GetAnoAndTitleDto> result = new ArrayList<>();

        for(int i=0; i< listArtItem.size(); i++) {
            GetAnoAndTitleDto getAnoAndTitleDto = new GetAnoAndTitleDto();
            getAnoAndTitleDto.setAno(listArtItem.get(i).getAno());
            getAnoAndTitleDto.setTitle(listArtItem.get(i).getTitle());

            result.add(getAnoAndTitleDto);
        }

        return result;
    }
}
