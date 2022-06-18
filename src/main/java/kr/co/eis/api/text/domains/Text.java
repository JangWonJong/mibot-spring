package kr.co.eis.api.text.domains;

import io.swagger.annotations.ApiModelProperty;
import kr.co.eis.api.user.domains.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * packageName: kr.co.mibot.api.text
 * fileName   : Text
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "texts")
public class Text {
    @Id
    @Column(name = "text_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private long textId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
}
