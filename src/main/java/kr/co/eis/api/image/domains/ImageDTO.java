package kr.co.eis.api.image.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * packageName: kr.co.mibot.api.image
 * fileName   : ImageDTO
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Component @Data
public class ImageDTO {
    @ApiModelProperty(position = 1) private long imageId;
    @ApiModelProperty(position = 2) String name;
    @ApiModelProperty(position = 3) String type;
//    @ApiModelProperty(position = 3) Long lastModified;
//    @ApiModelProperty(position = 4) Long lastModifiedDate;
//    @ApiModelProperty(position = 5) String type;
//    @ApiModelProperty(position = 6) String webkitRelativePath;
//    @ApiModelProperty(position = 7) Long size;



}
