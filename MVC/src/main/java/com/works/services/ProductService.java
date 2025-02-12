package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProductRepository pRepo;

    public ProductService(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }

   public boolean save(Product product){
        pRepo.save(product);
        return true;
    }

    public List<Product> list() {
        return pRepo.findAll();
    }

    public boolean delete( int pid ){
        pRepo.deleteById(pid);
        return true;
    }
}
