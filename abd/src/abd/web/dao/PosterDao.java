package abd.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import abd.web.bean.Poster;
import abd.web.common.ConnectionFactory;

public class PosterDao {
	public List<Poster> findAll(){
		List<Poster> list=new ArrayList<Poster>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				//1.注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="select * from t_poster";
				//2.预处理
				pstmt=conn.prepareStatement(sql);
				//3.执行
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id=rs.getLong("id");
					String title=rs.getString("title");
					String author=rs.getString("author");
					String content=rs.getString("content");
					Date date=rs.getDate("publisurDate");
					int clickTimes=rs.getInt("clickTimes");
					long c_id=rs.getLong("c_id");
					
					Poster poster=new Poster();
					poster.setTitle(title);
					poster.setAuthor(author);
					poster.setClickTimes(clickTimes);
					poster.setC_id(c_id);
					poster.setContent(content);
					poster.setId(id);
					poster.setPublisurDate(date);
					
					list.add(poster);
				}
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void save(Poster poster){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_poster(title,content,author,publisurDate,clickTimes,c_id) values(?,?,?,?,?,?)";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, poster.getTitle());
				pstmt.setString(2, poster.getContent() );
				pstmt.setString(3, poster.getAuthor());
				pstmt.setDate(4, new Date(poster.getPublisurDate().getTime()));
				pstmt.setInt(5, poster.getClickTimes());
				pstmt.setLong(6, poster.getC_id());
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
