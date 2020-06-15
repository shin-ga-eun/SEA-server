package com.bugkillers.domain.artItem.controller;

import com.bugkillers.domain.artItem.dto.GetArtItemDto;
import com.bugkillers.domain.artItem.dto.SaveArtItemDto;
import com.bugkillers.domain.artItem.dto.UpdateArtItemDto;
import com.bugkillers.domain.artItem.service.DeleteArtItemService;
import com.bugkillers.domain.artItem.service.GetArtItemService;
import com.bugkillers.domain.artItem.service.SaveArtItemService;
import com.bugkillers.domain.artItem.service.UpdateArtItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sea")
public class ArtItemController {

    private final SaveArtItemService saveArtItemService;
    private final UpdateArtItemService updateArtItemService;
    private final DeleteArtItemService deleteArtItemService;
    private final GetArtItemService getArtItemService;

    public ArtItemController(SaveArtItemService saveArtItemService, UpdateArtItemService updateArtItemService, DeleteArtItemService deleteArtItemService, GetArtItemService getArtItemService) {
        this.saveArtItemService = saveArtItemService;
        this.updateArtItemService = updateArtItemService;
        this.deleteArtItemService = deleteArtItemService;
        this.getArtItemService = getArtItemService;
    }

    @PostMapping("/artItem")
    public void save (@RequestBody SaveArtItemDto saveArtItemDto) {
        saveArtItemService.save(saveArtItemDto);
    }

    @PutMapping("/artItem/{ano}")
    public void update (@PathVariable Long ano, @RequestBody UpdateArtItemDto updateArtItemDto){
        updateArtItemService.update(ano, updateArtItemDto);
    }

    @DeleteMapping("artItem/{ano}")
    public void delete (@PathVariable Long ano){
        deleteArtItemService.delete(ano);
    }

    @GetMapping("artItem/{ano}")
    public GetArtItemDto findByAno (@PathVariable Long ano){
        return getArtItemService.findByAno(ano);
    }






}
