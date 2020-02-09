package com.uuhnaut69.mall.core.constant;

/**
 * @author uuhnaut
 * @project mall
 */
public final class MessageConstant {

    /**
     * Already exception messages
     */
    public static final String USER_NAME_ALREADY_EXIST = "User name's already existed !!!";
    public static final String USER_EMAIL_ALREADY_EXIST = "User email's already existed !!!";
    public static final String BRAND_ALREADY_EXIST = "Brand name's already existed !!!";
    public static final String CATALOG_ALREADY_EXIST = "Catalog name's already existed !!!";
    public static final String COUPON_ALREADY_EXIST = "Coupon already existed !!!";
    public static final String TAG_ALREADY_EXIST = "Tag already existed !!!";
    /**
     * Not found exception messages
     */
    public static final String USER_NOT_FOUND = "User doesn't exists !!!";
    public static final String ROLE_NOT_FOUND = "Role doesn't exists !!!";
    public static final String TOKEN_NOT_FOUND = "Token doesn't exists !!!";
    public static final String BRAND_NOT_FOUND = "Brand doesn't exists !!!";
    public static final String CATALOG_NOT_FOUND = "Catalog doesn't exists !!!";
    public static final String PRODUCT_NOT_FOUND = "Product doesn't exists !!!";
    public static final String COUPON_NOT_FOUND = "Coupon doesn't exists !!!";
    public static final String CART_NOT_FOUND = "Cart doesn't exists !!!";
    public static final String TAG_NOT_FOUND = "Tag doesn't exists !!!";
    public static final String REVIEW_NOT_FOUND = "Review doesn't exists !!!";
    /**
     * Another exception messages
     */
    public static final String CSV_ERROR = "Csv error handling !!!";
    /**
     * System messages
     */
    public static final String ACTIVATE_YOUR_ACCOUNT = "An email has been sent to your email. Please check it out to activate your account !!!";
    public static final String ACTIVATE_YOUR_ACCOUNT_MAIL_CONTENT = "One step last to register successfully, click button below to activate your account !!!";
    public static final String UNAUTHORIZED = "Unauthorize !!!";
    /**
     * Payment messages
     */
    public static final String PAYMENT_DESCRIPTION = "Pay for stuffs !!!";
    public static final String PAYMENT_SUCCEED_CANT_BE_DELETE = "Succeed cart can't be deleted !!!";
    public static final String OUT_OF_STOCKS = "This product runs of out stocks !!!";
    public static final String PAID_CART = "Cart has been paid !!!";
    public static final String PAYMENT_METHOD_IS_NOT_STRIPE = "Payment method is not stripe !!!";
    /**
     * Rate limmiting messages
     */
    public static final String REQUEST_TOO_FAST = "Request too fast !!!";
    public static final String DELETE_FAILED = "Delete failed !!!";

    private MessageConstant() {

    }
}