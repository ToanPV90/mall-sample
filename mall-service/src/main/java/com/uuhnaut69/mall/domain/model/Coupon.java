package com.uuhnaut69.mall.domain.model;

import com.uuhnaut69.mall.core.model.AbstractEntity;
import com.uuhnaut69.mall.domain.enums.CouponStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Data
@Entity
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Coupon Model", description = "Coupon info")
public class Coupon extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Coupon's id")
    private UUID id;

    @ApiModelProperty(value = "Coupon's code")
    @Column(nullable = false, unique = true)
    private String code;

    @ApiModelProperty(value = "Coupon's status")
    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus;

    @Column(nullable = false)
    @ApiModelProperty(value = "Coupon's discount")
    private Integer discountPercent;

    @ApiModelProperty(value = "Coupon's starting date")
    private Timestamp startingDate;

    @ApiModelProperty(value = "Coupon's ending date")
    private Timestamp endingDate;
}
