package com.bugkillers.controller.artItem;

import com.bugkillers.domain.dto.artItem.SaveArtItemDto;
import com.bugkillers.domain.dto.member.LoginDto;
import com.bugkillers.domain.dto.member.SignUpDto;
import com.bugkillers.service.artItem.SaveArtItemService;
import com.bugkillers.service.member.LoginService;
import com.bugkillers.service.member.SignUpService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sea")
public class ArtItemController {

    private final SaveArtItemService saveArtItemService;

    public ArtItemController(SaveArtItemService saveArtItemService) {
        this.saveArtItemService = saveArtItemService;
    }

    @PostMapping("/artItem")
    public void saveArtItem (@RequestBody SaveArtItemDto saveArtItemDto) {
        saveArtItemService.saveArtItem(saveArtItemDto);
    }






}
