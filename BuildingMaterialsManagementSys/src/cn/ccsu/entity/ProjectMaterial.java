<<<<<<< HEAD
package cn.ccsu.entity;

public class ProjectMaterial {

	private int projectId;
	private int materialId;
	private int quantity;
	public int getProjectId() {
		return projectId;
	}
	@Override
	public String toString() {
		return "ProjectMaterial [projectId=" + projectId + ", materialId=" + materialId + ", quantity=" + quantity
				+ ", getProjectId()=" + getProjectId() + ", hashCode()=" + hashCode() + ", getMaterialId()="
				+ getMaterialId() + ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + materialId;
		result = prime * result + projectId;
		result = prime * result + quantity;
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
		ProjectMaterial other = (ProjectMaterial) obj;
		if (materialId != other.materialId)
			return false;
		if (projectId != other.projectId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
=======
package cn.ccsu.entity;

public class ProjectMaterial {

	private int projectId;
	private int materialId;
	private int quantity;
	public int getProjectId() {
		return projectId;
	}
	@Override
	public String toString() {
		return "ProjectMaterial [projectId=" + projectId + ", materialId=" + materialId + ", quantity=" + quantity
				+ ", getProjectId()=" + getProjectId() + ", hashCode()=" + hashCode() + ", getMaterialId()="
				+ getMaterialId() + ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + materialId;
		result = prime * result + projectId;
		result = prime * result + quantity;
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
		ProjectMaterial other = (ProjectMaterial) obj;
		if (materialId != other.materialId)
			return false;
		if (projectId != other.projectId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
>>>>>>> 4c95842e54af405a20c2d0efa74e5f0893824e2a
