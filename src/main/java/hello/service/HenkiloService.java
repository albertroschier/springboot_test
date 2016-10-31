package hello.service;

import java.util.List;

import hello.Henkilo;

public interface HenkiloService {
	Henkilo getHenkilo(int henkiloid);
	
	List<Henkilo> listHenkilos();
	
	Henkilo insertHenkilo(Henkilo henkilo);
	
	void updateHenkilo(Henkilo henkilo);
	
	void deleteHenkilo(Henkilo henkilo);
}
