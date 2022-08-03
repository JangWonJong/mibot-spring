package kr.co.eis.api.image.controllers;

import io.swagger.annotations.*;
import kr.co.eis.api.auth.domains.Messenger;
import kr.co.eis.api.image.domains.Image;
import kr.co.eis.api.image.properties.ImageProperties;
import kr.co.eis.api.image.services.ImageService;
import kr.co.eis.api.user.domains.User;
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
    public ResponseEntity<?> uploadImages(@RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        if(file == null){
            System.out.println("files is null");
        }else System.out.println("files is not null");
        final String location = imageProperties.getLocation();
        final List<Image> imageList = new ArrayList<>();
        String imageName = file.getOriginalFilename();
        String imageUrl = location + imageName;
        String type = file.getContentType();
        //Long imageSize = file.getSize(); 이미지 사이즈

        //로컬저장
        file.transferTo(new File(imageUrl));
        //DB에 저장
        imageList.add(Image.builder()
                .name(imageName)
                .type(type)
                .build());

        service.saveImageList(imageList);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @GetMapping("/findById/{imageid}")
    public ResponseEntity<Optional<Image>> findById(@PathVariable String imageid) {
        return ResponseEntity.ok(service.findById(imageid));
    }
    @GetMapping("/getOne/{imageid}")
    public ResponseEntity<List<Image>> getOne(@PathVariable Long imageid) {
        return ResponseEntity.ok(service.getOne(imageid));
    }
}
