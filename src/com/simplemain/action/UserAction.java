package com.simplemain.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.simplemain.bean.User;

public class UserAction extends ActionSupport
{
	private static final long serialVersionUID = 2203577571562817131L;

	private String name;
	private String action;
	private List<User> users = new ArrayList<>();
	
	@Override
	public String execute()
	{
		
		try (final Connection conn = DriverManager.getConnection("proxool.mysql-query");)
		{
			// 添加用户
			if ("add".equals(action))
			{
				if (name != null && !name.trim().equals(""))
				{
					String sql = "insert into user (id, name) values (null, ?)";
					try (PreparedStatement ps = conn.prepareStatement(sql))
					{
						ps.setString(1, name);
						ps.executeUpdate();
					}
				}
			}
			
			String sql = "select * from user order by id desc";
			
			try (
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
				)
			{
				
				while (rs != null && rs.next())
				{
					final int id      = rs.getInt("id");
					final String name = rs.getString("name");
					
					final User user   = new User();
					user.setId(id);
					user.setName(name);
					
					users.add(user);
				}
			}
		} 
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public List<User> getUsers()
	{
		return users;
	}
}
