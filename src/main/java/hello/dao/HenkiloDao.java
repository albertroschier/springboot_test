package hello.dao;

import java.util.List;

import hello.Henkilo;

public interface HenkiloDao {

	Henkilo getHenkilo(int henkiloid);
	
	List<Henkilo> listHenkilos();
	
	Henkilo insertHenkilo(Henkilo henkilo);
	
	void updateHenkilo(Henkilo henkilo);
	
	void deleteHenkilo(Henkilo henkilo);
}

