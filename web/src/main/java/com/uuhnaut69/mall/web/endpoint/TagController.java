package com.uuhnaut69.mall.web.endpoint;

import com.uuhnaut69.mall.core.constant.UrlConstants;
import com.uuhnaut69.mall.core.payload.response.GenericResponse;
import com.uuhnaut69.mall.core.utils.PagingUtils;
import com.uuhnaut69.mall.domain.model.Tag;
import com.uuhnaut69.mall.mapper.TagMapper;
import com.uuhnaut69.mall.payload.request.TagRequest;
import com.uuhnaut69.mall.payload.response.TagResponse;
import com.uuhnaut69.mall.service.tag.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "Tag", value = "Tag Endpoint")
@RequestMapping(path = UrlConstants.BASE_VERSION_API)
public class TagController {

    private final TagMapper tagMapper;
    private final TagService tagService;

    /**
     * Get tag page
     *
     * @param sortBy
     * @param order
     * @param page
     * @param pageSize
     * @return GenericResponse
     */
    @ApiOperation(value = "Get Tags Endpoint", notes = "Public endpoint")
    @GetMapping(path = UrlConstants.PUBLIC_URL + UrlConstants.TAG_URL)
    public GenericResponse getTagPage(@RequestParam(value = "sort", defaultValue = "id") String sortBy,
                                      @RequestParam(value = "order", defaultValue = "desc") String order,
                                      @RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "pageSize", defaultValue = "30") int pageSize) {
        log.info("Get tag page");
        Pageable pageable = PagingUtils.makePageRequest(sortBy, order, page, pageSize);
        Page<Tag> tags = tagService.findAll(pageable);
        List<TagResponse> list = tagMapper.toListTagResponse(tags.getContent());
        return GenericResponse.builder().data(list).build();
    }

    /**
     * Create a new tag
     *
     * @param tagRequest
     * @return GenericResponse
     * @throws Exception
     */
    @ApiOperation(value = "Create Tag Endpoint", notes = "Admin endpoint")
    @PostMapping(path = UrlConstants.ADMIN_URL + UrlConstants.TAG_URL)
    public GenericResponse create(@RequestBody @Valid TagRequest tagRequest) throws Exception {
        log.debug("Insert new brand {} into database", tagRequest);
        Tag tag = tagService.create(tagRequest);
        return GenericResponse.builder().data(tag).build();
    }

    /**
     * Update a tag
     *
     * @param id
     * @param tagRequest
     * @return GenericResponse
     * @throws Exception
     */
    @ApiOperation(value = "Update Tag Endpoint", notes = "Admin endpoint")
    @PutMapping(path = UrlConstants.ADMIN_URL + UrlConstants.TAG_URL + "/{id}")
    public GenericResponse update(@PathVariable UUID id, @RequestBody @Valid TagRequest tagRequest) throws Exception {
        log.info("Update tag {} with {} into database", id, tagRequest);
        Tag tag = tagService.update(id, tagRequest);
        return GenericResponse.builder().data(tagMapper.toTagResponse(tag)).build();
    }

    /**
     * Delete a tag
     *
     * @param id
     * @return GenericResponse
     * @throws Exception
     */
    @ApiOperation(value = "Delete Tag Endpoint", notes = "Admin endpoint")
    @DeleteMapping(path = UrlConstants.ADMIN_URL + UrlConstants.TAG_URL + "/{id}")
    public GenericResponse delete(@PathVariable UUID id) throws Exception {
        log.debug("Delete a tag {} from database", id);
        tagService.delete(id);
        return new GenericResponse();
    }
}