package com.mycompany.apiwebrestaurant.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Directory {
    
    private ArrayList<Meal> meals = new ArrayList<>();
    private long index = 0;
    
    public ArrayList<Meal> getAll() {
        return meals;
    }
    
    public void add (Meal meal) {
        meal.setId(index);
        index++;
        meals.add(meal);
    }
    
    public Optional<Meal> findById (Long id) {
        
        Optional<Meal> o = Optional.empty();
        for(Meal m : meals) {
            if(m.getId().equals(id)){
                o = Optional.of(m);
                break;
            }
        } return o;
    }
    
    public void delete (Meal meal) {
        Iterator<Meal> it = meals.iterator();
        while(it.hasNext()) {
            Meal m = it.next();
            if(m.getId().equals(meal.getId())) {
                meals.remove(m);
                break;
            }
        }
    }
    
    public void update (Meal meal) {
        Iterator<Meal> it = meals.iterator();
        while(it.hasNext()) {
            Meal m = it.next();
            if(m.getId().equals(meal.getId())){
                meals.remove(m);
                meals.add(meal);
                break;
            }
        }
    }
}