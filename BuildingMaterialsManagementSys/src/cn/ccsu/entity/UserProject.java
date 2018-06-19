<<<<<<< HEAD
package cn.ccsu.entity;

public class UserProject {

	private int id;
	private int materialId;
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + materialId;
		result = prime * result + projectId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProject other = (UserProject) obj;
		if (id != other.id)
			return false;
		if (materialId != other.materialId)
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserProject [id=" + id + ", materialId=" + materialId + ", projectId=" + projectId + ", getId()="
				+ getId() + ", hashCode()=" + hashCode() + ", getMaterialId()=" + getMaterialId() + ", getProjectId()="
				+ getProjectId() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	private int projectId;
}
=======
package cn.ccsu.entity;

public class UserProject {

	private int id;
	private int materialId;
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + materialId;
		result = prime * result + projectId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProject other = (UserProject) obj;
		if (id != other.id)
			return false;
		if (materialId != other.materialId)
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserProject [id=" + id + ", materialId=" + materialId + ", projectId=" + projectId + ", getId()="
				+ getId() + ", hashCode()=" + hashCode() + ", getMaterialId()=" + getMaterialId() + ", getProjectId()="
				+ getProjectId() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	private int projectId;
}
>>>>>>> 4c95842e54af405a20c2d0efa74e5f0893824e2a
