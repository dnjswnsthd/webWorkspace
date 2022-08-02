package web.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO {
	private DataSource ds;
	private static ProductDAOImpl dao = new ProductDAOImpl();

	private ProductDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracleDB");
		} catch (NamingException e) {
			System.out.println("lookup 실패");
		}
	}

	public static ProductDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	@Override
	public int AddPrdouct(Product vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0;
		try {
			conn = getConnection();
			String query = "INSERT INTO product VALUES(product_seq.NEXTVAL,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getDescription());
			System.out.println(ps.executeUpdate() + " row INSERT OK!!");
			id = getCurrentId(ps, conn);
		} finally {
			closeAll(ps, conn);
		}

		return id;
	}

	@Override
	public int getCurrentId(PreparedStatement ps, Connection conn) throws SQLException {
		conn = getConnection();
		String query = "SELECT prod_id FROM (SELECT * FROM PRODUCT ORDER BY prod_id DESC) WHERE ROWNUM = 1";
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	@Override
	public ArrayList<Product> findAllProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT prod_id id, prod_name name, price, description FROM product";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllMember()..");

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("description")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

}
