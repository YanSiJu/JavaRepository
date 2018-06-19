<<<<<<< HEAD
package cn.ccsu.entity;

public class ConstructionTeam {

	private String task;
	private int id;
	private int projectId;
	public String getTask() {
		return task;
	}
	@Override
	public String toString() {
		return "ConstructionTeam [task=" + task + ", id=" + id + ", projectId=" + projectId + ", getTask()=" + getTask()
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getProjectId()=" + getProjectId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + projectId;
		result = prime * result + ((task == null) ? 0 : task.hashCode());
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
		ConstructionTeam other = (ConstructionTeam) obj;
		if (id != other.id)
			return false;
		if (projectId != other.projectId)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
=======
package cn.ccsu.entity;

public class ConstructionTeam {

	private String task;
	private int id;
	private int projectId;
	public String getTask() {
		return task;
	}
	@Override
	public String toString() {
		return "ConstructionTeam [task=" + task + ", id=" + id + ", projectId=" + projectId + ", getTask()=" + getTask()
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getProjectId()=" + getProjectId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + projectId;
		result = prime * result + ((task == null) ? 0 : task.hashCode());
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
		ConstructionTeam other = (ConstructionTeam) obj;
		if (id != other.id)
			return false;
		if (projectId != other.projectId)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
>>>>>>> 4c95842e54af405a20c2d0efa74e5f0893824e2a
