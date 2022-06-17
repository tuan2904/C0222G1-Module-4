package com.example.service;

import com.example.model.ProductModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static List<ProductModel> productModels = new ArrayList<>();

    static {
        productModels.add(new ProductModel(1, "iphone5", 50000, "đẹp", "Apple"));
        productModels.add(new ProductModel(2, "iphone6", 50000, "đẹp", "Apple"));
        productModels.add(new ProductModel(3, "iphone7", 50000, "đẹp", "Apple"));
        productModels.add(new ProductModel(4, "iphone8", 50000, "đẹp", "Apple"));
    }

    @Override
    public List<ProductModel> listProduct() {
        return productModels;
    }

    @Override
    public void remove(int id) {
        productModels.remove(id);
    }

    @Override
    public void update(int id, ProductModel productModel) {
        productModels.set(id, productModel);
    }

    @Override
    public void create(ProductModel productModel) {
        productModels.add(productModel.getIdProduct(), productModel);

    }

    @Override
    public List<ProductModel> search(String nameProduct) {
        List<ProductModel> list = new ArrayList<>();
        for (ProductModel items : productModels) {
            if (items.getNameProduct().contains(nameProduct)) {
                list.add(items);
            }
        }
        return list;
    }

    @Override
    public ProductModel searchId(int id) {
        return productModels.get(id);
    }
}
