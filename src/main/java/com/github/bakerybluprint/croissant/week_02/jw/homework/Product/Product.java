package com.github.bakerybluprint.croissant.week_02.jw.homework.Product;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 11:55 오후
 */
public class Product {
    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);
    public static final Map<Integer, Product> product;

    static {
        product = new HashMap<>();
        product.put(111111, new Product(111111, 20000L, 12345L, 10));
        product.put(222222, new Product(222222,10000L, 0L, 40));
        product.put(333333, new Product(333333, 10000L, 0L, 0));
    }


    private  Integer prdCd;
    private  Long prdPrc;
    private  Long giftNo;
    private  Integer stock;

    public Product() {}

    public Product(Integer prdCd) {
        this.prdCd = prdCd;
    }

    public Product(Integer prdCd, Long prdPrc, Long giftNo, Integer stock) {
        this.prdCd = prdCd;
        this.prdPrc = prdPrc;
        this.giftNo = giftNo;
        this.stock = stock;
    }

    public static class Builder {
        private  Integer prdCd;
        private  Long prdPrc;
        private  Long giftNo;
        private  Integer stock;

        public Builder prdCd(Integer val1) {
            prdCd = val1;
            return this;
        }
        public Builder prdPrc(Long val2) {
            prdPrc = val2;
            return this;
        }
        public Builder giftNo(Long val3) {
            giftNo = val3;
            return this;
        }
        public Builder stock(Integer val4) {
            stock = val4;
            return this;
        }

        public Product builder() {
            return new Product(this);
        }
    }

    public Product(Builder builder) {
        builder.prdCd = prdCd;
        builder.giftNo = giftNo;
        builder.prdPrc = prdPrc;
        builder.stock = stock;
    }

    public static void ProductInfo() {
        for (Integer key : Product.product.keySet()) {

            LOGGER.info("상품코드 : "   +product.get(key).prdCd
                    +", 상품가격 : "   +product.get(key).prdPrc
                    +", 사은품코드 : "  +product.get(key).giftNo
                    +", 재고 : "      +product.get(key).stock);

        }
    }

    // TODO: [상품의 재고 체크] junwoochoi 2020/05/06 9:32 오후
    public boolean checkStockProduct(Product productEntity) {

        return product.get(productEntity.prdCd).stock != 0;
    }

    public boolean checkGiftProduct(Product productEntity) {

        return product.get(productEntity.prdCd).giftNo == 0;
    }

}
