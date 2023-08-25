package com.example.demo.domain.category;

import com.example.demo.domain.category.dto.req.CreateLikeCategoryReqDto;
import com.example.demo.domain.category.dto.res.LikeCategoryResDto;
import com.example.demo.domain.category.entity.Category;
import com.example.demo.domain.category.entity.LikeCategory;
import com.example.demo.domain.category.repository.CategoryRepository;
import com.example.demo.domain.category.repository.LikeCategoryRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final LikeCategoryRepository likeCategoryRepository;

    @Transactional
    public List<LikeCategoryResDto> createUserLike(Long userId, CreateLikeCategoryReqDto createLikeCategoryReqDto) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        List<LikeCategoryResDto> resDtoList = new ArrayList<>();

        createLikeCategoryReqDto.getCategory().forEach(type->{
            Category getCategory = categoryRepository.findByType(type);
            if(getCategory == null){
                Category category = Category.of(type);
                getCategory = categoryRepository.save(category);
            }
            LikeCategory likeCategory = LikeCategory.of(user, getCategory);
            LikeCategory saveLikeCategory = likeCategoryRepository.save(likeCategory);

            resDtoList.add(LikeCategoryResDto.builder()
                            .categoryId(getCategory.getCategoryId())
                            .type(getCategory.getType())
                            .likeCategoryId(saveLikeCategory.getLikeCategoryId())
                    .build());
        });

        return resDtoList;
    }

}
