package com.uuhnaut69.mall.service.catalog;

import com.uuhnaut69.mall.domain.model.Catalog;
import com.uuhnaut69.mall.payload.request.CatalogRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
public interface CatalogService {
    /**
     * find catalog pages
     *
     * @param pageable
     * @return Catalog page
     */
    Page<Catalog> findAll(Pageable pageable);

    /**
     * find catalog by id
     *
     * @param id
     * @return Catalog
     * @throws Exception
     */
    Catalog findById(UUID id) throws Exception;

    /**
     * Create a catalog
     *
     * @param catalogRequest
     * @return Catalog
     * @throws Exception
     */
    Catalog create(CatalogRequest catalogRequest) throws Exception;

    /**
     * Update Catalog
     *
     * @param id
     * @param catalogRequest
     * @return Catalog
     * @throws Exception
     */
    Catalog update(UUID id, CatalogRequest catalogRequest) throws Exception;

    /**
     * Delete catalog by id
     *
     * @param id
     * @throws Exception
     */
    void delete(UUID id) throws Exception;

    /**
     * Delete catalogs by list id
     *
     * @param ids
     * @throws Exception
     */
    void deleteAll(List<UUID> ids) throws Exception;
}
