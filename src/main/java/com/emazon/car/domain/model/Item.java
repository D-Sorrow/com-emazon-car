package com.emazon.car.domain.model;

public class Item {

    private Long itemId;

    private Long articleId;

    private Integer quantity;

    public Item(Long itemId, Long articleId, Integer quantity) {
        this.itemId = itemId;
        this.articleId = articleId;
        this.quantity = quantity;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
