package com.weapp.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.weapp.domain.Application;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ApplicationRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Test
    public void whenFindByName_thenReturnApplications() {
        // given
        Application dummy1 = new Application();
        dummy1.setName("Cook");
        Application dummy2 = new Application();
        dummy2.setName("Cook");
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByName(dummy1.getName());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }
    
    @Test
    public void whenFindByOrganization_thenReturnApplications() {
        // given
        Application dummy1 = new Application();
        dummy1.setOrganization("No name");
        Application dummy2 = new Application();
        dummy2.setOrganization("No name");
        entityManager.persist(dummy1);
        entityManager.persist(dummy2);
        entityManager.flush();
        
        List<Application> expRet = new ArrayList<>(); 
        expRet.add(dummy1);
        expRet.add(dummy2);
     
        // when
        List<Application> results = applicationRepository.findByOrganization(dummy1.getOrganization());
        
     
        // then
        assertThat(results).isEqualTo(expRet);
    }

}