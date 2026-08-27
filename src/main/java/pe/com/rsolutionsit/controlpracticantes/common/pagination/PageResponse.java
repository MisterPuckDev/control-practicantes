package pe.com.rsolutionsit.controlpracticantes.common.pagination;

import java.util.List;

/**
 * Generic paginated response.
 *
 * @param content       page content.
 * @param page          current page.
 * @param size          page size.
 * @param totalElements total elements.
 * @param totalPages    total pages.
 * @param first         first page indicator.
 * @param last          last page indicator.
 * @author MisterPuckDev
 * @since 0.2.0
 */
public record PageResponse<T>(

    List<T> content,

    int page,

    int size,

    long totalElements,

    int totalPages,

    boolean first,

    boolean last

) {
}
