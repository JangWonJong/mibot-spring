package kr.co.eis.api.image.services;

import kr.co.eis.api.image.domains.Image;
import kr.co.eis.api.image.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName: kr.co.mibot.api.image.services
 * fileName   : ImageServiceImpl
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private final ImageRepository repository;


    @Override
    public List<Image> saveImageList(List<Image> imageList) {
        return repository.saveAll(imageList);
    }

}
