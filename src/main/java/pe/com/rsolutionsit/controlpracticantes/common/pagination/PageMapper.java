package pe.com.rsolutionsit.controlpracticantes.common.pagination;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts Spring Page into PageResponse.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Component
public class PageMapper {

    /**
     * Maps a Spring Page into a generic PageResponse.
     */
    public <E, D> PageResponse<D> map(
        Page<E> page,
        Function<E, D> mapper) {

        return new PageResponse<>(

            page.getContent()
                .stream()
                .map(mapper)
                .toList(),

            page.getNumber(),

            page.getSize(),

            page.getTotalElements(),

            page.getTotalPages(),

            page.isFirst(),

            page.isLast()

        );
    }
}
