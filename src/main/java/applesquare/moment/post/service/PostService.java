package applesquare.moment.post.service;

import applesquare.moment.post.dto.PostCreateRequestDTO;
import applesquare.moment.post.dto.PostUpdateRequestDTO;

public interface PostService {
    int MIN_CONTENT_LENGTH=0;
    int MAX_CONTENT_LENGTH=2048;

    Long create(PostCreateRequestDTO postCreateRequestDTO);
    Long update(Long postId, PostUpdateRequestDTO postUpdateRequestDTO);
    void delete(Long postId);
}