package com.uuhnaut69.mall.web.endpoint;

import com.uuhnaut69.mall.core.constant.UrlConstants;
import com.uuhnaut69.mall.core.payload.response.GenericResponse;
import com.uuhnaut69.mall.core.utils.PagingUtils;
import com.uuhnaut69.mall.domain.model.Coupon;
import com.uuhnaut69.mall.mapper.CouponMapper;
import com.uuhnaut69.mall.payload.request.CouponRequest;
import com.uuhnaut69.mall.payload.request.IdsRequest;
import com.uuhnaut69.mall.payload.response.CouponResponse;
import com.uuhnaut69.mall.service.coupon.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
@RestController
@RequiredArgsConstructor
@RequestMapping(path = UrlConstants.BASE_VERSION_API)
@Api(tags = "Coupon", value = "Coupon Endpoint")
public class CouponController {

    private final CouponService couponService;
    private final CouponMapper couponMapper;

    /**
     * Get coupon page
     *
     * @param sortBy   Sorted field
     * @param order    Ordered field
     * @param page     Page number
     * @param pageSize Page size
     * @return GenericResponse
     */
    @ApiOperation(value = "Get Catalogs Endpoint", notes = "Admin endpoint")
    @GetMapping(path = UrlConstants.COUPON_URL)
    public GenericResponse getCouponPage(@RequestParam(value = "sort", defaultValue = "id") String sortBy,
                                         @RequestParam(value = "order", defaultValue = "desc") String order,
                                         @RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PagingUtils.makePageRequest(sortBy, order, page, pageSize);
        Page<Coupon> coupons = couponService.findAll(pageable);
        List<CouponResponse> list = couponMapper.toListCouponResponse(coupons.getContent());
        return GenericResponse.builder().data(list).build();
    }

    /**
     * Get public coupon by code
     *
     * @param code Coupon code
     * @return GenericResponse
     */
    @ApiOperation(value = "Get Coupon Endpoint", notes = "Public endpoint")
    @GetMapping(path = UrlConstants.PUBLIC_URL + UrlConstants.COUPON_URL + "/{code}")
    public GenericResponse getCouponByCode(@PathVariable String code) {
        Coupon coupon = couponService.findByCode(code);
        return GenericResponse.builder().data(couponMapper.toCouponResponse(coupon)).build();
    }

    /**
     * Create coupon
     *
     * @param couponRequest {@link CouponRequest}
     * @return GenericResponse
     */
    @ApiOperation(value = "Create A Coupon Endpoint", notes = "Admin endpoint")
    @PostMapping(path = UrlConstants.COUPON_URL)
    public GenericResponse create(@RequestBody @Valid CouponRequest couponRequest) {
        Coupon coupon = couponService.create(couponRequest);
        return GenericResponse.builder().data(couponMapper.toCouponResponse(coupon)).build();
    }

    /**
     * Update coupon
     *
     * @param id            Coupon Id
     * @param couponRequest {@link CouponRequest}
     * @return GenericResponse
     */
    @ApiOperation(value = "Update A Coupon Endpoint", notes = "Admin endpoint")
    @PutMapping(path = UrlConstants.COUPON_URL + "/{id}")
    public GenericResponse update(@PathVariable UUID id, @RequestBody @Valid CouponRequest couponRequest) {
        Coupon coupon = couponService.update(id, couponRequest);
        return GenericResponse.builder().data(couponMapper.toCouponResponse(coupon)).build();
    }

    /**
     * Delete coupon
     *
     * @param id Coupon Id
     * @return GenericResponse
     */
    @ApiOperation(value = "Delete A Coupon Endpoint", notes = "Admin endpoint")
    @DeleteMapping(path = UrlConstants.COUPON_URL + "/{id}")
    public GenericResponse delete(@PathVariable UUID id) {
        couponService.delete(id);
        return new GenericResponse();
    }

    /**
     * Delete coupons
     *
     * @param idsRequest List coupon id
     * @return GenericResponse
     */
    @ApiOperation(value = "Delete Coupons Endpoint", notes = "Admin endpoint")
    @DeleteMapping(path = UrlConstants.COUPON_URL)
    public GenericResponse deleteAll(@RequestBody IdsRequest idsRequest) {
        couponService.deleteAll(idsRequest.getIds());
        return new GenericResponse();
    }
}
