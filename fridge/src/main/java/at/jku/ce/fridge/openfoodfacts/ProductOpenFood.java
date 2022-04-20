package at.jku.ce.fridge.openfoodfacts;


import pl.coderion.model.Ingredient;
import pl.coderion.model.Product;
import pl.coderion.model.ProductResponse;
import pl.coderion.model.SelectedImages;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductOpenFood {

    private String ean;
    private String name;
    private String generic_name;
    private List<String> categories = new ArrayList<>();
    private List<String> ingredients = new ArrayList<>();
    private String picture;

    public ProductOpenFood(){}

//    public ProductOpenFood (String ean) {
//        this.ean = ean;
//    }

    public ProductOpenFood (String ean) {
        OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
        ProductResponse productResponse = wrapper.fetchProductByCode(ean);
        Product product = productResponse.getProduct();
        this.ean = product.getCode();
        this.name = product.getProductName();
        this.generic_name = product.getGenericName();
        try {
            for (String elem : product.getCategoriesHierarchy()) {
                assert false;
                this.categories.add(elem);
            }
        } catch (Exception ignored1){}
        try{
            for (Ingredient elem : product.getIngredients()) {
                assert false;
                this.ingredients.add(elem.getText());
            }
        }catch (Exception ignored){}
        SelectedImages selectedImages = product.getSelectedImages();
        if (selectedImages != null) {
            this.picture = selectedImages.getFront().getDisplay().getUrl();
        }
    }

    public ProductOpenFood (String ean, String name) {
        this.ean = ean;
        this.name = name;
    }

    public ProductOpenFood (String ean, String name, String generic_name) {
        this.ean = ean;
        this.name = name;
        this.generic_name = generic_name;
    }

    public ProductOpenFood (String ean, String name, String generic_name, List<String> categories) {
        this.ean = ean;
        this.name = name;
        this.generic_name = generic_name;
        this.categories = categories;
    }

    public ProductOpenFood (String ean, String name, String generic_name, List<String> categories, List<String> ingredients) {
        this.ean = ean;
        this.name = name;
        this.generic_name = generic_name;
        this.categories = categories;
        this.ingredients = ingredients;
    }

    public ProductOpenFood (String ean, String name, String generic_name, List<String> categories, List<String> ingredients, String picture) {
        this.ean = ean;
        this.name = name;
        this.generic_name = generic_name;
        this.categories = categories;
        this.ingredients = ingredients;
        this.picture = picture;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
