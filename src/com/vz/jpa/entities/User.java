package com.vz.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@XmlRootElement
@Table(name = "client", schema = "travelagency")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8726228016363110297L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Client_id")
    private int iduser;

	@Column(name = "E_mail")
    private String login;

	@Column(name = "Password")
    private String pass;

    public User() {
    }

    public User(int iduser, String login, String pass) {
        this.iduser = iduser;
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return iduser;
    }

    public void setId(int id) {
        this.iduser = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
