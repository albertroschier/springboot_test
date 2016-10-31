package hello.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.Henkilo;
import hello.dao.HenkiloDao;

@Transactional
@Service
public class HenkiloServiceImpl implements HenkiloService {
	
	@Autowired
	private HenkiloDao henkiloDao;

	public Henkilo getHenkilo(int henkiloid) {
		return henkiloDao.getHenkilo(henkiloid);
	}

	public List<Henkilo> listHenkilos() {
		return henkiloDao.listHenkilos();
	}

	public Henkilo insertHenkilo(Henkilo henkilo) {
		return henkiloDao.insertHenkilo(henkilo);
	}

	public void updateHenkilo(Henkilo henkilo) {
		henkiloDao.updateHenkilo(henkilo);
	}
	
	public void deleteHenkilo(Henkilo henkilo) {
		henkiloDao.deleteHenkilo(henkilo);
	}

}
