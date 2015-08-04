package cn.com.daos.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.liu.EmployeeBeans;
import cn.com.beans.liu.GoodsBeans;
import cn.com.beans.liu.HouseCapacityBeans;
import cn.com.beans.liu.MoveBeans;
import cn.com.beans.liu.WarehouseBeans;
import cn.com.beans.view.liu.TransferView;
import cn.com.util.DBUtil;



public class TransferdaoImpl implements TransferdaoInf {

	@Override
	public boolean addMoves(MoveBeans movesb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		String sql = "insert into moves(move_id,out_name,in_name,move_date,move_people,move_note,move_number,goods_id)"
				+ "values(?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, movesb.getMove_id());
			pstm.setString(2, movesb.getIn_name());
			pstm.setString(3, movesb.getOut_name());
			pstm.setString(4, movesb.getMove_date());
			pstm.setString(5, movesb.getMove_people());
			pstm.setString(6, movesb.getMove_note());
			pstm.setInt(7, movesb.getMove_number());
			pstm.setString(8, movesb.getGoods_id());
			int len = pstm.executeUpdate();
			if (len > 0) {
				bool = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(pstm, conn);
		}
		return bool;
	}

	@Override
	public List<TransferView> getAccount(TransferView transferV) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<TransferView> list = new ArrayList<TransferView>();
		String sql = "select goods_id,goods_name,goods_unit,goods_spft,goods_num,goods_manufacture from transfer_account"
				+ " where warehouse_id=?";
		try {
			pstm = conn.prepareStatement(sql);
			WarehouseBeans housb = transferV.getWarehouseb();
			pstm.setString(1, housb.getWarehouse_id());
			System.out.println(housb.getWarehouse_id());
			rs = pstm.executeQuery();
			TransferView transV = null;
			while (rs.next()) {
				transV = new TransferView();
				GoodsBeans goodsb = new GoodsBeans();
				HouseCapacityBeans houseb = new HouseCapacityBeans();
				goodsb.setGoods_id(rs.getString("goods_id"));
				goodsb.setGoods_name(rs.getString("goods_name"));
				goodsb.setGoods_unit(rs.getString("goods_unit"));
				goodsb.setGoods_spft(rs.getString("goods_spft"));
				houseb.setGoods_num(rs.getInt("goods_num"));
				goodsb.setGoods_manufacture(rs.getString("goods_manufacture"));

				transV.setGoodsb(goodsb);
				transV.setHousecapb(houseb);

				list.add(transV);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, pstm, conn);
		}

