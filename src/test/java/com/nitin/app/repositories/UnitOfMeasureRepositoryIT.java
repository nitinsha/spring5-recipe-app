package com.nitin.app.repositories;

import com.nitin.app.models.Recipe;
import com.nitin.app.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception{

        Optional<UnitOfMeasure> uomTeaSpoon = unitOfMeasureRepository.findByDescription("TeaSpoon");
        assertEquals("TeaSpoon",uomTeaSpoon.get().getDescription());
    }
    @Test
    public void findByDescriptionCup() throws Exception{

        Optional<UnitOfMeasure> uomTeaSpoon = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup",uomTeaSpoon.get().getDescription());

    }
}