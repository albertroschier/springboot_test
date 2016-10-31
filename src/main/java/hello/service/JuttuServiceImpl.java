package hello.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.Juttu;
import hello.dao.JuttuDao;

@Transactional
@Service
public class JuttuServiceImpl implements JuttuService {
	
	@Autowired
	private JuttuDao juttuDao;

	public Juttu getJuttu(int juttuid) {
		return juttuDao.getJuttu(juttuid);
	}

	public List<Juttu> listJuttus() {
		return juttuDao.listJuttus();
	}

}
