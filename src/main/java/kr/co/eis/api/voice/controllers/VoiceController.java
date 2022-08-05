package kr.co.eis.api.voice.controllers;

import io.swagger.annotations.Api;
import kr.co.eis.api.image.domains.Image;
import kr.co.eis.api.image.properties.ImageProperties;
import kr.co.eis.api.voice.domains.Voice;
import kr.co.eis.api.voice.services.VoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.mibot.api.voice.controllers
 * fileName   : VoiceController
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "voices")
@RequiredArgsConstructor
@RequestMapping("/voices")
public class VoiceController {
    private final VoiceService service;
    private final ImageProperties imageProperties;

    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadVoices(@RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        if(file == null){
            System.out.println("files is null");
        }else System.out.println("files is not null");
        final String location = imageProperties.getLocation();
        final List<Voice> voiceList = new ArrayList<>();
        String voiceName = file.getOriginalFilename();
        String voiceUrl = location + voiceName;
        String type = file.getContentType();
        //Long imageSize = file.getSize(); 이미지 사이즈

        //로컬저장
        file.transferTo(new File(voiceUrl));
        //DB에 저장
        voiceList.add(Voice.builder()
                .name(voiceName)
                .type(type)
                .build());

        service.saveVoiceList(voiceList);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
