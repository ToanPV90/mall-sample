package com.uuhnaut69.mall.domain.model;

import com.uuhnaut69.mall.core.model.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ApiModel(value = "Shipping Model", description = "Shipping payment's info")
public class Shipping extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Shipping's id")
    private UUID id;

    @ApiModelProperty(value = "Country's name")
    private String shippingCountry;

    @ApiModelProperty(value = "City's name")
    private String shippingCity;

    @ApiModelProperty(value = "Billing's address")
    private String shippingAddress;

    @ApiModelProperty(value = "Post code")
    private Integer shippingPostcode;
}
