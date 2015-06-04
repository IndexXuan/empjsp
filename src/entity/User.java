package entity;

public class User {
	private long id;
	private String username;
	private String name;
	private String pwd;
	private String gendar;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
}
