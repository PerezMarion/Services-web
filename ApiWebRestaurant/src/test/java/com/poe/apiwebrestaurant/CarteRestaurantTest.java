package com.poe.apiwebrestaurant;

import com.mycompany.apiwebrestaurant.business.Directory;
import com.mycompany.apiwebrestaurant.business.Meal;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class CarteRestaurantTest {
    
    @Test
    public void testAddAndFindById() {
        
        Directory d = new Directory();
        d.add(new Meal ("Poulet basquaise", 
                        "Filet de poulet fermier et sa sauce tomate poivron accompagné de riz", 12.95F));
        Optional<Meal> om = d.findById(0L);
        if(om.isPresent()) {
            Meal meal = om.get();
            System.out.println(meal);
            Assert.assertEquals("Poulet basquaise", meal.getName());
        }
    }

    @Test
    public void testDeleteAndGetAll() {
        
        Directory d = new Directory();
        d.add(new Meal ("Poulet basquaise", 
                        "Filet de poulet fermier et sa sauce tomate poivron accompagné de riz", 12.95F));
        d.add(new Meal ("Camembert roti", 
                        "Camembert AOP au lait cru roti au four accompagné de pain grillé graté à l'ail", 15F));
        d.add(new Meal ("Tarte au chocolat", 
                        "Pate feuilletée et creme au chocolat noir 70%", 6.5F));
        
        int size = d.getAll().size();
        Optional<Meal> om = d.findById(1L);
        Meal meal = om.get();
        d.delete(meal);
        Assert.assertEquals(size-1, d.getAll().size());
        Assert.assertTrue(d.findById(1L).isEmpty());
        Assert.assertTrue(d.findById(2L).isPresent());
    }
    
    @Test
    public void testUpdate() {
        
        Directory d = new Directory();
        d.add(new Meal ("Poulet basquaise", 
                        "Filet de poulet fermier et sa sauce tomate poivron accompagné de riz", 12.95F));
        d.add(new Meal ("Camembert roti", 
                        "Camembert AOP au lait cru roti au four accompagné de pain grillé graté à l'ail", 15F));
        d.add(new Meal ("Tarte au chocolat", 
                        "Pate feuilletée et creme au chocolat noir 70%", 6.5F));
        
        Optional<Meal> om = d.findById(1L);
        if(om.isPresent()){
            Meal meal = om.get();
            Assert.assertEquals("Camembert roti", meal.getName());
            
            meal.setName("Camembert AOP roti");
            d.update(meal);
            
            Assert.assertEquals(3, d.getAll().size());
            
            Optional<Meal> om2 = d.findById(1L);
            if(om2.isPresent()){
                Meal meal2 = om2.get();
                Assert.assertEquals("Camembert AOP roti", meal2.getName());
            }
        }
    } 
}