		return list;
	}

	@Override
	public TransferView getChoose(TransferView transferV) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		TransferView transV = null;
		String sql = "select goods_id,goods_name,goods_unit,goods_spft,goods_apvlunm,goods_num,goods_manufacture from transfer_account "
				+ "where goods_id=? and warehouse_id=?";
		try {
			WarehouseBeans warehouseb = transferV.getWarehouseb();
			GoodsBeans godsb = transferV.getGoodsb();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, godsb.getGoods_id());
			pstm.setString(2, warehouseb.getWarehouse_id());
			rs = pstm.executeQuery();
			transV = new TransferView();
			GoodsBeans goodsb = new GoodsBeans();
			HouseCapacityBeans houseb = new HouseCapacityBeans();
			while(rs.next()) {
				goodsb.setGoods_id(rs.getString("goods_id"));
				goodsb.setGoods_name(rs.getString("goods_name"));
				goodsb.setGoods_unit(rs.getString("goods_unit"));
				goodsb.setGoods_spft(rs.getString("goods_spft"));
				goodsb.setGoods_apvlnum(rs.getString("goods_apvlunm"));
				houseb.setGoods_num(rs.getInt("goods_num"));
				goodsb.setGoods_manufacture(rs.getString("goods_manufacture"));

				transV.setGoodsb(goodsb);
				transV.setHousecapb(houseb);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, pstm, conn);
		}
		return transV;
	}

	@Override
	public List<MoveBeans> searchMoves(String date1, String date2) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MoveBeans> mlist = new ArrayList<MoveBeans>();
		String sql = "select * from moves where move_date between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, date1);
			pstm.setString(2, date2);
			rs = pstm.executeQuery();
			MoveBeans moveb = null;
			while (rs.next()) {
				moveb = new MoveBeans();
				moveb.setMove_id(rs.getString(1));
				moveb.setOut_name(rs.getString(2));
				moveb.setIn_name(rs.getString(3));
				moveb.setMove_date(rs.getString(4));
				moveb.setMove_people(rs.getString(5));
				moveb.setMove_note(rs.getString(6));
				moveb.setMove_number(rs.getInt(7));
				moveb.setGoods_id(rs.getString(8));
				mlist.add(moveb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, pstm, conn);
		}

		return mlist;
	}

	@Override
	public boolean updateHouseCapacity(HouseCapacityBeans houseb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		String csql = "update HouseCapacity set warehouse_id=?,goods_id=?,goods_num=? "
				+ "where warehouse_id=? and goods_id = ?";
		try {
			pstm = conn.prepareStatement(csql);
			pstm.setString(1, houseb.getWarehouse_id());
			pstm.setString(2, houseb.getGoods_Id());
			pstm.setInt(3, houseb.getGoods_num());
			pstm.setString(4, houseb.getWarehouse_id());
			pstm.setString(5, houseb.getGoods_Id());
			int len = pstm.executeUpdate();
			if (len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean searchMovesByNo(MoveBeans moveb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		String mNsql = "select * from moves where move_id = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(mNsql);
			pstm.setString(1, moveb.getMove_id());
			rs = pstm.executeQuery();
			bool = rs.next();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, pstm, conn);
		}
		return bool;
	}

	// 得到所有的倉庫名
	@Override
	public List<WarehouseBeans> getAllwarehouse() {
		// TODO Auto-generated method stub
		List<WarehouseBeans> wlist = new ArrayList<WarehouseBeans>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String wsql = "select warehouse_name,warehouse_id from warehouse ";
		try {
			pstm = conn.prepareStatement(wsql);
			rs = pstm.executeQuery();
			WarehouseBeans whouse = null;
			while (rs.next()) {
				whouse = new WarehouseBeans();
				whouse.setWarehouse_name(rs.getString("warehouse_name"));
				whouse.setWarehouse_id(rs.getString("warehouse_id"));
				wlist.add(whouse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wlist;
	}

	@Override
	public List<EmployeeBeans> getAllEmp() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<EmployeeBeans> elist = new ArrayList<EmployeeBeans>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select employee_name from employee";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				EmployeeBeans emp = new EmployeeBeans();
				emp.setEmployee_name(rs.getString("employee_name"));
				elist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
	}

	@Override
	public List<MoveBeans> getAllMoves() {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = DBUtil.getConnection();
		String mNsql = "select * from moves";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MoveBeans> list = new ArrayList<MoveBeans>();
		try {
			pstm = conn.prepareStatement(mNsql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MoveBeans moveb = new MoveBeans();
				moveb.setMove_id(rs.getString(1));
				moveb.setOut_name(rs.getString(2));
				moveb.setIn_name(rs.getString(3));
				moveb.setMove_date(rs.getString(4));
				moveb.setMove_people(rs.getString(5));
				moveb.setMove_note(rs.getString(6));
				moveb.setMove_number(rs.getInt(7));
				moveb.setGoods_id(rs.getString(8));
				list.add(moveb);
				//System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, pstm, conn);
		}
		return list;
	}

	@Override
	public List<TransferView> getGoodsByMid(MoveBeans movesb) {
		List<TransferView> glist = new ArrayList<TransferView>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select goods.*,move_number from goods inner join moves "+
		"on  moves.goods_id = goods.goods_id where moves.move_id=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, movesb.getMove_id());
			rs = pstm.executeQuery();
			GoodsBeans gb = null;
			MoveBeans mb = null;
			TransferView tV = null;
			while(rs.next()) {
				gb = new GoodsBeans();
				mb = new MoveBeans();
				tV = new TransferView();
				gb.setGoods_id(rs.getString("goods_id"));
				gb.setGoods_name(rs.getString("goods_name"));
				mb.setMove_number(rs.getInt("move_number"));
				gb.setGoods_unit(rs.getString("goods_unit"));
				gb.setGoods_spft(rs.getString("goods_spft"));
				gb.setGoods_apvlnum(rs.getString("goods_apvlunm"));
				tV.setGoodsb(gb);
				tV.setMovesb(mb);
				glist.add(tV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, pstm, conn);
		}
		return glist;
	}
}
