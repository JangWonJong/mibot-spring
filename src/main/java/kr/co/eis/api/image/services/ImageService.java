package kr.co.eis.api.image.services;

import kr.co.eis.api.auth.domains.Messenger;
import kr.co.eis.api.image.domains.Image;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.mibot.api.image.services
 * fileName   : ImageService
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
public interface ImageService {

    List<Image> saveImageList(List<Image> imageList);
    Optional<Image> findById(String imageid);
    List<Image> getOne(Long imageid);

}
