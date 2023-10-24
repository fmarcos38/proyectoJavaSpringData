package com.platzi.market.dominian;

/*
   esta clase es una copia de la clase Producto SOLO q en ingles
   ESTO se hace YA q nuestro proyecto está orientado en DOMINIO(?)
   y al utilizar el patron Data Mapper se hace esta copia PARA Q NO se tenga acceso a las tablas de la DB

   otro punto por el cual se realiza esto espara evitar ATRIBUTOS innecesarios NO inclui el de codigo de barra
   q si está en la tabla PRODUCTO(q sería la tabla DOMINIO)
 */
public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;

    //get y set

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
