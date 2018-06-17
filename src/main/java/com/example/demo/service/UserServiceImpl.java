package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(User user) {
		jdbcTemplate.update("insert into t_user(username,password,sex,age) value(?,?,?,?)",user.getUsername(),user.getPassword(),user.getSex(),user.getAge());
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from t_user where id=?",id);
	}

	@Override
	public List<User> getAllUser() {
		return jdbcTemplate.query("select * from t_user", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User temp=new User();
				temp.setId(rs.getInt("id"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setSex(rs.getString("sex"));
				temp.setAge(rs.getInt("age"));
				return temp;
			}
			
		});
	}

	@Override
	public User getUsrByid(int id) {
		User user=(User) jdbcTemplate.query("select * from t_user where id=?", new ResultSetExtractor() {

			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					User temp=new User();
					temp.setId(rs.getInt("id"));
					temp.setUsername(rs.getString("username"));
					temp.setPassword(rs.getString("password"));
					temp.setSex(rs.getString("sex"));
					temp.setAge(rs.getInt("age"));
					return temp;
				}
				return null;
			}
			
		},id);
		
		return user;
	}

	@Override
	public int updateUsrById(User user) {
		return jdbcTemplate.update("update t_user set username=?,password=?,age=?,sex=? where id=?",user.getUsername(),user.getPassword(),user.getAge(),user.getSex(),user.getId());
	}

}
