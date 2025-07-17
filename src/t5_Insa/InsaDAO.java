package t5_Insa;

import java.sql.SQLException;

public class InsaDAO extends DBConn {
	
	InsaVO vo = null;

	// 회원가입 처리
	public int setInsaInput(InsaVO vo) {
		int res = 0;
		
		try {
			sql = "insert into insa values (default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			
			res = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			System.out.println("sql오류(setInsaInput): " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 회원 개별 조회 (성명 중복체크)
	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();
		
		try {
			sql = "select * from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		}  catch (SQLException e) {
			System.out.println("sql오류(getNameSearch): " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;
	}
}
