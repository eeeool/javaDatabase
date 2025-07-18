package t6ex_Kiosk;

import java.sql.SQLException;
import java.util.Vector;

import t5_Insa.DBConn;

@SuppressWarnings({"unchecked", "rawtypes"})
public class KioskDAO extends DBConn {
	KioskVO vo = null;
	
	// 제품 등록
	public int setMenuInput(KioskVO vo) {
		int res = 0;
				
		try {
			sql = "insert into burgerking values (?, ?, ?, default, default, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPart());
			pstmt.setString(2, vo.getProduct());
			pstmt.setString(3, vo.getDetail());
//			pstmt.setString(4, vo.getContent());
//			pstmt.setInt(5, vo.getCalorie());
			pstmt.setString(6, vo.getImage());
			pstmt.setInt(7, vo.getPrice());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(setMenuInput): " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 상품 리스트
	public Vector getMenuList() {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from burgerking order by idx desc";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("part"));
				vo.add(rs.getString("product"));
				vo.add(rs.getString("detail"));
				vo.add(rs.getString("content"));
				vo.add(rs.getInt("calorie"));
				vo.add(rs.getInt("price"));
				
				vData.add(vo);
			}
		} catch (Exception e) {
			System.out.println("sql오류(getMenuList): " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}
}
