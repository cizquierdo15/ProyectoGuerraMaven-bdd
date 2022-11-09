package jdbc.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.ConexBDD;
import jdbc.modelo.Guerrero;


public class GuerreroRepositorioImpl implements IGuerrero<Guerrero>{

		//conex
		private Connection getConnection() throws SQLException {
			return ConexBDD.getInstance();
		}

		@Override
		public List<Guerrero> listar() {
			List<Guerrero> guerreros = new ArrayList<Guerrero>();

			try (Statement stmt = getConnection().createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM guerreros")) { //ejecuta la select
				while (rs.next()) { //mientras hay guerreros añade
					Guerrero g = crearGuerrero(rs);
					guerreros.add(g);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return guerreros;
		}


		@Override
		public Guerrero porId(Long id) {
			Guerrero guerrero = null;

			try (PreparedStatement stmt = getConnection().
					prepareStatement("SELECT * FROM productos WHERE id = ?")) {
				stmt.setLong(1, id);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						guerrero = crearGuerrero(rs);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return guerrero;
		}

		@Override
		public void guardar(Guerrero guerrero) {
			String sql;
			if (guerrero.getId() != null && guerrero.getId()>0) {
				sql = "UPDATE gerreros SET nombre=?, pataque=?, pdefensa=?, pvida =? WHERE id=?";
			} else {
				sql = "INSERT INTO guerreros(nombre, precio, fecha_registro) VALUES(?,?,?)";
			}
			try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
				stmt.setString(1, guerrero.getNombre());
				stmt.setInt(2, guerrero.getPataque());
				stmt.setInt(3, guerrero.getPdefensa());
				stmt.setInt(4, guerrero.getPvida());

				if (guerrero.getId() != null && guerrero.getId() > 0) {
					stmt.setLong(3, guerrero.getId());
				} else {
					stmt.setInt(3, (guerrero.getPataque()));
				}

				stmt.executeUpdate();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}

		}

		@Override
		public void eliminar(Long id) {
			try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM guerreros WHERE id=?")) {
				stmt.setLong(1, id);
				stmt.executeUpdate();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

		private Guerrero crearGuerrero(ResultSet rs) throws SQLException {
			Guerrero guerrero = new Guerrero();
			guerrero.setId(rs.getLong("id")); // va cogiendo los campos y luego los añade a la lista al retornarlos
			guerrero.setNombre(rs.getString("nombre"));
			guerrero.setPataque(rs.getInt("pataque"));
			guerrero.setPdefensa(rs.getInt("pdefensa"));
			guerrero.setPvida(rs.getInt("pvida"));
			
			return guerrero;
		}
}
