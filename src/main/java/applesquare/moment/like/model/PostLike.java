package applesquare.moment.like.model;

import applesquare.moment.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "PostLike")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PostLikeKey.class)
public class PostLike extends BaseEntity {
    @Id
    private Long postId;
    @Id
    private String userId;
}
