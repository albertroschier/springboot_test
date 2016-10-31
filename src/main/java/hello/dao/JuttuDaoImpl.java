package hello.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hello.Juttu;

@Repository
public class JuttuDaoImpl implements JuttuDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public Juttu getJuttu(int juttuid) {
		return jdbcTemplate.queryForObject("SELECT juttuid, nimi FROM juttu WHERE juttuid = ?", new Object[] {juttuid}, new JuttuRowMapper());
	}

	public List<Juttu> listJuttus() {
		return jdbcTemplate.query("SELECT juttuid, nimi FROM juttu", new JuttuRowMapper());
	}

}

class JuttuRowMapper implements RowMapper<Juttu> {

	public Juttu mapRow(ResultSet arg0, int arg1) throws SQLException {
		Juttu j = new Juttu();
		j.setJuttuid(arg0.getInt("juttuid"));
		j.setNimi(arg0.getString("nimi"));
		return j;
	}
	
}
