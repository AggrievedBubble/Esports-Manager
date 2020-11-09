/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author User
 * @param <T>
 */
public interface EsportsInterface<T> extends Serializable{
	
	public T get();
	public String getName();
	public void setName(String name);
	public Map getScores();
	public void setScores(Map scr);
	
}
