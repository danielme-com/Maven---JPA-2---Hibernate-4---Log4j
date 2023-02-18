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
package com.danielme.demo.model;


import jakarta.persistence.*;

@Entity
public class EntityB
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@ManyToOne(optional=false)
	private EntityA entityA;

	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public EntityA getEntityA()
	{
		return entityA;
	}

	public void setEntityA(EntityA entityA)
	{
		this.entityA = entityA;
	}	
	
}