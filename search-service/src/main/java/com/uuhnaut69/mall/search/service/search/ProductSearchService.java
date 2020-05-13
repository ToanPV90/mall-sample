package com.uuhnaut69.mall.search.service.search;

import com.uuhnaut69.mall.search.document.ProductEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author uuhnaut
 * @project mall
 */
public interface ProductSearchService {

    Page<ProductEs> search(String text, Pageable pageable);

}
