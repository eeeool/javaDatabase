package t5_Insa;

import java.sql.SQLException;
import java.util.Vector;

@SuppressWarnings({"rawtypes", "unchecked"})
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

	// 회원정보 수정하기
	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		
		try {
			sql = "update insa set age=?, gender=?, ipsail=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setInsaUpdate): " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 회원자료 삭제처리
	public int setInsaDelete(String name) {
		int res = 0;
		
		try {
			sql = "delete from insa where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setInsaDelete): " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 회원 전체 리스트 처리
	public Vector getInsaList(String part, String order) {
		Vector vData = new Vector<>();
		
		try {
			if (part.equals("ipsail") && order.equals("asc")) {
				sql = "select * from insa order by ipsail";								
			}
			if (part.equals("ipsail") && order.equals("desc")) {
				sql = "select * from insa order by ipsail desc";								
			}
			else {
				sql = "select * from insa order by idx desc";				
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getInsaList): " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}
	
	// 조건 검색 처리
	public Vector getConditionSearch(String fieldName, String textCondition) {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from insa where "+fieldName+" like ? order by name";								
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(0, "%"+textCondition+"%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getInsaList): " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}
}
