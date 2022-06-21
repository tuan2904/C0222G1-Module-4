package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> listProduct() {
        List<Product> listProduct = BaseRepository.entityManager.createQuery("select p from product_table p", Product.class).getResultList();
        return listProduct;
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product1 = searchId(id);
        BaseRepository.entityManager.remove(product1);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();

    }

    @Override
    public List<Product> search(String name) {
        List<Product> resultList = BaseRepository.entityManager.createQuery("select p from product_table p where p.nameProduct like ?1", Product.class).setParameter(1, name).getResultList();

        return resultList;
    }

    @Override
    public Product searchId(int id) {
        Product listProducts = (Product) BaseRepository.entityManager.createQuery("select p from product_table p where p.idProduct=?1").setParameter(1, id).getSingleResult();
        return listProducts;
    }
}
