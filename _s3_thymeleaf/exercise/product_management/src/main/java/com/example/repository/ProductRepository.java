package com.example.repository;

import com.example.model.ProductModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<ProductModel> listProduct() {
        List<ProductModel> listProduct = BaseRepository.entityManager.createQuery("select p from product_table p", ProductModel.class).getResultList();
        return listProduct;
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        ProductModel productModel1 = searchId(id);
        BaseRepository.entityManager.remove(productModel1);
        entityTransaction.commit();
    }

    @Override
    public void update(ProductModel productModel) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(productModel);
        entityTransaction.commit();
    }

    @Override
    public void create(ProductModel productModel) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(productModel);
        entityTransaction.commit();

    }

    @Override
    public List<ProductModel> search(String name) {
        List<ProductModel> resultList = BaseRepository.entityManager.createQuery("select p from product_table p where p.nameProduct like ?1", ProductModel.class).setParameter(1, name).getResultList();

        return resultList;
    }

    @Override
    public ProductModel searchId(int id) {
        ProductModel listProducts = (ProductModel) BaseRepository.entityManager.createQuery("select p from product_table p where p.idProduct=?1").setParameter(1, id).getSingleResult();
        return listProducts;
    }
}
