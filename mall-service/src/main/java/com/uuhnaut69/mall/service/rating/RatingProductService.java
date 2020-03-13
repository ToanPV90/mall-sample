package com.uuhnaut69.mall.service.rating;

import com.uuhnaut69.mall.payload.response.ProductResponse;

import java.util.List;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
public interface RatingProductService {

    /**
     * Rating a product
     *
     * @param productId
     * @param userId
     * @param rating
     * @return int
     * @throws Exception
     */
    Integer ratingProduct(UUID productId, UUID userId, int rating) throws Exception;

    /**
     * Get rating aggregation of product
     *
     * @param productResponse
     * @return ProductResponse
     */
    ProductResponse getRatingAggregationOfProduct(ProductResponse productResponse);

    /**
     * Get rating aggregation of products
     *
     * @param productResponses
     * @return List {@link ProductResponse}
     */
    List<ProductResponse> getRatingAggregationOfProducts(List<ProductResponse> productResponses);

}
