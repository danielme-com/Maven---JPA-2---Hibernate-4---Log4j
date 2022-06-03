/*
* Copyright (C) 2012 Daniel Medina <http://danielme.com>
*
* This file is part of "MavenJpaHibernateLog4jDemo".
*
* "MavenJpaHibernateLog4jDemo" is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, version 3.
*
* "MavenJpaHibernateLog4jDemo" is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License version 3
* along with this program. If not, see <http://www.gnu.org/licenses/gpl-3.0.html/>
*/ 
package com.danielme.demo;

import java.util.LinkedList;


import com.danielme.demo.model.EntityA;
import com.danielme.demo.model.EntityB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author danielme.com
 *
 */
public class Main
{	
	
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args)
	{
		logger.info("demo begins...");
		
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit_demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        
        EntityA entityA= new EntityA();
        entityA.setName("parent");
        
        EntityB entityB1  = new EntityB();
        entityB1.setName("child 1");
        entityB1.setEntityA(entityA);
        
        EntityB entityB2 = new EntityB();
        entityB2.setName("child 2");
        entityB2.setEntityA(entityA);
        
        entityA.setEntities(new LinkedList<EntityB>());
        entityA.getEntities().add(entityB1);
        entityA.getEntities().add(entityB2);        
        
        try
        {
        	//children will be persisted on cascade
        	entityManager.persist(entityA);
        	transaction.commit();
        	
        	 logger.info("===================");
             logger.info(entityA.getId() + " " + entityA.getName()+ " : ");
             for (EntityB entityB : entityA.getEntities())
             {
             	logger.info("  " + entityB.getId() + " " + entityB.getName());
             }
        }
        catch (Exception ex)
        {
        	logger.error(ex.getMessage(), ex);
        	transaction.rollback();
        }
        finally
        {
        	entityManager.close();
        } 
        
	}

}