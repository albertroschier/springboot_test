package hello.dao;

import java.util.List;

import hello.Juttu;

public interface JuttuDao {

	Juttu getJuttu(int juttuid);
	
	List<Juttu> listJuttus();
}
