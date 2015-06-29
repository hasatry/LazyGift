package com.nju.model;

public class Good {
	private long id;
	private int level;
	private long parentId;
	private String name;
	private String pos;
	private String remark;
	private int num;
	
	public Good(long id,int level,long parentId,String name,String pos,String remark,int num){
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.pos = pos;
		this.remark = remark;
		this.num = num;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
