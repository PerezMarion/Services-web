package com.poe.jakartademo;

import com.mycompany.jakartademo.business.Customer;
import com.mycompany.jakartademo.business.Directory;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class AnnuaireTest {
    
    @Test
    public void testAddAndFindById() {
        
        Directory d = new Directory();
        d.add(new Customer ("Alain", "Delon"));
        Optional<Customer> oc = d.findById(0L);
        if(oc.isPresent()) {
            Customer customer = oc.get();
            System.out.println(customer);
            Assert.assertEquals("Alain", customer.getFirstName());
        }
    }

    @Test
    public void testDeleteAndGetAll() {
        
        Directory d = new Directory();
        d.add(new Customer ("Alain", "Delon"));
        d.add(new Customer ("Michel", "Dupont"));
        d.add(new Customer ("Marie", "Durand"));
        
        int size = d.getAll().size();
        d.delete(1L);
        Assert.assertEquals(size-1, d.getAll().size());
        Assert.assertTrue(d.findById(1L).isEmpty());
        Assert.assertTrue(d.findById(2L).isPresent());
    }
    
    @Test
    public void testUpdate() {
        
        Directory d = new Directory();
        d.add(new Customer ("Alain", "Delon"));
        d.add(new Customer ("Michel", "Dupont"));
        d.add(new Customer ("Marie", "Durand"));
        
        Optional<Customer> oc = d.findById(1L);
        if(oc.isPresent()){
            Customer customer = oc.get();
            Assert.assertEquals("Michel", customer.getFirstName());
            
            customer.setFirstName("Didier");
            d.update(customer);
            
            Assert.assertEquals(3, d.getAll().size());
            
            Optional<Customer> oc2 = d.findById(1L);
            if(oc2.isPresent()){
                Customer customer2 = oc2.get();
                Assert.assertEquals("Didier", customer2.getFirstName());
            }
        }
    } 
}