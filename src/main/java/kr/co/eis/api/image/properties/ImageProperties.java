package kr.co.eis.api.image.properties;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@Setter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.servlet.multipart")
public class ImageProperties {
    private final Boolean enabled;
    private final String location;
    private final String maxFileSize;
    private final String maxRequestSize;
    private final String fileSizeThreshold;
}
