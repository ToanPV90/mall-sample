package com.uuhnaut69.mall.domain.model;

import com.uuhnaut69.mall.core.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Min(0)
    @Column(nullable = false)
    private Integer stocks = 0;

    @Min(0)
    @Column(nullable = false)
    private Integer soldCount = 0;

    private String imageUrls;

    @Column(nullable = false)
    private String thumbNail;

    @Column(nullable = false)
    private BigDecimal originalPrice;

    private BigDecimal discountPrice;

    @ManyToMany
    @JoinTable(name = "product_tag", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    private boolean trending;
}
