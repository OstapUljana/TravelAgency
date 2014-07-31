package com.vz.jpa.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.vz.jpa.entities.Tour;

@XmlRootElement
public class AnsverListClass {
	@XmlElement
	public List<Tour> tourList;

	public AnsverListClass() {
	}

	public AnsverListClass(List<Tour> tours) {
		tourList = tours;
	}
}
