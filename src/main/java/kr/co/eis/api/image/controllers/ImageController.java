package kr.co.eis.api.image.controllers;

import io.swagger.annotations.*;
import kr.co.eis.api.image.domains.Image;
import kr.co.eis.api.image.properties.ImageProperties;
import kr.co.eis.api.image.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * packageName: kr.co.mibot.api.image.controllers
 * fileName   : ImageController
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
@Api(tags = "images")
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {
    private final ImageService service;
    private final ImageProperties imageProperties;


    //@RequestBody는 Postman으로 들어옴
    //@ReqeustPart는 안됨 -> why?
    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadImages(@RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException {
        final String location = imageProperties.getLocation();
        final List<Image> imageList = new ArrayList<>();
        for (MultipartFile file : files) {
            String imageName = file.getOriginalFilename();
            String imageUrl = location + imageName;
            String type = file.getContentType();
            Long imageSize = file.getSize();
            //로컬저장
            file.transferTo(new File(imageUrl));
            //DB에 저장
            imageList.add(Image.builder()
                    .name(imageName)
                    .type(type)
                    .size(imageSize)
                    .build());
        }
        service.saveImageList(imageList);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
