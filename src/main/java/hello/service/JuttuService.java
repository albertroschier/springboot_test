package hello.service;

import java.util.List;

import hello.Juttu;

public interface JuttuService {
	Juttu getJuttu(int juttuid);
	
	List<Juttu> listJuttus();
}
