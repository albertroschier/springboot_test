package hello.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hello.Henkilo;

@Repository
public class HenkiloDaoImpl implements HenkiloDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public Henkilo getHenkilo(int henkiloid) {
		return jdbcTemplate.queryForObject("SELECT henkiloid, etunimi, sukunimi FROM henkilo WHERE henkiloid = ?", new Object[] {henkiloid}, new HenkiloRowMapper());
	}

	public List<Henkilo> listHenkilos() {
		return jdbcTemplate.query("SELECT henkiloid, etunimi, sukunimi FROM henkilo", new HenkiloRowMapper());
	}

	public Henkilo insertHenkilo(Henkilo henkilo) {
		jdbcTemplate.update("INSERT INTO henkilo (henkiloid, etunimi, sukunimi) VALUES ( ?, ?, ? )", 
		new Object[] {henkilo.getHenkiloid(), henkilo.getEtunimi(), henkilo.getSukunimi()} );
		return henkilo;
	}

	public void updateHenkilo(Henkilo henkilo) {
		jdbcTemplate.update("UPDATE henkilo SET etunimi=?, sukunimi=? WHERE henkiloid=?",
		new Object[] {henkilo.getEtunimi(), henkilo.getSukunimi(), henkilo.getHenkiloid()} );
	}
	
	public void deleteHenkilo(Henkilo henkilo) {
		jdbcTemplate.update("DELETE FROM henkilo WHERE henkiloid=?",
		new Object[] {henkilo.getHenkiloid()} );
	}


}

class HenkiloRowMapper implements RowMapper<Henkilo> {

	public Henkilo mapRow(ResultSet arg0, int arg1) throws SQLException {
		Henkilo h = new Henkilo();
		h.setHenkiloid(arg0.getInt("henkiloid"));
		h.setEtunimi(arg0.getString("etunimi"));
		h.setSukunimi(arg0.getString("sukunimi"));
		return h;
	}

}