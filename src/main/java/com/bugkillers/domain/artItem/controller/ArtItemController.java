package com.bugkillers.domain.artItem.controller;

import com.bugkillers.domain.artItem.dto.GetAnoAndTitleDto;
import com.bugkillers.domain.artItem.dto.GetArtItemDto;
import com.bugkillers.domain.artItem.dto.SaveArtItemDto;
import com.bugkillers.domain.artItem.dto.UpdateArtItemDto;
import com.bugkillers.domain.artItem.service.DeleteArtItemService;
import com.bugkillers.domain.artItem.service.GetArtItemService;
import com.bugkillers.domain.artItem.service.SaveArtItemService;
import com.bugkillers.domain.artItem.service.UpdateArtItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void save (@RequestHeader("token") String token, @RequestBody SaveArtItemDto saveArtItemDto) {
        saveArtItemService.save(token, saveArtItemDto);
    }

    @PutMapping("/artItem/{ano}")
    public void update (@RequestHeader("token") String token, @PathVariable Long ano, @RequestBody UpdateArtItemDto updateArtItemDto){
        updateArtItemService.update(token, ano, updateArtItemDto);
    }

    @DeleteMapping("/artItem/{ano}")
    public void delete (@RequestHeader("token") String token, @PathVariable Long ano){
        deleteArtItemService.delete(token, ano);
    }

    @GetMapping("/artItem/{ano}")
    public GetArtItemDto getArtItemByTokenAndAno (@RequestHeader("token") String token, @PathVariable Long ano){
        return getArtItemService.getArtItemByTokenAndAno(token, ano);
    }

    @GetMapping("/artItem")
    public List<GetAnoAndTitleDto> getListByToken (@RequestHeader("token") String token){
        return getArtItemService.getListByToken(token);
    }








}
