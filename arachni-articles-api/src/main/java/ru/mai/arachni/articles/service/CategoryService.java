package ru.mai.arachni.articles.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.mai.arachni.articles.dto.request.PaginationRequest;
import ru.mai.arachni.articles.dto.response.PaginationResponse;
import ru.mai.arachni.articles.core.domain.Category;
import ru.mai.arachni.articles.core.repository.CategoryRepository;
import ru.mai.arachni.articles.core.repository.pagerequest.OffsetBasedPageRequest;

import java.util.List;

@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public PaginationResponse<String> getCategoryList(
            PaginationRequest paginationRequest
    ) {
        Page<Category> categoryPage = categoryRepository.findByCategoryContainingIgnoreCase(
                paginationRequest.getSearchString(),
                new OffsetBasedPageRequest(
                        paginationRequest.getSkip(),
                        paginationRequest.getLimit(),
                        Sort.by(
                                paginationRequest.getOrder(),
                                "category"
                        )
                )
        );

        List<String> categoryResponses = categoryPage
                .getContent()
                .stream()
                .map(Category::getCategory)
                .toList();

        return new PaginationResponse<>(
                categoryResponses,
                categoryPage.getTotalElements()
        );
    }
}
